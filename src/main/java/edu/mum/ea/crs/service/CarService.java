package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.CarDao;
import edu.mum.ea.crs.data.domain.Car;
import edu.mum.ea.crs.enumeration.CarStatus;

@Service
@Transactional
public class CarService {
	@Resource
	CarDao carDao;

	public void save(Car car){
		carDao.save(car);
	}
	
	public List<Car> findAll(){
		return carDao.findAll();
	}
	
	public void remove(Car car) {
		carDao.delete(car);
	}
	
	public void remove(Long id) {
		carDao.delete(id);
	}
	
	public Car findByID(Long id) {
		return carDao.findOne(id);
	}
	
	public List<Car> getCarsByStatus(String query, CarStatus status) {
		return carDao.getCarsByStatus(query, status);
	}
	
	public List<Car> getCarsByQuery(String query) {
		return carDao.getCars(query);
	}
	
}
