<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car list Page</title>
</head>
<body>
	<h2>List of Customers</h2>
	<form action="ea-fp/cars/search">
		<input type="text" value=""/><span><button type="submit"> Search</button> </span>		
	</form>
	<table>
	<tr>		
		<th>Customer Id</th>
		<th>Name</th>
	</tr>	
	<c:forEach var="customer" items="${customers}">
		<tr onclick="/cars/u/${customer.id}">
			<td>${customer.id}</td>
			<td>${customer.name}</td>
		</tr>
	</c:forEach>	
	</table>	
</body>
</html>