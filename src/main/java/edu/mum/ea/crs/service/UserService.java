package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.ea.crs.data.dao.UserDAO;
import edu.mum.ea.crs.data.domain.User;

@Service
@Transactional
public class UserService {

	@Resource
	UserDAO dao;

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
	public void save(User user){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getAccount().getPassword());
		user.getAccount().setPassword(hashedPassword);
		dao.save(user);
		
	}

	public User findByUserName(String userName) {
		return dao.findByName(userName).get(0);
	}

	public void removeUser(int id) {
		User user = dao.findOne(id);
		user.setDeleted(true);
		dao.save(user);
	}
	
	public List<User> getAllUsers () {
		return dao.getAllUsers();
	}
}
