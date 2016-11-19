package edu.mum.ea.crs.model;



/*@Entity*/
public class Address {
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int id;
	
	private String city;
	
	private String state;
	
	private int zip;
	
	private String address;

	public Address() {
		super();
	}

	public Address(String city, String state, int zip, String address) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
