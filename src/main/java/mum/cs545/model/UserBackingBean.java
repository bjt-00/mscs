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
public class UserBackingBean extends JSFBeanSupport implements JSFBeanInterface<User>  {

	private User user;
	private List<User> usersList;

	@PostConstruct
	public void init(){
		setCurrentAction(WebConstants.ACTION_VIEW);
		user = new User();
		
		usersList = new ArrayList<User>();
		usersList.add(new User(usersList.size()+1,"Abdul","abdul","Admin"));
		usersList.add(new User(usersList.size()+1,"Rakesh","rakesh","User"));
		usersList.add(new User(usersList.size()+1,"Waqas","waqas","Guest"));
		
		setMessage("Total Users found "+usersList.size());
	}
	@PreDestroy
	public void clean(){
	}
	
	public UserBackingBean(){}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private void delete(){
		usersList.remove(user);
		setMessage(user.getName()+" "+user.getRole()+" is deleted successfully");
	}
	public void update(){
		usersList.remove(user);
		usersList.add(user);
		setMessage(user.getName()+" updated successfully");
	}
	
	public String add(){
		if(null!=user && user.getName()!=null){
			usersList.add(user);
			setMessage(user.getName()+" added successfully");
			return "usersList";
		}else{
			setMessage("One of required field is empty");
			return "userForm";
		}
	}
	@Override
	public String actionListener(String action, User user) {
		setCurrentAction(action);
		if(isDeleteAction()){
			this.user=user;
			setMessage("Do you really want to delete "+user.getName());
			return "userForm";
		}else if(isDeleteConfirmedAction()){
			delete();
			setCurrentAction(WebConstants.ACTION_VIEW);
			return "usersList";
		}else if(isCreateAction()){
			this.user = new User();
			return "userForm";
		}else if(isEditAction()){
			 this.user = user;
			 return "userForm";
		}else if(isUpdateAction()){
			 update();
			setCurrentAction(WebConstants.ACTION_VIEW);
			 return "usersList";
		}else if(isSaveAction()){
			 add();
			setCurrentAction(WebConstants.ACTION_VIEW);
			 return "usersList";
		}else if(isCancelAction()){
			setCurrentAction(WebConstants.ACTION_VIEW);
			 return "usersList";
		}
		return "usersList";
	}
	@Override
	public List<User> getList() {
		return usersList;
	}


}
