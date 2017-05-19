package com.bitguiders.util;

	import java.io.File;
	import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.swing.JOptionPane;

	public class LauncherProps {

		String title;
		String url;
		String splash;
		
	  public static void main(String[] args) {
		LauncherProps obj = new LauncherProps();
		//System.out.println("---"+LauncherProps.class.getName());
		//obj.loadResource();
	  }
	  
	  public LauncherProps(){
		  loadResource();
		  //System.out.println(loadProps("resources/launcher-props.txt"));
	  }
	  private void loadResource(){
		  ResourceBundle bundle = ResourceBundle.getBundle("launcher-props");
		  Enumeration bundleKeys = bundle.getKeys();

		  while (bundleKeys.hasMoreElements()) {
		      String key = (String)bundleKeys.nextElement();
		      String value = bundle.getString(key);
		      System.out.println("key = " + key + ", " + "value = " + value);
		  }
		  
		  this.title = bundle.getString("title");
		  this.url   = bundle.getString("url");
		  this.splash =bundle.getString("splash");
	  }
	  

	  public String getTitle(){
		  return title;
	  }
	  public String getURL(){
		  return url;
	  }
	  public String getSplash(){
		  return splash;
	  }
	}