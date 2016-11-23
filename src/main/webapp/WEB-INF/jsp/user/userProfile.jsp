<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1></h1>
<fieldset>
				<legend>User Profile</legend>
				<table style="width: 50%; border: none;">
					<tr>
						<td>Name:${user.firstName} &nbsp; ${user.lastName}</td>
					</tr>
					<tr>
						<td>Email:${user.email}
						</td>
					</tr>
					<tr>
						<td>Phone:${user.phone}</td>
					</tr>
					
					<tr>
						<td>Address:${user.address.address},${user.address.city},${user.address.state},${user.address.zip}
					</tr> 
				</table>
			</fieldset>
			<a href="/user/edit?id=${user.id}">Edit Profile</a>
</body>
</html>