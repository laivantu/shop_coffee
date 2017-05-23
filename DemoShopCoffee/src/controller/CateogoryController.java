package controller;


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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import dao.PosCategoryDAO;
import entities.PosCategory;

@Controller
@RequestMapping("category")
public class CateogoryController {

	@Autowired
	private PosCategoryDAO categoryDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("categoryList", categoryDAO.findAll());
		
		
		return "admin/category/index";
	}
	
	// save or update Category
		// 1. @ModelAttribute bind form value
		// 3. RedirectAttributes for flash value
		@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
		public String saveOrUpdateUser(HttpServletRequest request, Model model, @RequestParam("file") MultipartFile file,  @ModelAttribute("categoryForm") PosCategory category) {
			
			if(file == null) {
				System.out.println("file null");
			}
			System.out.println("name :" + category.getCategoryName());
			
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

			category.setImage("/public/" + file.getOriginalFilename());
			categoryDAO.saveOrUpdate(category);

			// POST/REDIRECT/GET
			return "redirect:/category.html";

			// POST/FORWARD/GET
			// return "user/list";

		}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(Model model, HttpServletRequest request) {

			System.out.println("vao add form");
/*			MultipartFile file = null;
			
			model.addAttribute("file", file);*/
			PosCategory category = new PosCategory();
			
			if(null != category.getImage()) {
				category.setImage(request.getContextPath() + category.getImage());
			}else {
				category.setImage(request.getContextPath() + "/images/avatar.png");
			}

			model.addAttribute("categoryForm", category);

			return "admin/category/categoryForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(@PathVariable("id") int id, Model model, HttpServletRequest request) {

			System.out.println("vao update form");
			PosCategory category = categoryDAO.findById(id);
			if(null != category.getImage()) {
				category.setImage(request.getContextPath() + category.getImage());
			}else {
				category.setImage(request.getContextPath() + "/images/avatar.png");
			}
			System.out.println("image: " + category.getImage());
			
			model.addAttribute("categoryForm", category);

			return "admin/category/categoryForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			PosCategory category = categoryDAO.findById(id);

			categoryDAO.delete(category);

			return "redirect:/category.html";

		}

}
