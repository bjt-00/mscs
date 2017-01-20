package mum.cs545.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import mum.cs545.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	List<User> usersList;
	public UserRepositoryImpl(){
		usersList = new ArrayList<User>();
		usersList.add(new User("admin","admin","Fairfield","10-03-1983","Male"));
		usersList.add(new User("amina","user","Fairfield","31-12-1983","Female"));
	}
	@Override
	public List<User> getAllUsers() {
		return usersList;
	}
	@Override
	public User getUserById(String id) {
		for(User p:usersList){
			if(p.getUserName().equals(id)){
				return p;
			}
		}
		return null;
	}
	@Override
	public User getUserById(String id,String password) {
		User user = getUserById(id);
			if(user !=null && user.getPassword().equals(password)){
				return user;
			}
		return null;
	}
}
