package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PosSettingDAO;
import dao.PosUserDAO;
import entities.PosUser;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private PosUserDAO userDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("userList", userDAO.findAll());
		
		return "admin/user/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") PosUser user,
			Model model) {

		System.out.println("vao saveOrUpdateUser form");
		userDAO.saveOrUpdate(user);

		// POST/REDIRECT/GET
		return "redirect:/user.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(Model model) {

			System.out.println("vao add form");
			PosUser user = new PosUser();

			model.addAttribute("userForm", user);

			return "admin/user/userForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(@PathVariable("id") int id, Model model) {

			System.out.println("vao update form");
			PosUser user = userDAO.findById(id);
			model.addAttribute("userForm", user);

			return "admin/user/userForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			System.out.println("vao delete form");
			PosUser user = userDAO.findById(id);

			userDAO.delete(user);

			return "redirect:/user.html";

		}
	
}
