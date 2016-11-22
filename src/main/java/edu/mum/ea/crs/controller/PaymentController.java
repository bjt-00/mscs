package edu.mum.ea.crs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.data.domain.Payment;
import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.model.UserBean;
import edu.mum.ea.crs.service.PaymentService;
import edu.mum.ea.crs.service.ReservationService;

@Controller
@RequestMapping(value="payment")
public class PaymentController extends GenericController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	private static final String PAYMENT_BY_CASH="Cash";
	private static final String PAYMENT_BY_BANK="Bank";
	private static final String PAYMENT_BY_PAYPAL="PayPal";
	private static final String PAYMENT_STATUS_PAID="Paid";
	private static final String PAYMENT_STATUS_INPROGRESS="Inprogress";
	

	@Resource
	PaymentService service;
	@Autowired 
	private ReservationService reservationService;
	

	 @RequestMapping(value = "/paymentForm", method = RequestMethod.GET)
	   public ModelAndView edit(ModelMap model, HttpServletRequest req) {
	       super.model=model;
	       //TODO get reservation ID 
	       Payment payment = new Payment();//service.getPaymentById(id);
	       //Currently the redirect to other controller doesn't work
	       String resId = req.getParameter("rid");
			if (resId != null && resId.matches("^[0-9]")) {
				//TODO get Current user
				//User user = userService.findAll().get(0);
				Reservation reservation = reservationService.findByID(Long.parseLong(resId));
				payment.setReservationId(reservation.getId());
			    payment.setUserId(reservation.getCar().getId());
			    payment.setAmountPayable(reservation.calAmount());
			}
//	       payment.setReservationId(1L);
//	       payment.setUserId(1L);
//	       payment.setAmountPayable(576);
	       model.addAttribute("payment",payment);
	       return new ModelAndView(getView("car/paymentForm"), "command", new UserBean());
	   }
	 @RequestMapping(value = "/byCash", method = RequestMethod.POST)
	   public ModelAndView byCash(@Valid @ModelAttribute("payment")Payment payment,ModelMap model) {
	       super.model=model;
	       payment.setPaymentMode(PAYMENT_BY_CASH);
	       payment.setPaymentStatus(PAYMENT_STATUS_PAID);
	       service.update(payment);
	       model.addAttribute("payment",payment);
	       setMessage("Payment By Cash is made successfully");
	       return new ModelAndView(getView("car/paymentForm"), "command", new UserBean());
	   }
	 @RequestMapping(value = "/byBank", method = RequestMethod.POST)
	   public ModelAndView byBank(@Valid @ModelAttribute("payment")Payment payment,ModelMap model) {
	       super.model=model;
	       payment.setPaymentMode(PAYMENT_BY_BANK);
	       payment.setPaymentStatus(PAYMENT_STATUS_PAID);
	       service.update(payment);
	       model.addAttribute("payment",payment);
	       setMessage("Payment By Bank is made successfully");
	       return new ModelAndView(getView("car/paymentForm"), "command", new UserBean());
	   }

}
