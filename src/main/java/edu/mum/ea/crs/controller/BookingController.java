package edu.mum.ea.crs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.ea.crs.data.domain.Car;

@Controller
public class BookingController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	private static final String MODEL_ATTRIBUTE = "booking";
	private static final String VIEW_DETAIL = "booking/carBookingDetail";
	//private static final String VIEW_LIST = "booking/bookingList";
	
//	@Resource
//	private CarDao carDao;//Will change to booking services
	
	@RequestMapping(value = "/booking/add", method = RequestMethod.POST)
	public String addOrUpdate(@ModelAttribute(MODEL_ATTRIBUTE) Car c, final RedirectAttributes redirectAtt) {
		try {
			if (c.getId() == null) {
				// new add it
				redirectAtt.addFlashAttribute("msg", "Save Successfully");
				logger.info("CarController (addOrUpdate): save new car record");
			} else {
				// existing , call update
				redirectAtt.addFlashAttribute("msg", "Update Successfully");
			}
//			this.carDao.save(c);
		} catch (Exception e) {
			logger.error("BookingController (addOrUpdate): " + e.getMessage());
			logger.info("BookingController (addOrUpdate): update car record" + c.getId());
		}
		return "redirect:/booking/u/" + c.getId();

	}

	@RequestMapping(value = "/booking/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Car c) {
		return VIEW_DETAIL;
	}

}
