package edu.mum.ea.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.model.CustomerBean;
import edu.mum.ea.crs.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	 @RequestMapping(value = "/customersList", method = RequestMethod.GET)
	   public ModelAndView getCustomersList(ModelMap model) {
		 model.addAttribute("view","user/customersList");
		 
		 customerService.save();
		 model.addAttribute("customers",customerService.findAll());
		 
		 CustomerBean bean = new CustomerBean();
		bean.setView("user/customersList");
	      return new ModelAndView("dashboard", "command", bean);
	   }

	 @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")CustomerBean customerBean, 
	   ModelMap model) {
		 customerBean.setView("output");
	      model.addAttribute("name", customerBean.getName());
	      model.addAttribute("view","output");
	      
	      return "dashboard";
	   }
}
