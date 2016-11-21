package edu.mum.ea.crs.data.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.data.domain.Reservation;
import edu.mum.ea.crs.data.domain.User;

public interface ReservationDao extends JpaRepository<Reservation, Long> {
	
	List<Reservation> getReservationsByStatus(String status);
	List<Reservation> getReservationsByUser(User user);
	List<Reservation> getReservationsByCar(Car car);
	List<Reservation> getReservationsByStartDate(Date startDate);
	List<Reservation> getReservationsByEndDate(Date endDate);
	@Query("select r from Reservation r where r.startDate between ?1 and ?2 and r.endDate between ?1 and ?2")
	List<Reservation> findByDatesBetween(Date startDate, Date endDate);
}
