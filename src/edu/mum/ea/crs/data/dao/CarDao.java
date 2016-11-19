package edu.mum.ea.crs.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.crs.data.domain.Car;

public interface CarDao extends JpaRepository<Car, Long> {

}
