package edu.mum.ea.crs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.service.ReservationService;

@Controller
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	private static final String MODEL_ATTRIBUTE = "reservation";
	private static final String VIEW_DETAIL = "car/carReservation";
	private static final String VIEW_LIST = "car/reservationList";
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String getAll(Model model, @ModelAttribute("project") Reservation res) {		
		reservationService.save(res);

		model.addAttribute("reservations", reservationService.findAll());
		if (res.getId() == null) {
			res = new Reservation();
		}
		model.addAttribute("view", VIEW_LIST);
		model.addAttribute(MODEL_ATTRIBUTE, res);		
		return "dashboard";
	}
	
	@RequestMapping(value = "/reservations/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute(MODEL_ATTRIBUTE) Reservation res, Model model) {
		try {
			if (res.getId() == null) {
				model.addAttribute("msg", "Save Successfully");
				logger.info("CarController (addOrUpdate): save new car record");
			} else {
				model.addAttribute("msg", "Update Successfully");
			}
			reservationService.save(res);
		} catch (Exception e) {
			logger.error("BookingController (addOrUpdate): " + e.getMessage());		
		}
		return "redirect:/booking/u/" + res.getId();

	}

	@RequestMapping(value = "/reservations/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Reservation res) {
		return VIEW_DETAIL;
	}

}
