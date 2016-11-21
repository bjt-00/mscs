package edu.mum.ea.crs.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.ea.crs.data.domain.User;


public interface UserDAO extends JpaRepository<User, Integer> {

	@Query("select distinct u from User u where u.role='Customer'")
	List<User> findAllCustomers();

}
