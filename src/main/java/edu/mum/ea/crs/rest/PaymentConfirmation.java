package edu.mum.ea.crs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/paypal")
public class PaymentConfirmation {
	
	@GET
	@Path("/success")
	@Produces(MediaType.TEXT_PLAIN)
	public String success(){
		//TODO PayPal will call this method to update payment details
		return "Payment confirmed for user ";
	}
	@GET
	@Path("/failed")
	@Produces(MediaType.TEXT_PLAIN)
	public String failed(){
		//TODO PayPal will call this method to update payment details
		return "Payment failed";
	}
}
