package com.lec.spring;
 
import java.util.ArrayList; 

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.spring_dao.BDao;
import com.lec.spring_model.Order; 

@Controller
public class OrderController {

	private BDao dao = new BDao();
	
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showOrder(Model m){
		
		ArrayList<Order> orders = dao.getOrders();
		m.addAttribute("orders", orders);
		return "showOrders";
	}
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String getOrder(@ModelAttribute("order") Order o, HttpServletRequest http){
		
		return "addOrder";
	}
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String postOrder(@Valid @ModelAttribute("order") Order o, BindingResult result, HttpServletRequest http, Model m){
		
		if(result.hasErrors()){
			
			return "addOrder";
		}
		else{	
			dao.saveOrder(o);
			ArrayList<Order> orders = dao.getOrders();
			m.addAttribute("orders", orders);
			return "showOrders";
		}
	}
	

}
