package edu.mum.ea.crs.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.enumeration.CarStatus;

public interface CarDao extends JpaRepository<Car, Long> {
	
	List<Car> findCarsByCarModelAndStatusAndYear(String carModel, CarStatus Status, int year);
	
	@Query("select distinct c from Car c where c.manufacturer= :param or c.carModel= :param")
	List<Car> getCars(@Param("param") String param);
	
	@Query("select distinct c from Car c where c.manufacturer= :param or c.carModel= :param and c.status= :status")
	List<Car> getCarsByStatus(@Param("param") String param, @Param("status") CarStatus status);
}
