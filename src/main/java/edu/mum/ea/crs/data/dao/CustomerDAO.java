package edu.mum.ea.crs.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.crs.data.domain.Customer;


public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
