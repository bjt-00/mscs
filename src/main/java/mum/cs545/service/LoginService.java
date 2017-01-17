package mum.cs545.service;

public class LoginService {

	public static boolean isValid(String userName,String password){
		if(userName.equals("admin") && password.equals("test123")){
			return true;
		}
		return false;
	}
}
