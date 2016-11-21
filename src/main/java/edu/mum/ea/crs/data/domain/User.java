package edu.mum.ea.crs.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	private int id;
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String firstName;
    @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String lastName;
    @Email(message = "Invalid email address, e.g. valid email address: example@gmail.com")
	private String email;
    //@Digits(fraction = 0, integer = 12, message = "Incorrect Format, valid e.g. 121212121212")
    //@Pattern(regexp = "^[1-9]\\d{3}-\\d{3}-\\d{4}$", message = "must contain only Numbers and spaces")
    //@Size(min = 10, max = 14)
	private String phone;
	private String address;
	private String role;
	@NotNull
	@NotEmpty(message = "Login Id  cannot be empty")
	private String loginId;
	private String password;
	private boolean active;
	private boolean loggedIn;
	
	private String fullName;
	
 
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

	@Transient
	public String getFullName() {	
		return this.getFirstName() + " " + this.getLastName();
	}
	
	public void setFullName(String fullName) {
		this.firstName = fullName;
	}
}
