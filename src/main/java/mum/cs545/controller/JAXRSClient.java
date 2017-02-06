package mum.cs545.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mum.cs545.model.User;

@Service
public class JAXRSClient {

	public String getJSONList(){
		RestTemplate restTemplate = new RestTemplate();
		String str = restTemplate.getForObject("http://bitguiders.com/rest/list.php", String.class);
		return str;
	}
	public User getJSONUser(){
		RestTemplate restTemplate = new RestTemplate();
		User str = restTemplate.getForObject("http://bitguiders.com/rest/obj.php", User.class);
		return str;
	}
}
