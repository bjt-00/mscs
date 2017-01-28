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
		setCurrentAction(WebConstants.DOMAIN_USER,WebConstants.ACTION_VIEW);
		setView(WebConstants.VIEW_USER_LIST);
		user = new User();
		
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
			setError("One of required field is empty");
			return "userForm";
		}
	}
	@Override
	public String actionListener(String action, User user) {
		setCurrentAction(WebConstants.DOMAIN_USER,action);
		if(isDeleteAction()){
			this.user=user;
			setWarning("Do you really want to delete "+user.getName());
			setView(WebConstants.VIEW_USER_FORM);
		}else if(isDeleteConfirmedAction()){
			delete();
			setCurrentAction(getDomain(),WebConstants.ACTION_VIEW);
			setView(WebConstants.VIEW_USER_LIST);
		}else if(isCreateAction()){
			this.user = new User();
				setView(WebConstants.VIEW_USER_FORM);
		}else if(isEditAction()){
			 this.user = user;
			 setView(WebConstants.VIEW_USER_FORM);
		}else if(isUpdateAction()){
			 update();
			setCurrentAction(getDomain(),WebConstants.ACTION_VIEW);
			setView(WebConstants.VIEW_USER_LIST);
		}else if(isSaveAction()){
			 add();
			setCurrentAction(getDomain(),WebConstants.ACTION_VIEW);
			setView(WebConstants.VIEW_USER_LIST);
		}else if(isCancelAction()){
			setCurrentAction(getDomain(),WebConstants.ACTION_VIEW);
			setView(WebConstants.VIEW_USER_LIST);
		}
		return getView();
	}
	@Override
	public List<User> getList() {
		return usersList;
	}


}
