package mum.cs545.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import mum.cs545.model.User;
import mum.cs545.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String welcome(HttpServletRequest request,@ModelAttribute User user,Model model ){
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null){
		for(Cookie c:cookies){
			model.addAttribute(c.getName(),c.getValue());
		}}
		return "login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public String login(HttpSession session,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			//@RequestParam("rememberMe") String rememberMe,
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute User user,
			Model model){
		   String rememberMe = request.getParameter("rememberMe");
		   
		   		user = service.getUserById(userName, password);
		   
		   		if(service.isValid(user)){
				   user.setRememberMe(rememberMe);
				   
				   if(user.getRememberMe().equals("on")){
					   Cookie userCookie = new Cookie("userName",user.getUserName());
					   userCookie.setMaxAge((60*60*24)*30);//one month expiry
					   
					   Cookie rememberMeCookie = new Cookie("rememberMe",user.getRememberMe());
					   rememberMeCookie.setMaxAge((60*60*24)*30);
					   
					   response.addCookie(userCookie);
					   response.addCookie(rememberMeCookie);
				   }else{
						Cookie[] cookies = request.getCookies();
						
						if(cookies!=null){
						for(Cookie c:cookies){
							c.setMaxAge(0);
							   response.addCookie(c);
						}}
			   
				   	}
					return "welcome";
		   		}else{
		   			model.addAttribute("message", "Invalid user or password");
		   		}
		   return "login";
		}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logut(SessionStatus status,HttpSession session){
		status.setComplete();
		session.invalidate();
		return "redirect:/";
	}
	
	@ModelAttribute("users")
	public List<User> getAllUsers() {
	return service.getAllUsers();
	}
}
