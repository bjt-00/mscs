<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="loginServlet" method="post">
	User Name:<input name="userName" type="text" value="${param.userName}"><br>
	Password:<input name="password" type="password" value="${param.password}"><br>
	<input type="submit" value="Login">
</form>
<span style="color:red">${message}</span>

</body>
</html>