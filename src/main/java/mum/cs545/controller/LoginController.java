package mum.cs545.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.cs545.model.User;
import mum.cs545.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String welcome(HttpServletRequest request,@ModelAttribute User user,
			Model model ){
		return "login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public String login(HttpSession session,
			@RequestParam(value="rememberMe", required=false) String rememberMe,
			@CookieValue(value="userName", defaultValue="") String userName,
			HttpServletResponse response,
			User user,
			Model model){
		   
		   		user = service.getUserById(user.getUserName(), user.getPassword());
		   
		   		if(service.isValid(user)){
				   
				   if(null!=rememberMe && rememberMe.equals("on")){
					   Cookie userCookie = new Cookie("userName",user.getUserName());
					   userCookie.setMaxAge((60*60*24)*30);//one month expiry
					   response.addCookie(userCookie);
				   }else{
					   Cookie userCookie = new Cookie("userName",user.getUserName());
					   userCookie.setMaxAge(0);//one month expiry
					   response.addCookie(userCookie);				   	}
					return "welcome";
		   		}else{
		   			model.addAttribute("message", "Invalid user or password");
		   		}
		   return "login";
		}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logut(SessionStatus status,HttpSession session,RedirectAttributes redirectAttributes){
		status.setComplete();
		session.invalidate();
		redirectAttributes.addFlashAttribute("message", "You are logged out successfully.");
		return "redirect:/";
	}
	
	@ModelAttribute("users")
	public List<User> getAllUsers() {
	return service.getAllUsers();
	}
	
	
}
