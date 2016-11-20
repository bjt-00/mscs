package edu.mum.ea.crs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.model.UserBean;

@Controller
public class PaymentController {
	
	 @RequestMapping(value = "/paymentForm", method = RequestMethod.GET)
	   public ModelAndView paymentForm(ModelMap model) {
		 model.addAttribute("view","car/paymentForm");
		 UserBean bean = new UserBean();
		bean.setView("car/paymentForm");
	      return new ModelAndView("dashboard", "command", bean);
	   }

	 @RequestMapping(value = "/payNow", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")UserBean customerBean, 
	   ModelMap model) {
		 customerBean.setView("output");
	      model.addAttribute("name", customerBean.getName());
	      model.addAttribute("view","output");
	      
	      return "dashboard";
	   }
}
