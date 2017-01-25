package mum.cs545.model;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean(name="user")
public class User {


	private String userName_;
	private String password_;
	private String postConstructMessage;
	private String preDestroyMessage;

	@PostConstruct
	public void init(){
		postConstructMessage="Initiated :) ";
	}
	@PreDestroy
	public void clean(){
		postConstructMessage="Destroyed :( ";
	}
	
	public User(){}
	public User(String userName,String password){
		this.userName_ = userName;
		this.password_ = password;
	}
	public String getUserName() {
		return userName_;
	}
	public void setUserName(String userName) {
		this.userName_ = userName;
	}
	public String getPassword() {
		return password_;
	}
	public void setPassword(String password) {
		this.password_ = password;
	}
	
	public String getMessage(){
		return (null!=userName_ && !"".equals(userName_) ?"Welcome "+userName_:"Please Enter User Name");
		//UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		//viewRoot.setLocale(new Locale("en"));
	}

	public String getPostConstructMessage() {
		return postConstructMessage;
	}
	public String getPreDestroyMessage() {
		return preDestroyMessage;
	}
}
