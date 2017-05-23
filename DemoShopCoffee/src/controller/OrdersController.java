package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DataOrderDetailDAO;
import dao.DataOrderDAO;
import dao.PosProductDAO;
import entities.DataOrder;
import entities.DataOrderDetail;
import form.OrderForm;


@Controller
@RequestMapping("order")
public class OrdersController {

	@Autowired
	private DataOrderDAO orderDAO;
	
	@Autowired
	private DataOrderDetailDAO orderDetailDAO;
	
	@Autowired
	private PosProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap map) {
		
		List<DataOrderDetail> orderDetails = orderDetailDAO.findAll();
		OrderForm orderForm = new OrderForm();
		
		orderForm.setOrder(new DataOrder());
		orderForm.setOrderDetails(orderDetails);
		
		map.put("orderForm", orderForm);
		
		return "admin/order/index";
	}
	
	// save or update user
	// 1. @ModelAttribute bind form value
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@ModelAttribute("orderForm") OrderForm orderForm,
			Model model) {

		System.out.println("vao saveOrUpdateUser form");
		DataOrder order = orderForm.getOrder();
		order.setCreatedAt(new Date());
		order.setUpdatedAt(new Date());
		
		orderDAO.saveOrUpdate(order);
		
		for (DataOrderDetail detail : orderForm.getOrderDetails()) {
			
			detail.setCreatedAt(new Date());
			detail.setUpdatedAt(new Date());
			detail.setOrderId(order.getOrderId());
			
			orderDetailDAO.saveOrUpdate(detail);
		}
		

		// POST/REDIRECT/GET
		return "redirect:/order.html";
		// POST/FORWARD/GET
		// return "user/list";

	}
	
}
