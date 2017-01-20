package mum.cs545.repositories;

import java.util.List;

import mum.cs545.model.User;

public interface UserRepository {

	public List<User> getAllUsers();
	public User getUserById(String id);
	public User getUserById(String id,String password);
}
