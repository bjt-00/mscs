package edu.mum.ea.crs.controller;

import org.springframework.ui.ModelMap;

public class GenericController {

	private static final String VIEW_ATTRIBUTE_NAME="view";
	private static final String VIEW_DASHBOARD="dashboard";
	private static final String VIEW_ATTRIBUTE_MSG="message";
	public ModelMap model;
	public String getView(String view){
		 model.addAttribute(VIEW_ATTRIBUTE_NAME,view);
		return VIEW_DASHBOARD;
	}
	public void setMessage(String message){
		model.addAttribute(VIEW_ATTRIBUTE_MSG,message);
	}
}
