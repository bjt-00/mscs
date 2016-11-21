package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.CustomerDAO;
import edu.mum.ea.crs.data.domain.Customer;

@Service
public class CustomerService {
	private static final String ROLE_CUSTOMER="Customer";
	private static final String ROLE_ADMIN="Admin";
	private static final String ROLE_GUEST="Guest";

	@Resource
	CustomerDAO dao;

	public void save(){
		 dao.save(new Customer(0,"Abdul","Kareem","abdul@gmail.com","872 000 0000","1000 N 4th street",
				 ROLE_ADMIN,"abdul","123",true,false));
		 dao.save(new Customer(0,"Khemroat","Loem","khemroat@gmail.com","872 123 0000","Fairfield, Iowa",
				 ROLE_CUSTOMER,"khemroat","123",true,false));
		 dao.save(new Customer(0,"Santosh","Karki","santosh@gmail.com","872 345 0000","Chicago",
				 ROLE_CUSTOMER,"santosh","123",true,false));
	}
	public List<Customer> findAll(){
		return dao.findAll();
	}
	public List<Customer> findAllCustomers(){
		return dao.findAllCustomers();
	}
	public void delete(int id){
		dao.delete(id);
	}
	public void update(Customer customer){
		dao.save(customer);
		
	}
	public Customer getCustomerById(int id){
		return dao.findOne(id);
	}
}
