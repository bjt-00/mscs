package mum.cs545.dataaccess.orm;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

//@Entity
//@Table(name="CUSTOMER_CUSTOMER")
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)//for var declaritions only. otherwise place annotations on getters
//@NamedQuery(name="findAllCustomers", query="SELECT c FROM Customer c " +"ORDER BY c.id")
public class User implements Serializable {
	final static Logger logger = Logger.getLogger(User.class);

	@XmlAttribute
	private int id;
	@XmlElement(required=true)
	private String name;
	@XmlElement(required=true)
	private String password;
	private Date   dateOfBirth;
	@XmlElement(required=true)
	private String SSN;
	private String role;
	
	public User(){}
	public User(int id,String name,String password,String role){
		this.id=id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
		logger.info("Role changed to "+role);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
}
