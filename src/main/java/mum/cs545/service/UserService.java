package mum.cs545.service;

import java.util.List;

import mum.cs545.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(String id);
	public User getUserById(String id,String password);
	public boolean isValid(User user);
}
