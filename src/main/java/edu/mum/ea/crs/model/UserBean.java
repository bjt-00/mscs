package edu.mum.ea.crs.model;


import org.springframework.beans.factory.annotation.Value;

public class UserBean extends GenericBean {

	
	@Value("Abdul Kareem")
	private String name="Default";
	
	public UserBean(){
		this.name="Sohail";
		System.out.println("-------> TestBean initiated-------"+name);
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		System.out.println("----> setName = "+name);
		this.name=name;
	}
}
