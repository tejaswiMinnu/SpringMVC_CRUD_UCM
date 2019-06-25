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
import com.lec.spring_model.Product; 


@Controller
public class ProductController {

	private BDao dao = new BDao();
	
	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String showProduct(Model m){
		
		ArrayList<Product> products = dao.getProducts();
		m.addAttribute("products", products);
		System.out.println(products.toString());
		return "showProducts";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute("product") Product p, HttpServletRequest http){
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("product") Product p, BindingResult result, HttpServletRequest http, Model m){

		if (result.hasErrors()) {
			
			return "addProduct";
		}
		
		else {
			dao.saveProduct(p);
			ArrayList<Product> products = dao.getProducts();
			m.addAttribute("products", products);
			return "showProducts";
		}
	}
}
