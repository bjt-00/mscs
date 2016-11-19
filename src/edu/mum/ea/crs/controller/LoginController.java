package edu.mum.ea.crs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;




@Controller
public class LoginController {
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginForm(ModelMap model){
		 model.addAttribute("view","loginForm");
		System.out.println("User sign up called");
		return "dashboard";
		
	}

	

	
	@RequestMapping(value="/loginSuccess",method=RequestMethod.GET)
	public String loginSucess(){
		System.out.println("User Login Success called");
		return "welcome";
		
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
 		return "loginForm";
 	}
	
	
	
	@RequestMapping(value="/resetPassword",method=RequestMethod.GET)
	public String resetPassword(){
		System.out.println("Password Reset");
		return "resetPasswd";
		
	}
	
	

}
