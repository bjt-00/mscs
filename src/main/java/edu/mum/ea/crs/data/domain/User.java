package edu.mum.ea.crs.data.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient; 

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	
	@OneToOne
	private Address address;

	
	/*private String role;
	private String loginId;
	private String password;
	private boolean loggedIn;*/

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User(){
		
	}
	public User(int id,String firstName,String lastName,String email,String phone,String address,
			String role,String loginId,String password,boolean active,boolean loggedIn){
		this.id = id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phone=phone;
		/*this.address=address;
		this.role=role;
		this.loginId=loginId;
		this.password=password;
		this.active=active;
		this.loggedIn=loggedIn;*/
	} 
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

	@Transient
	public String getFullName() {	
		return this.getFirstName() + " " + this.getLastName();
	}
	
	public void setFullName(String fullName) {
		this.firstName = fullName;
	}

}
