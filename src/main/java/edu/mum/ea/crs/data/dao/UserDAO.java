package edu.mum.ea.crs.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.ea.crs.data.domain.User;


public interface UserDAO extends JpaRepository<User, Integer> {
	@Query("select distinct u from User u join u.account a where a.username= :username")
	public User findByUserName(@Param("username") String username);
	
	@Query("select distinct u from User u join u.account a where a.username= :username")
	public List<User> findByName(@Param("username") String username);
}
