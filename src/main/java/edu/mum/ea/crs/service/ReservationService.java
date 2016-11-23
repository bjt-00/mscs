package edu.mum.ea.crs.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.ReservationDao;
import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.data.domain.User;
import edu.mum.ea.crs.util.CustomDateFormatter;

@Service
@Transactional
public class ReservationService {
	@Resource
	ReservationDao reservationDao;

	public void save(Reservation reservation) {
		reservationDao.save(reservation);
	}

	public List<Reservation> findAll() {
		return reservationDao.findAll();
	}

	public void remove(Reservation reservation) {
		reservationDao.delete(reservation);
	}

	public void remove(Long id) {
		reservationDao.delete(id);
	}

	public Reservation findByID(Long id) {
		return reservationDao.findOne(id);
	}

	public List<Reservation> getByStatus(String status) {
		return reservationDao.getReservationsByStatus(status);
	}

	public List<Reservation> getByUser(User user) {
		return reservationDao.getReservationsByUser(user);
	}

	public List<Reservation> getByCar(Car car) {
		return reservationDao.getReservationsByCar(car);
	}

	public List<Reservation> getByStartDate(Date startDate) {
		return reservationDao.getReservationsByStartDate(startDate);
	}

	public List<Reservation> getByEndDate(Date endDate) {
		return reservationDao.getReservationsByEndDate(endDate);
	}

	public List<Reservation> findByDatesBetween(Date startDate, Date endDate) {
		return reservationDao.findByDatesBetween(startDate, endDate);
	}
	
	public List<Reservation> getAllByStartDate(Date startDate) {
		return reservationDao.getAllByStartDate(startDate);
	}
	
	public List<Reservation> getTomrrowReservatioin() {
		Calendar c = Calendar.getInstance();		 
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR, 1);
		c.set(Calendar.MINUTE, 1);
		Date startDate = c.getTime();
		Calendar cc = Calendar.getInstance();
		cc.add(Calendar.DATE, 1);
		cc.set(Calendar.HOUR, 23);
		cc.set(Calendar.MINUTE, 59);
		Date endDate = cc.getTime();
		System.out.println(CustomDateFormatter.displayDateTimeFormat(startDate) + "=======" + CustomDateFormatter.displayDateTimeFormat(endDate));
		return reservationDao.getAllForTomorrow(startDate, endDate);
	}
}
