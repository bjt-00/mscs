package edu.mum.ea.crs.etl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.service.ReservationService;

@Component
@EnableScheduling
public class CarReservationScanner{
	private static Logger logger = LogManager.getLogger();

	@Autowired
	ReservationService service;
	
	//@Autowired private JavaMailSender javaMailSender;
	
	public CarReservationScanner(){
		logger.info("--- Reservation Scanner Initiated ");
	}
	
	//This job will execute once a day and will send email notes one day before reservation
	//Free SMS service could also use here
	//@Scheduled(cron="0 0 23 * * *")
	@Scheduled(cron="0 0/10 * * * *")
	public void sendReservationAlerts(){
		//ApplicationContext context =new ClassPathXmlApplicationContext("spr-servlet.xml");
		//EmailTransmitter mail = (EmailTransmitter) context.getBean("mailMail");
		logger.info("--- sendReservationAlerts strted ");
		List<Reservation> reservations = service.findAll();
		for(Reservation reservation:reservations){
			logger.info("--- sending email to  "+reservation.getUser().getEmail() );
			//mail.sendMail("bitguiders@gmail.com",reservation.getUser().getEmail(), "Car Reservation Alert","msg body");
		}
	}


}
