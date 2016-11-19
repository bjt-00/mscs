package edu.mum.ea.crs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.crs.model.User;

@Controller
public class UserController {


	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public String addUserForm(@ModelAttribute("user")User user){
		System.out.println("User Add Form");
		return "signUp";
		
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user,RedirectAttributes redirectAttributes){
		System.out.println("User Added");
		return "redirect:/myProfile";
		
	}
	
	@RequestMapping(value="/myProfile",method=RequestMethod.GET)
	public String myProfile(){
		System.out.println("Visit my Profile");
		return "userProfile";
		
	}
}
