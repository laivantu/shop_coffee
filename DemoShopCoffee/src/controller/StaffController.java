package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PosStaffDAO;
import entities.PosStaff;

@Controller
@RequestMapping("staff")
public class StaffController {

	@Autowired
	private PosStaffDAO staffDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("staffList", staffDAO.findAll());
		
		return "admin/staff/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("staffForm") PosStaff staff,
			Model model) {

		System.out.println("vao saveOrUpdateUser form");
		staffDAO.saveOrUpdate(staff);

		// POST/REDIRECT/GET
		return "redirect:/staff.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(Model model) {

			System.out.println("vao add form");
			PosStaff staff = new PosStaff();

			model.addAttribute("staffForm", staff);

			return "admin/staff/staffForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(@PathVariable("id") int id, Model model) {

			System.out.println("vao update form");
			PosStaff staff = staffDAO.findById(id);
			model.addAttribute("staffForm", staff);

			return "admin/staff/staffForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			PosStaff staff = staffDAO.findById(id);

			staffDAO.delete(staff);

			return "redirect:/staff.html";

		}

}
