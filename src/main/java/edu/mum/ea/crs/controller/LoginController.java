package edu.mum.ea.crs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.crs.data.domain.Account;
import edu.mum.ea.crs.data.domain.User;
import edu.mum.ea.crs.enumeration.Role;
import edu.mum.ea.crs.service.UserService;




@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginForm(ModelMap model){
		/*User user = new User();
		Account account = new Account();
		account.setPassword("admin");
		account.setUsername("admin123");
		account.setRole(Role.ADMIN);
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
	public String signUp(@ModelAttribute("user")User user, ModelMap model){
		System.out.println("Get signUp Form");
		model.addAttribute("view","user/userForm");
		return "dashboard";
	}
	
		
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String afterSignUp(@Valid @ModelAttribute("user")  User user,BindingResult bindingResult,ModelMap model ){
		
		if (bindingResult.hasErrors()) {
			System.out.println("Error in the form");
			model.addAttribute("view","user/userForm");
			return "dashboard";
        }
		else{
		user.getAccount().setRole(Role.USER);
		user.getAccount().setActive(true);
		userService.save(user);
		System.out.println("User Saved");
		model.addAttribute("view","login");
		return "dashboard";
		}
	}
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logoutPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			System.out.println("LoggingOut");
			model.addAttribute("view","login");
			return "dashboard";
	 }
	
}
