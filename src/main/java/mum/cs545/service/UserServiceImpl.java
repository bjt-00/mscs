package mum.cs545.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mum.cs545.dataaccess.orm.User;

@Named
@SessionScoped
public class UserServiceImpl implements UserService, Serializable {

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
	@Override
	public User getByName(String name) {
		
		//User user = getList().stream().filter(u-> name.equals(u.getName())).findAny();
		for(User user:usersList){
			if(name.equals(user.getName())){
				return user;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getById(int id) {
		User user = getList().stream().filter(u-> id == u.getId()).findAny().get();
		return user;
	}

}
