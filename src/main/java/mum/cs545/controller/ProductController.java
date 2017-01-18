package mum.cs545.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.cs545.model.Product;
import mum.cs545.service.OrderService;

@Controller
public class ProductController {
	
	@Autowired
	OrderService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String doGet(){
		return "welcome";
	}
	@RequestMapping(value="/productsList", method=RequestMethod.GET )
	public String productsList(Model model){
		
			model.addAttribute("productsList", service.getAllProducts());
			return "productsList";
		}
	List<Product> productsList;
	@RequestMapping(value="/{productId}/productDetails", method=RequestMethod.GET )
	public String productDetails(@PathVariable("productId") String productId, Model model){
		
			model.addAttribute("product", service.getProductById(productId));
			return "productDetails";
		}

}
