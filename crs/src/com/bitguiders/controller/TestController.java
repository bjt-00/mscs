package com.bitguiders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitguiders.model.TestBean;

@Controller
public class TestController {
	
	@RequestMapping(value="/welcome" ,method=RequestMethod.GET)
	public ModelAndView helloWorld() {
		System.out.println("------> entered in controller ");
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		
		return new ModelAndView("welcome", "message", message);
	}
	 @RequestMapping(value = "/inputTest", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("input", "command", new TestBean());
	   }

	 @RequestMapping(value = "/addTest", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")TestBean testBean, 
	   ModelMap model) {
	      model.addAttribute("name", testBean.getName());
	      
	      return "output";
	   }
	/*
	public void sendMessage(){
		JMSService jms = new JMSService();
		jms.sendMessage("test message..");

		SynkReceiver sync = new SynkReceiver();
		sync.startReceiver();
		System.out.println("receiver started");
	}*/
}
