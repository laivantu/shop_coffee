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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.PosCustomerDAO;
import entities.PosCustomer;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	PosCustomerDAO customerDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("customerList", customerDAO.findAll());
		
		return "admin/customer/index";
	}
	
	// save or update
		// 1. @ModelAttribute bind form value
		@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
		public String saveOrUpdate(HttpServletRequest request, @RequestParam("file") MultipartFile file, @ModelAttribute("customerForm") PosCustomer customer,
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
			customer.setImage("/public/" + file.getOriginalFilename());

			customerDAO.saveOrUpdate(customer);

			// POST/REDIRECT/GET
			return "redirect:/customer.html";
			// POST/FORWARD/GET
			// return "user/list";

		}
		
		// show add form
			@RequestMapping(value = "/add", method = RequestMethod.GET)
			public String showAddForm(HttpServletRequest request, Model model) {

				System.out.println("vao add form");
	/*			MultipartFile file = null;
				
				model.addAttribute("file", file);*/
				PosCustomer customer = new PosCustomer();
 
				if(null != customer.getImage()) {
					customer.setImage(request.getContextPath() + customer.getImage());
				}else {
					customer.setImage(request.getContextPath() + "/images/avatar.png");
				}
				
				model.addAttribute("customerForm", customer);

				return "admin/customer/customerForm";

			}

			// show update form
			@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
			public String showUpdateForm(HttpServletRequest request, @PathVariable("id") int id, Model model) {

				System.out.println("vao update form");
				PosCustomer customer = customerDAO.findById(id);
				
				if(null != customer.getImage()) {
					customer.setImage(request.getContextPath() + customer.getImage());
				}else {
					customer.setImage(request.getContextPath() + "/images/avatar.png");
				}
				
				model.addAttribute("customerForm", customer);

				return "admin/customer/customerForm";

			}

			// delete
			@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
			public String deleteUser(@PathVariable("id") int id) {

				PosCustomer customer = customerDAO.findById(id);

				customerDAO.delete(customer);

				return "redirect:/customer.html";

			}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody String search( ModelMap map, @RequestBody String search) {
		
		System.out.println(search);
		System.out.println("vao ham search");
		
		String JsonData = "{\"id\": \"1\", \"name\": \"lai van tu\" }";
		
		return JsonData;
	}

}
