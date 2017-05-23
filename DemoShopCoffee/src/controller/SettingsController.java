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
import entities.PosSetting;


@Controller
@RequestMapping("setting")
public class SettingsController {

	@Autowired
	private PosSettingDAO settingDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("settingList", settingDAO.findAll());
		
		return "admin/setting/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("settingForm") PosSetting setting,
			Model model) {

		System.out.println("vao saveOrUpdateUser form");
		settingDAO.saveOrUpdate(setting);

		// POST/REDIRECT/GET
		return "redirect:/setting.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(Model model) {

			System.out.println("vao add form");
			PosSetting setting = new PosSetting();

			model.addAttribute("settingForm", setting);

			return "admin/setting/settingForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(@PathVariable("id") int id, Model model) {

			System.out.println("vao update form");
			PosSetting setting = settingDAO.findById(id);
			model.addAttribute("settingForm", setting);

			return "admin/setting/settingForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			PosSetting setting = settingDAO.findById(id);

			settingDAO.delete(setting);

			return "redirect:/setting.html";

		}
}
