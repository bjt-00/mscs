package edu.mum.ea.crs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.crs.data.domain.User;




@Controller
public class LoginController {
	
	

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginForm(ModelMap model){
		/*User user = new User();
		Account account = new Account();
		account.setPassword("user");
		account.setUsername("user");
		account.setRole(Role.USER);
		account.setActive(true);
		user.setAccount(account);
		userService.save(user);*/
	//	System.out.println("LOgin Form");
		model.addAttribute("view","login");
		
		return "dashboard";
		
	}
	
	@RequestMapping(value="/loginSucess")
	public String loginSucess(ModelMap model) { 
		//model.addAttribute("view","loginSucess");
		System.out.println("Call login sucess");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(authentication + "=====" + username);
		return "dashboard";
 
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public String signUp(ModelMap model){
		System.out.println("Get signUp Form");
		model.addAttribute("view","signUp");
		return "dashboard";
	}
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return "redirect:/login";
	 }
	/*	
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String afterSignUp(@ModelAttribute("user") User user,RedirectAttributes redirectAttributes ){
		
		//userService.save(user);
		System.out.println("User Saved");
		redirectAttributes.addFlashAttribute("user",user);
		return "dashboard";
	}*/
}
