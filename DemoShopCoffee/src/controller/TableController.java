package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PosTableDAO;
import entities.PosTable;

@Controller
@RequestMapping("table")
public class TableController {

	@Autowired
	private PosTableDAO tableDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("tableList", tableDAO.findAll());
		
		return "admin/table/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("tableForm") PosTable table,
			Model model) {

		System.out.println("vao saveOrUpdateUser form");
		tableDAO.saveOrUpdate(table);

		// POST/REDIRECT/GET
		return "redirect:/table.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(Model model) {

			System.out.println("vao add form");
			PosTable table = new PosTable();

			model.addAttribute("tableForm", table);

			return "admin/table/tableForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(@PathVariable("id") int id, Model model) {

			System.out.println("vao update form");
			PosTable table = tableDAO.findById(id);
			model.addAttribute("tableForm", table);

			return "admin/table/tableForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			PosTable table = tableDAO.findById(id);

			tableDAO.delete(table);

			return "redirect:/table.html";

		}

}
