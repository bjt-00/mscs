package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.CustomerDAO;
import edu.mum.ea.crs.data.domain.User;

@Service
public class CustomerService {

	@Resource
	CustomerDAO dao;

	public List<User> findAllCustomers(){
		return dao.findAllCustomers();
	}
	public void delete(int id){
		dao.delete(id);
	}
	public void update(User user){
		dao.save(user);
		
	}
	public User getCustomerById(int id){
		return dao.findOne(id);
	}
}
