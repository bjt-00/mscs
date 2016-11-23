package edu.mum.ea.crs.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.ea.crs.data.domain.Payment;
import edu.mum.ea.crs.service.PaymentService;

@Controller
@RequestMapping("/gopaypal")
public class PaymentRest {
	private static Logger logger = LogManager.getLogger();
	private static final String PAYMENT_BY_PAYPAL = "PayPal";
	private static final String PAYMENT_STATUS_PAID = "Paid";

	@Autowired
	PaymentService paymentService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Payment updatePayment(@PathVariable int id) {
		logger.info("updatePayment called " + id);
		System.out.println("Call rest paypal " + id);
		Payment payment = paymentService.getPaymentById(id);
		if (payment == null) return new Payment();
		payment.setPaymentMode(PAYMENT_BY_PAYPAL);
		payment.setPaymentStatus(PAYMENT_STATUS_PAID);
		paymentService.update(payment);
		logger.info("Update payment sucessfully");
		return payment;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String test() {		
		return "Test";
	}
}
