package edu.mum.ea.crs.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.ea.crs.data.domain.User;


public interface UserDAO extends JpaRepository<User, Integer> {
	@Query("select distinct u from User u join u.account a where a.username= :username")
	User findByUsername(@Param("username") String username);
}
