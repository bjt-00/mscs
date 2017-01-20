package mum.cs545.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@Size(min=6, max=50 , message="{invalidUserName}")
	private String userName;

	@NotEmpty(message="{label.userName}")
	@Size(min=6, max=50 , message="Password should be between {2} and {1} characters")
	private String password;
	private String address;

	@Past(message="Past date is required")
	private Date birthDate;
	@NotEmpty(message="Sex may not be empty")
	private String sex;
	

	public User(){}
	public User(
		String userName,
		String password,String address,String birthDate,String sex){
		this.userName=userName;
		this.password=password;
		this.address=address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String UserName) {
		this.userName = UserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String Address) {
		this.address = (Address==null?"":Address);
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
}
