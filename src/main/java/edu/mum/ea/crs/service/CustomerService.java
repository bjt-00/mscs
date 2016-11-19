package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.CustomerDAO;
import edu.mum.ea.crs.data.domain.Customer;

@Service
public class CustomerService {
	@Resource
	CustomerDAO dao;

	public void save(){
		 dao.save(new Customer(0,"Abdul"));
		 dao.save(new Customer(0,"Khemorat"));
		 dao.save(new Customer(0,"Santosh"));
	}
	public List<Customer> findAll(){
		return dao.findAll();
	}
	
}
