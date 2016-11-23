package edu.mum.ea.crs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import edu.mum.ea.crs.data.domain.User;
import edu.mum.ea.crs.enumeration.Role;
import edu.mum.ea.crs.service.UserService;




@Controller
public class LoginController extends GenericController {
	private static Logger logger = LogManager.getLogger();
	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginForm(ModelMap model) {
		model.addAttribute("view","login");		
		return "dashboard";		
	}
	
	@RequestMapping(value="/loginSucess")
	public String loginSucess(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		logger.info(authentication + "=====" + authentication.getName());
		return "redirect:/cars";
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.GET)
	public String signUp(@ModelAttribute("user")User user, ModelMap model){
		super.model = model;
		return getView("user/signUpForm");
	}
	
		
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String afterSignUp(@Valid @ModelAttribute("user")  User user,BindingResult bindingResult,ModelMap model ){
		super.model = model;
		if (bindingResult.hasErrors()) {
			setMessage("Error in Form");
			return getView("user/signUpForm");
        }
		else{
		user.getAccount().setRole(Role.ADMIN);
		user.getAccount().setActive(true);
		userService.save(user);
		setMessage("Account created successfully, You can login with new account");
		return getView("login");
		}
	}
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logoutPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		 super.model = model;
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			setMessage("Logged out successfully");
			 return getView("login");
	 }
	
}
