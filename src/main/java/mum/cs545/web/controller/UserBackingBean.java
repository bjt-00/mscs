package mum.cs545.web.controller;

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

import mum.cs545.dataaccess.orm.User;
import mum.cs545.service.UserService;
import mum.cs545.service.UserServiceImpl;

@ManagedBean(name="userBean")
@SessionScoped
@Navigate(domain=DOMAIN.USER)
public class UserBackingBean extends JSFBeanSupport<User> implements JSFBeanInterface<User>  {

//@Inject
UserService service = new UserServiceImpl();
//User iUser;

	User user;
	@PostConstruct
	public void init(){
		user= new User();
		performAction(this,WebConstants.ACTION.VIEW,user);
	}
	@PreDestroy
	public void clean(){
	}
	
	public UserBackingBean(){}
	
	public void delete(){
		service.delete(getModel());
		setMessage(getModel().getName()+" "+getModel().getRole()+" is deleted successfully");
	}
	 public void update(){
		service.update(getModel());
		setMessage(getModel().getName()+" updated successfully");
	}
	
	public void add(){
			service.add(getModel());
			setMessage(getModel().getName()+" added successfully");
	}
	@Override
	public List<User> getList() {
		return service.getList();
	}


}
