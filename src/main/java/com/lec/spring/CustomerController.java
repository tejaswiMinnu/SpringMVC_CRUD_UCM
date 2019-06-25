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
import com.lec.spring_model.Customer; 


@Controller
public class CustomerController {

	private BDao dao = new BDao();

	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String showCustomer(Model m){

		ArrayList<Customer> customers = dao.getCustomers(); 
		m.addAttribute("customers", customers);
		return "showCustomers";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getCustomer(@ModelAttribute("customer") Customer c, HttpServletRequest http){

		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("customer") Customer c, BindingResult result, HttpServletRequest http, Model m){	

		if (result.hasErrors()) {

			return "addCustomer";
		}

		else { 
			dao.saveCustomer(c);
			ArrayList<Customer> customers = dao.getCustomers();
			m.addAttribute("customers", customers);
			return "showCustomers";
		}
	}

	@RequestMapping(value = "/content_update", method = RequestMethod.GET)
	public String getUpdateCustomer(@ModelAttribute("content_update") Customer c, HttpServletRequest http, Model m){
		m.addAttribute("content_update", c);
		return "content_update";
	}

	@RequestMapping(value = "/content_update", method = RequestMethod.POST)
	public String updateCustomer(@Valid @ModelAttribute("content_update") Customer c, BindingResult result, HttpServletRequest request, Model m){	

		int id = Integer.parseInt(request.getParameter("cId"));
		String name = request.getParameter("cName");
		String password = request.getParameter("cPassword");  
		Customer customer = new Customer();
		customer.setcId(id);
		customer.setcName(name);
		customer.setcPassword(password);
		BDao dao = new BDao(); 
		dao.updateCustomer(customer);
		if (result.hasErrors()) {

			return "content_update";
		}

		else { 
			dao.updateCustomer(c);
			ArrayList<Customer> customers = dao.getCustomers();
			m.addAttribute("customers", customers);
			m.addAttribute("content_update", customers);
			return "showCustomers";
		}
	}
}
