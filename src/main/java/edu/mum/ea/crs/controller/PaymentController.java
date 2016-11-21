package edu.mum.ea.crs.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.ea.crs.data.domain.Payment;
import edu.mum.ea.crs.data.domain.User;
import edu.mum.ea.crs.model.UserBean;
import edu.mum.ea.crs.service.PaymentService;

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
	

	 @RequestMapping(value = "/paymentForm", method = RequestMethod.GET)
	   public ModelAndView edit(ModelMap model) {
	       super.model=model;
	       
	       Payment payment = new Payment();//service.getPaymentById(id);
	       payment.setReservationId(1);
	       payment.setUserId(1);
	       payment.setAmountPayable(576);
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
