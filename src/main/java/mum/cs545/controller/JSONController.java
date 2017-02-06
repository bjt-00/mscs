package mum.cs545.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.cs545.model.User;
import mum.cs545.service.UserService;

@Controller
public class JSONController {
	
	@Autowired
	UserService service;
	
	//@Resource(name="java:app/login/JAXRSClient")
	@Autowired
	JAXRSClient client;

	@RequestMapping(value="/json", method=RequestMethod.GET )
	public @ResponseBody String welcome(HttpServletRequest request,@ModelAttribute User user,
			Model model ){
		return client.getJSONList();
	}

	@RequestMapping(value="/json2", method=RequestMethod.GET )
	public @ResponseBody User json2(){
		return client.getJSONUser();
		//return service.getUserById("user");
	}
/*	@RequestMapping(value="/json3", method=RequestMethod.GET )
	public @ResponseBody List<User> json3(){
		
		//return service.getAllUsers();
		return client.retrieveAllUsers();
	}*/
	
}
