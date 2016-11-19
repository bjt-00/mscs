package edu.mum.ea.crs.model;


/*@Entity(name="role")*/
	public class Role {
		/*@Id
		@GeneratedValue(strategy=GenerationType.AUTO)*/
		private int id;
		
		private User user;
		private String role;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		
	}



