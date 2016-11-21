package edu.mum.ea.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.model.UserBean;
import edu.mum.ea.crs.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	 @RequestMapping(value = "/reservationsList", method = RequestMethod.GET)
	   public ModelAndView getReservationsList(ModelMap model) {
		 model.addAttribute("view","car/reservationsList");
		 model.addAttribute("reservations", reservationService.findAll());
		 UserBean bean = new UserBean();
		bean.setView("car/reservationsList");
	      return new ModelAndView("dashboard", "command", bean);
	  }

}
