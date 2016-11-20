package edu.mum.ea.crs.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.mum.ea.crs.enumeration.CarStatus;

@Entity
public class Car {
	private Long id;
	private String manufacturer;
	private String carModel;
	private int year;
	private String color;
	private int speed;
	private String plateNo;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status")
	private CarStatus status;

	@Id
	@GeneratedValue
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	//@Column(name="car_model")
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public CarStatus getStatus() {
		return status;
	}

	public void setStatus(CarStatus status) {
		this.status = status;
	}

}
