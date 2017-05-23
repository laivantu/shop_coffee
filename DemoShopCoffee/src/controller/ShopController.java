package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.PosShopDAO;
import entities.PosShop;

@Controller
@RequestMapping("shop")
public class ShopController {

	@Autowired
	private PosShopDAO shopDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		map.put("shopList", shopDAO.findAll());
		
		return "admin/shop/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("shopForm") PosShop shop,
			Model model) {

		System.out.println("vao saveOrUpdateUser form");
		shopDAO.saveOrUpdate(shop);

		// POST/REDIRECT/GET
		return "redirect:/shop.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
	// show add form
		@RequestMapping(value = "/add", method = RequestMethod.GET)
		public String showAddForm(Model model) {

			System.out.println("vao add form");
			PosShop shop = new PosShop();

			model.addAttribute("shopForm", shop);

			return "admin/shop/shopForm";

		}

		// show update form
		@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
		public String showUpdateForm(@PathVariable("id") int id, Model model) {

			System.out.println("vao update form");
			PosShop shop = shopDAO.findById(id);
			model.addAttribute("shopForm", shop);

			return "admin/shop/shopForm";

		}

		// delete
		@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
		public String deleteUser(@PathVariable("id") int id) {

			PosShop shop = shopDAO.findById(id);

			shopDAO.delete(shop);

			return "redirect:/shop.html";

		}
}
