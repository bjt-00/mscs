package edu.mum.ea.crs.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.service.CarService;
import edu.mum.ea.crs.service.ReservationService;
import edu.mum.ea.crs.service.UserService;

@Controller
@RequestMapping(value = "reservations")
public class BookingController extends GenericController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	private static final String MODEL_ATTRIBUTE = "reservation";
	private static final String VIEW_DETAIL = "car/carReservation";
	private static final String VIEW_LIST = "car/reservationList";

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private CarService carService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAll(Model model, @ModelAttribute(MODEL_ATTRIBUTE) Reservation res) {
		populateAttribute(model);
		if (res.getId() == null) {
			res = new Reservation();
		}
		model.addAttribute(MODEL_ATTRIBUTE, res);
		return getView(VIEW_LIST, model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute(MODEL_ATTRIBUTE) Reservation res, Model model) {
		try {
			if (res.getId() == null) {
				model.addAttribute("msg", "Save Successfully");
				logger.info("CarController (addOrUpdate): save new record");
			} else {
				model.addAttribute("msg", "Update Successfully");
			}
			reservationService.save(res);
		} catch (Exception e) {
			logger.error("BookingController (addOrUpdate): " + e.getMessage());
		}
		model.addAttribute(MODEL_ATTRIBUTE, res);
		populateAttribute(model);
		return getView(VIEW_DETAIL, model);

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Reservation res, Model model) {
		logger.info("Booking controller detailPage() ");
		populateAttribute(model);
		return getView(VIEW_DETAIL, model);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String remove(Long id, Model model) {
		logger.info("Booking controller remove() ");
		reservationService.remove(id);
		return getView(VIEW_LIST, model);
	}

	@RequestMapping(value = "/u/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model) {
		logger.info("Booking controller get() ");
		model.addAttribute(MODEL_ATTRIBUTE, reservationService.findByID(id));
		populateAttribute(model);
		return getView(VIEW_DETAIL, model);
	}

	private void populateAttribute(Model model) {
		model.addAttribute("cars", carService.findAll());
		model.addAttribute("customers", userService.findAllCustomers());
		String[] status = { Reservation.STATUS_CANCELLED, Reservation.STATUS_COMPLETED, Reservation.STATUS_EXTENDED, Reservation.STATUS_PENDING };
		model.addAttribute("statusList", Arrays.asList(status));
	}

}
