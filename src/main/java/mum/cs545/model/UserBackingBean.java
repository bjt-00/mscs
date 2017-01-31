package mum.cs545.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bitguiders.util.jsf.JSFBeanInterface;
import com.bitguiders.util.jsf.JSFBeanSupport;
import com.bitguiders.util.jsf.Navigate;
import com.bitguiders.util.jsf.Navigate.DOMAIN;
import com.bitguiders.util.jsf.WebConstants;

@ManagedBean(name="userBean")
@SessionScoped
@Navigate(domain=DOMAIN.USER)
public class UserBackingBean extends JSFBeanSupport<User> implements JSFBeanInterface<User>  {

//@Inject
//User iUser;

	private List<User> usersList;
	User user;
	@PostConstruct
	public void init(){
		user= new User();
		performAction(this,WebConstants.ACTION.VIEW,user);
		
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
	
	public void delete(){
		usersList.remove(getModel());
		setMessage(getModel().getName()+" "+getModel().getRole()+" is deleted successfully");
	}
	 public void update(){
		usersList.remove(getModel());
		usersList.add(getModel());
		setMessage(getModel().getName()+" updated successfully");
	}
	
	public void add(){
			usersList.add(getModel());
			setMessage(getModel().getName()+" added successfully");
	}
	@Override
	public String actionListener(WebConstants.ACTION action, User user) {
		return performAction(this,action,user);
	}
	@Override
	public List<User> getList() {
		return usersList;
	}


}
