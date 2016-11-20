package edu.mum.ea.crs.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String role;
	private String loginId;
	private String password;
	private boolean active;
	private boolean loggedIn;

	public User(){
		
	}
	public User(int id,String firstName,String lastName,String email,String phone,String address,
			String role,String loginId,String password,boolean active,boolean loggedIn){
		this.id = id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.role=role;
		this.loginId=loginId;
		this.password=password;
		this.active=active;
		this.loggedIn=loggedIn;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
