package edu.mum.ea.crs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.data.domain.User;
import edu.mum.ea.crs.model.UserBean;
import edu.mum.ea.crs.service.CustomerService;

@Controller
@RequestMapping(value="customer")
public class CustomerController extends GenericController {
	
	@Autowired
	CustomerService service;
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	   public String getList(ModelMap model) {
		 
		 model.addAttribute("customersList",service.findAllCustomers());
		 super.model=model;
	      return getView("customer/customersList");
	   }

	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public ModelAndView edit(@RequestParam int id,ModelMap model) {
	       super.model=model;
	       User user = service.getCustomerById(id);
	       model.addAttribute("customer",user);
	       return new ModelAndView(getView("customer/customerForm"), "command", new UserBean());
	   }
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	   public ModelAndView update(@Valid @ModelAttribute("customer")User user,ModelMap model) {
	       super.model=model;
	       service.update(user);
	       model.addAttribute("customer",user);
	       setMessage("Customer updated successfully");
	       return new ModelAndView(getView("customer/customerForm"), "command", new UserBean());
	   }

	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public ModelAndView delete(@RequestParam int id,ModelMap model) {
		 super.model=model;
		 setMessage("Selected Customer deleted successfully");
		 
		 service.delete(id);
		 
		 model.addAttribute("id",id);
		 model.addAttribute("customersList",service.findAllCustomers());
	       return new ModelAndView(getView("customer/customersList"), "command", new UserBean());
	   }
}
