package mum.cs545.service.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import mum.cs545.dataaccess.orm.User;

@Named
@Stateless
public class JAXRSClient {
	protected Client client;
	private static final Logger logger =Logger.getLogger(JAXRSClient.class.getName());
	@PostConstruct
	private void init() {
	client = ClientBuilder.newClient();
	}
	@PreDestroy
	private void clean() {
	client.close();
	}
	
	public String createCustomer(User user) {
		if (user == null) {
		logger.log(Level.WARN, "customer is null.");
		return "userForm";
		}
		String navigation;
		Response response =
		client.target("http://localhost:8080/jsf-master-piece/rest/user/create")
		.request(MediaType.APPLICATION_XML)
		.post(Entity.entity(user, MediaType.APPLICATION_XML),
		Response.class);
		if (response.getStatus() == Status.CREATED.getStatusCode()) {
		navigation = "userList";
		} else {
		logger.log(Level.WARN, "couldn''t create customer with ");// +
		//"id {0}. Status returned was {1}",
		//new Object[]{user.getId(), response.getStatus()});
		navigation = "userForm";
		}
		return navigation;
		}
	public String retrieveCustomer(String id) {
		String navigation;
		User user =
		client.target("http://localhost:8080/jsf-master-piece/rest/user/xml")
		.path(id)
		.request(MediaType.APPLICATION_XML)
		.get(User.class);
		if (user == null) {
		navigation = "userForm";
		} else {
		navigation = "userList";
		}
		return navigation;
		}
	public List<User> retrieveAllUsers() {
		List<User> user =
		client.target("http://localhost:8080/jsf-master-piece/rest/user")
		.path("list")
		.request(MediaType.APPLICATION_JSON)
		.get(new GenericType<List<User>>() {});
		
		return user;
		}
	public String getJSONList() {
		
		String json = client.target("http://bitguiders.com/rest/list.php")
		        .request(MediaType.APPLICATION_JSON)
		        .get(String.class);
		return json;
		}
	
	public static void main(String arg[]){
		JAXRSClient c = new JAXRSClient();
		for(User u:c.retrieveAllUsers()){
			logger.info("-- "+u.getName());
			System.out.println("-- "+u.getName());
		}
	}
}
