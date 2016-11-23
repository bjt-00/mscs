package edu.mum.ea.crs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.Blob;

import edu.mum.ea.crs.data.dao.UserDAO;
import edu.mum.ea.crs.data.domain.User;

@Service
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
		return dao.findByUserName(userName);
	}

}
