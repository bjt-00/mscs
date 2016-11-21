package edu.mum.ea.crs.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.crs.data.domain.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

}
