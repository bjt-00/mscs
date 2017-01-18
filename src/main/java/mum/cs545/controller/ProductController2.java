package mum.cs545.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mum.cs545.service.OrderService;

@Controller
@SessionAttributes("user")
public class ProductController2 {
	
	@Autowired
	OrderService service;
	
	@RequestMapping(value="/{productId}/productDetails", method=RequestMethod.GET )
	public String productDetails(@PathVariable("productId") String productId,SessionStatus status,HttpSession session, Model model){
			
			//session.setAttribute("user", "Rakesh-2");
			status.setComplete();
		    //model.addAttribute("user","Rakesh");
			model.addAttribute("product", service.getProductById(productId));
			return "productDetails";
		}

}
