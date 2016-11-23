package edu.mum.ea.crs.etl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CarReservationScanner{
	private static Logger logger = LogManager.getLogger();

	public CarReservationScanner(){
		logger.info("--- Reservation Scanner Initiated ");
	}
	@Scheduled(cron="0 0/10 * * * *")
	public void scanReservations(){
		logger.info("--- Reservation Scanner Job Initiated ");
	}

	@Scheduled(cron="0 0/10 * * * *")
	public void calculateReserveHours(){
		//TODO calculateReserveHours for each car
		logger.info("--- Reservation Scanner Job Initiated ");
	}

}
