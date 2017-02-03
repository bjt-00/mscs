package mum.cs545.service.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mum.cs545.dataaccess.orm.User;
import mum.cs545.service.UserService;



@Path("/user")
public class ProfileService {
	
	@Inject
	UserService service;
	
	@Resource(name="java:app/jsf-master-piece/JAXRSClient")
	JAXRSClient client;
	
	@GET
	@Path("/xml/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public User getUserInXML(@DefaultValue("0") @PathParam("id")int id) {
		return service.getById(id); 
	}
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInJSON(@DefaultValue("0") @PathParam("id")int id) {
		return service.getById(id); 
	}
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserList() {
		return service.getList();
	}

	@GET
	@Path("/client")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUserListfromClient() {
		return client.retrieveAllUsers();
	}
	@GET
	@Path("/bitguiders")
	@Produces(MediaType.APPLICATION_JSON)
	public String getJSONList() {
		return client.getJSONList();
	}

	/*@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getUserInJSON(User user) {
		return service.getById(id); 
		return Response.notAcceptable(vs).build();
		return Response.ok(rep, v);
	}*/

}
