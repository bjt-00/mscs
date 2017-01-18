package mum.cs545.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.cs545.model.Product;
import mum.cs545.service.OrderService;

@Controller
@SessionAttributes("user")
public class ProductController {
	
	@Autowired
	OrderService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String doGet(){
		return "welcome";
	}
	@RequestMapping(value="/productsList", method=RequestMethod.GET )
	public String productsList(HttpSession session,Model model){
		    
		  
		   model.addAttribute("user","Abdul");
		  // session.setAttribute("user", "Rakesh-1");
			model.addAttribute("productsList", service.getAllProducts());
			return "productsList";
		}
}
