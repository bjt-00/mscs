package edu.mum.ea.crs.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.ea.crs.data.domain.User;


public interface UserDAO extends JpaRepository<User, Integer> {

}
