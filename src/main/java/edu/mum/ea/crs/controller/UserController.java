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
import edu.mum.ea.crs.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController extends GenericController {
	
	@Autowired
	UserService userService;
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	   public String getList(ModelMap model) {
		 
		// userService.save();
		 model.addAttribute("usersList",userService.findAll());
		 super.model=model;
	      return getView("user/usersList");
	   }

	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	   public ModelAndView edit(@RequestParam int id,ModelMap model) {
	       super.model=model;
	       User user = userService.getUserById(id);
	       model.addAttribute("user",user);
	       return new ModelAndView(getView("user/userForm"), "command", new UserBean());
	   }
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	   public ModelAndView update(@Valid @ModelAttribute("user")User user,ModelMap model) {
	       super.model=model;
	       userService.update(user);
	       model.addAttribute("user",user);
	       setMessage("User updated successfully");
	       return new ModelAndView(getView("user/userForm"), "command", new UserBean());
	   }

	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public ModelAndView delete(@RequestParam int id,ModelMap model) {
		 super.model=model;
		 setMessage("Selected User deleted successfully");
		 
		 userService.delete(id);
		 
		 model.addAttribute("id",id);
		 model.addAttribute("usersList",userService.findAll());
	       return new ModelAndView(getView("user/usersList"), "command", new UserBean());
	   }
}
