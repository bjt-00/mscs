<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginForm</title>
</head>
<body>

 
 <div id="loginform">
		<form action="loginSuccess.do"
			method="post">
			<fieldset>
				<legend>LOGIN</legend>
				<table style="width: 50%; border: none;">
					<tr>
						<td>UserName:<input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password:<input type="password" name="password">
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="keepMe">Remember Me?</td>
					</tr>
					<tr>
						<td><input type="submit" value="LOGIN"></td>
					</tr>
					
					<tr>
						<td>Forgot <a href="resetPassword.do">password?</a></td>
					</tr>
					
					<tr>
						<td>New User <a href="signUp.do">SIGN UP </a></td>
					</tr>
				</table>
			</fieldset>

		</form>
</div>
</body>
</html>