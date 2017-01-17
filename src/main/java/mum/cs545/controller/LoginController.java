package mum.cs545.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.cs545.model.User;
import mum.cs545.service.LoginService;

@Controller
public class LoginController {

	@RequestMapping(value="/loginController", method=RequestMethod.GET )
	public String doGet(){
		return "login.jsp";
	}
	@RequestMapping(value="/loginController", method=RequestMethod.POST )
	public String doPost(@RequestParam("userName") String userName,@RequestParam("password") String password,Model model){
		
		if(LoginService.isValid(userName, password)){
		 model.addAttribute("user", new User(userName,password));
		 return "welcome";
		}else{
			model.addAttribute("message","User Name and/or Password is incorrect.");
			return "login";
		}
	}
}
