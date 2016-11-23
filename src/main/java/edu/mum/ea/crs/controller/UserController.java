package edu.mum.ea.crs.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		 model.addAttribute("usersList",userService.getAllUsers());
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
	   public String update( @ModelAttribute("user")User u,ModelMap model) {
	       //super.model=model;
	       try {
	    	   userService.update(u);
	       } catch (Exception e) {
	    	   System.out.println(e.getMessage());
	       }
	       model.addAttribute("user",u);
	       setMessage("User updated successfully");
	       return "redirect:/user/list";
	   }

	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	   public String delete(@RequestParam int id,ModelMap model) {
		 super.model=model;
		 setMessage("Selected User deleted successfully");
		 userService.removeUser(id);
		 model.addAttribute("id",id);
		 return "redirect:/user/list";
	   // return new ModelAndView(getView("user/usersList"), "command", new UserBean());
	   }
	 
	 @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	    public String userInfo(Model model, Principal principal) {
		 	
		// Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        // After user login successfully.
	        String userName = principal.getName();
	        User u=userService.findByUserName(userName);
	       model.addAttribute("user",u);
	       System.out.println("User Name: "+ u.getFirstName());
	        model.addAttribute("view","user/userProfile");
			return "dashboard";
	        
	        
	    }
}
