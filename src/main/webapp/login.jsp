<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<jsp:include page="imports.jsp"/>
</head>
<body>
<h1>Login</h1>
	 <form action="login" method="post">
  <div class="form-group">
    <label for="userName">User Name:</label>
    <input type="text" class="form-control" id="userName" name="userName" value="${userName}" required="required"   >
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" id="password" name="password" required="required" value="" autocomplete="off" >
  </div>
  <div class="checkbox">
    <label><input type="checkbox" name="rememberMe" ${rememberMe eq "on" ?"checked":""} > Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
<span style="color:red">${message}</span>
</body>
</html>