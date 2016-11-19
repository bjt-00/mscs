package edu.mum.ea.crs.model;


/*@Entity*/
public class User {
	
		/*@Id
		@GeneratedValue(strategy = GenerationType.AUTO)*/
		private int id;
		
		private String firstName;
		
		private String lastName;
		
		private String email;
		
		public String password;
		
		public String userName;
		
		/*private Role role;*/
		
		/*private Address address;*/

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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/*public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}*/
		/*public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}*/

	}


