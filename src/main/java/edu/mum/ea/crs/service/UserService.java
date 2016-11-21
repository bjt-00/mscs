package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.UserDAO;
import edu.mum.ea.crs.data.domain.User;

@Service
public class UserService {
	private static final String ROLE_CUSTOMER="Customer";
	private static final String ROLE_ADMIN="Admin";
	private static final String ROLE_GUEST="Guest";

	@Resource
	UserDAO dao;

	public void save(){
		 dao.save(new User(0,"Abdul","Kareem","abdul@gmail.com","872 000 0000","1000 N 4th street",
				 ROLE_ADMIN,"abdul","123",true,false));
		 dao.save(new User(0,"Khemroat","Loem","khemroat@gmail.com","872 123 0000","Fairfield, Iowa",
				 ROLE_CUSTOMER,"khemroat","123",true,false));
		 dao.save(new User(0,"Santosh","Karki","santosh@gmail.com","872 345 0000","Chicago",
				 ROLE_CUSTOMER,"santosh","123",true,false));
	}
	public List<User> findAll(){
		return dao.findAll();
	}
	public void delete(int id){
		dao.delete(id);
	}
	public void update(User user){
		dao.save(user);
		
	}
	public User getUserById(int id){
		return dao.findOne(id);
	}
}
