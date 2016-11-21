package edu.mum.ea.crs.data.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import edu.mum.ea.crs.util.CustomDateFormatter;

@Entity
public class Reservation implements java.io.Serializable {
	private static final long serialVersionUID = -7024749134017144341L;
	public static final String STATUS_CANCELLED = "Cancelled";
	public static final String STATUS_PENDING = "Pending";
	public static final String STATUS_COMPLETED = "Completed";
	public static final String STATUS_EXTENDED = "Extended";
	
	private Long id;
	private Car car;
	private User user;
	private Date startDate;
	private Date endDate;
	private String status;
	@Transient
	private String displayStartDate;
	@Transient
	private String displayEndDate;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplayStartDate() {
		return CustomDateFormatter.displayDateFormat(this.startDate);
	}

	public void setDisplayStartDate(String displayStartDate) {
		this.displayStartDate = displayStartDate;
	}

	public String getDisplayEndDate() {
		return CustomDateFormatter.displayDateFormat(this.endDate);
	}

	public void setDisplayEndDate(String displayEndDate) {
		this.displayEndDate = displayEndDate;
	}
}
