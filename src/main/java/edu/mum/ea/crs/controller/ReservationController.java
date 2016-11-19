package edu.mum.ea.crs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.model.CustomerBean;

@Controller
public class ReservationController {
	
	 @RequestMapping(value = "/reservationsList", method = RequestMethod.GET)
	   public ModelAndView getReservationsList(ModelMap model) {
		 model.addAttribute("view","car/reservationsList");
		 CustomerBean bean = new CustomerBean();
		bean.setView("car/reservationsList");
	      return new ModelAndView("dashboard", "command", bean);
	  }

}
