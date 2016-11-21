package edu.mum.ea.crs.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.ReservationDao;
import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.data.domain.User;

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

	public List<Reservation> getByStatus(short status) {
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
}
