package mum.cs545.service;

import java.util.ArrayList;
import java.util.List;

import mum.cs545.dataaccess.orm.User;

public class UserServiceImpl implements UserService {

	private List<User> usersList;

	public UserServiceImpl(){
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		usersList.add(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		usersList.remove(user);
		usersList.add(user);

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		usersList.remove(user);
	}

	@Override
	public List<User> getList() {
		if(usersList==null){
			usersList = new ArrayList<User>();
			usersList.add(new User(usersList.size()+1,"Abdul","abdul","Admin"));
			usersList.add(new User(usersList.size()+1,"Rakesh","rakesh","User"));
			usersList.add(new User(usersList.size()+1,"Waqas","waqas","Guest"));
			usersList.add(new User(usersList.size()+1,"Sohail","sohail","Guest"));
		}
		// TODO Auto-generated method stub
		return usersList;
	}

}
