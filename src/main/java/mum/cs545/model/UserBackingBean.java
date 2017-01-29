package mum.cs545.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bitguiders.util.jsf.JSFBeanInterface;
import com.bitguiders.util.jsf.JSFBeanSupport;
import com.bitguiders.util.jsf.WebConstants;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBackingBean extends JSFBeanSupport<User> implements JSFBeanInterface<User>  {

//@Inject
//User iUser;

	private List<User> usersList;
	User user;
	@PostConstruct
	public void init(){
		performAction(this,WebConstants.DOMAIN.USER,WebConstants.ACTION.VIEW);
		user= new User();
		
		usersList = new ArrayList<User>();
		usersList.add(new User(usersList.size()+1,"Abdul","abdul","Admin"));
		usersList.add(new User(usersList.size()+1,"Rakesh","rakesh","User"));
		usersList.add(new User(usersList.size()+1,"Waqas","waqas","Guest"));
		
		setInfo("Total Users found "+usersList.size());
	}
	@PreDestroy
	public void clean(){
	}
	
	public UserBackingBean(){}
	
	public User getModel() {
		return (null==user?new User():user);
	}
	public void setModel(User user) {
		this.user = user;
	}
	public void delete(){
		usersList.remove(user);
		setMessage(user.getName()+" "+user.getRole()+" is deleted successfully");
	}
	 public void update(){
		usersList.remove(user);
		usersList.add(user);
		setMessage(user.getName()+" updated successfully");
	}
	
	public void add(){
			usersList.add(user);
			setMessage(user.getName()+" added successfully");
	}
	@Override
	public String actionListener(WebConstants.ACTION action, User user) {
		if(null!=user){
		setModel(user);
		}
		return performAction(this,WebConstants.DOMAIN.USER,action);
	}
	@Override
	public List<User> getList() {
		return usersList;
	}


}
