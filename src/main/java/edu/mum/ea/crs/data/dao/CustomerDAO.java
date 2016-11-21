package edu.mum.ea.crs.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.ea.crs.data.domain.Customer;


public interface CustomerDAO extends JpaRepository<Customer, Integer> {

	@Query("select distinct u from Customer u where u.role='Customer'")
	List<Customer> findAllCustomers();

}
