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
	<h2>List of Car</h2>
	<form action="ea-fp/cars/search">
		<input type="text" value=""/><span><button type="submit"> Search</button> </span>		
	</form>
	<table>
	<tr>		
		<th>Manufacturer</th>
		<th>Year</th>
		<th>Color</th>
		<th>Speed</th>		
		<th>Plate No.</th>		
		<th>Status</th>
	</tr>	
	<c:forEach var="car" items="${cars}">
		<tr onclick="/cars/u/${car.id}">
			<td>${car.manufacturer}</td>
			<td>${car.year}</td>
			<td>${car.color}</td>
			<td>${car.speed}</td>
			<td>${car.plateNo}</td>
			<td>${car.status}</td>
		</tr>
	</c:forEach>	
	</table>	
</body>
</html>