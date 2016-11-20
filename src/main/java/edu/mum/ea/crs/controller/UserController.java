package edu.mum.ea.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.model.UserBean;
import edu.mum.ea.crs.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController extends GenericController {
	
	@Autowired
	UserService userService;
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	   public String getUsersList(ModelMap model) {
		 
		 userService.save();
		 model.addAttribute("usersList",userService.findAll());
		 super.model=model;
	      return getView("user/usersList");
	   }

	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public ModelAndView editUser(@RequestParam String id,ModelMap model) {
	       super.model=model;
	       model.addAttribute("id",id);
	       return new ModelAndView(getView("user/userForm"), "command", new UserBean());
	   }

	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public ModelAndView deleteUser(@RequestParam String id,ModelMap model) {
		 super.model=model;
		 setMessage("Selected User deleted successfully "+id);
		 model.addAttribute("id",id);
		 model.addAttribute("usersList",userService.findAll());
	       return new ModelAndView(getView("user/usersList"), "command", new UserBean());
	   }
}
