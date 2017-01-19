package mum.cs545.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.cs545.model.User;
import mum.cs545.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> getAllUsers(){
		return repository.getAllUsers();
	}

	@Override
	public User getUserById(String id) {
		return repository.getUserById(id);
	}
	@Override
	public User getUserById(String id,String password) {
		return repository.getUserById(id,password);
	}

	@Override
	public boolean isValid(User user) {
		return (user==null?false:true);
	}

}
