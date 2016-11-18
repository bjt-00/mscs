package com.bitguiders.model;


import org.springframework.beans.factory.annotation.Value;

public class TestBean {

	
	@Value("Abdul Kareem")
	private String name="Default";
	
	public TestBean(){
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
