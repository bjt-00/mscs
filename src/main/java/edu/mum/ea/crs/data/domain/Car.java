package edu.mum.ea.crs.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Car implements java.io.Serializable {	
	private static final long serialVersionUID = -1650132258026653292L;
	public static final String STATUS_AVAILABLE = "AVAILABLE";
	public static final String STATUS_NOT_AVAILABLE = "NOT AVAILABLE";
	
	private Long id;
	private String manufacturer;
	private String carModel;
	private int year;
	private String color;
	private int speed;
	private String plateNo;	
	private String status;
	private double rentPerHour; //rental rate per hour
	private String shortDescription;

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

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getRentPerHour() {
		return rentPerHour;
	}

	public void setRentPerHour(double rentPerHour) {
		this.rentPerHour = rentPerHour;
	}

	@Transient
	public String getShortDescription() {
		return this.getManufacturer() + " " + this.getCarModel() + " " + this.getYear() + this.getColor();
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
}
