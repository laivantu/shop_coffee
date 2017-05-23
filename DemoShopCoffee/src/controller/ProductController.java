package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.PosProductDAO;
import entities.PosProduct;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private PosProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("productList", productDAO.findAll());
		
		return "admin/product/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdateUser(HttpServletRequest request, @RequestParam("file") MultipartFile file, @ModelAttribute("productForm") PosProduct product,
			Model model) {
		
		if (!file.isEmpty()) {
			try {
				
				// Thu muc goc upload file.
				String uploadRootPath = request.getServletContext().getRealPath("/" + "upload");
			       
				File uploadRootDir = new File(uploadRootPath);
				
		       // Tao thu muc goc upload neu no khong ton tai.
		       if (!uploadRootDir.exists()) {
		           uploadRootDir.mkdirs();
		       }

		    // Ten file goc tai Client.
	           String nameFile = file.getOriginalFilename();
	           System.out.println("Client File Name = " + nameFile);
	 
	           //List<File> uploadedFiles = new ArrayList<File>();
	           
	           if (nameFile != null && nameFile.length() > 0) {
	               try {
	                   // T?o file tai Server.
	                   File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + nameFile);
	 
	                   // Luong ghi du lieu vao file tren Server.
	                   BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	                   stream.write(file.getBytes());
	                   stream.close();
	                   //
	                   //uploadedFiles.add(serverFile);
	                   System.out.println("Write file: " + serverFile);
	               } catch (Exception e) {
	               }
	           }


				System.out.println("You successfully uploaded file");
			} catch (Exception e) {
				System.out.println("You failed to upload ");
			}
		} else {
			System.out.println("because the file was empty");
		}
		product.setImage("/public/" + file.getOriginalFilename());

		System.out.println("vao saveOrUpdateUser form");
		productDAO.saveOrUpdate(product);

		// POST/REDIRECT/GET
		return "redirect:/product.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(HttpServletRequest request, Model model) {

			System.out.println("vao add form");
			PosProduct product = new PosProduct();

			if(null != product.getImage()) {
				product.setImage(request.getContextPath() + product.getImage());
			}else {
				product.setImage(request.getContextPath() + "/images/avatar.png");
			}
			model.addAttribute("productForm", product);

			return "admin/product/productForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(HttpServletRequest request, @PathVariable("id") int id, Model model) {

			System.out.println("vao update form");
			PosProduct product = productDAO.findById(id);
			
			if(null != product.getImage()) {
				product.setImage(request.getContextPath() + product.getImage());
			}else {
				product.setImage(request.getContextPath() + "/images/avatar.png");
			}
			
			model.addAttribute("productForm", product);

			return "admin/product/productForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			PosProduct product = productDAO.findById(id);

			productDAO.delete(product);

			return "redirect:/product.html";

		}

}
