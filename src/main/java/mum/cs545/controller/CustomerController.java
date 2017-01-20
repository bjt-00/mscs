package mum.cs545.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mum.cs545.model.User;
import mum.cs545.service.UserService;

@Controller
@SessionAttributes("user")
public class CustomerController {
	
	@Autowired
	UserService service;
	
	@InitBinder
	public void checkDisallowedFields(WebDataBinder binder){
		binder.setDisallowedFields("password-");
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String welcome(Model model,HttpSession session,SessionStatus status){
		User u = new User();
		model.addAttribute("user", u);
		session.setAttribute("user2", u);
		//status.setComplete();
		//session.invalidate();
		return "customerForm";
	}
	@RequestMapping(value="/customer", method=RequestMethod.POST )
	public String user(@Valid @ModelAttribute("user") User user,BindingResult result){
		
			if(result.hasErrors()){
				return "customerForm";
			}
			if(result.getSuppressedFields().length>0){
				
			}
		   return "customerDetails";
		}
	@RequestMapping(value="/customer", method=RequestMethod.GET )
	public String setLocale(@RequestParam(value="language" ,required=false)String language,@ModelAttribute("user") User user,HttpServletResponse response){
		
		if(null!=language){
			response.setLocale(new Locale(language));
		}
		return "customerForm";
	}
	@ModelAttribute("users")
	public List<User> getAllUsers() {
	return service.getAllUsers();
	}
}
