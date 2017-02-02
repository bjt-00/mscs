package mum.cs545.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.log4j.Logger;

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
private static final Logger logger = Logger.getLogger(UserBackingBean.class);
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

	public void roleChanged(ValueChangeEvent e){
		user = getModel();
		setMessage("Role changed "+(null!=user && user.getRole()!=null?"from "+user.getRole():"")+" to "+e.getNewValue());
		FacesContext.getCurrentInstance().renderResponse();
	}

  public void searchAction(ActionEvent e){
	  setInfo("Searching "+e.getComponent().getId());
  }
  public String action(){
	  setInfo("Link action is called");
	  FacesContext.getCurrentInstance().renderResponse();
	  return "index";
  }
	public void nameChangeListener(ValueChangeEvent e){
		user = getModel();
		if(service.getByName((String)e.getNewValue())!=null){
		setError(e.getNewValue()+" Already Registered, Please chose other one ");
		}else{
			setInfo(e.getNewValue()+" is not registered yet");
		}
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void ajaxListener(AjaxBehaviorEvent event) {
	    //dosomething;
		setInfo("ajax cal received"+event.getPhaseId());
		logger.info("ajax call received"+event.getPhaseId());
	}
}
