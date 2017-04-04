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
		
	  public static void main(String[] args) {
		LauncherProps obj = new LauncherProps();
		//System.out.println("---"+LauncherProps.class.getName());
		obj.loadResource();
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
	  }
	  
	  private String loadProps(String fileName) {

		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
//		File file = new File(fileName);
		System.out.println(file.getAbsolutePath());
		
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if(line.startsWith("title")){
					this.title = line.split("=")[1];
					result.append("Title > ").append(title).append("\n");
				}else if(line.startsWith("url")){
					this.url = line.split("=")[1];
					result.append("URL > ").append(url).append("\n");
				}
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result.toString();

	  }
	  public String getTitle(){
		  return title;
	  }
	  public String getURL(){
		  return url;
	  }
	}