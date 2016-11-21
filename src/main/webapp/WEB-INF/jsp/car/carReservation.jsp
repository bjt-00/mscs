<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Reservation</title>
</head>
<body>
	<form action="/booking/add" method="post">
	<table>
		<tr>
			<td>Customer :</td>
			<td>
				<select name="customer">
				<option value="-1">--Select--</option>
					<c:forEach var="cus" items="${customers}">					
						<option value="${cus.id}">${cus.name}</option>						
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>Car list:</td>
			<td>
				<select name="cars">
				<option value="-1">--Select--</option>
					<c:forEach var="c" items="${cars}">					
						<option value="${c.id}">${c.carModel} ${car.year} ${car.plateNo}</option>						
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>Reservation Start Date: </td>
			<td><input type="date" name="" value="" /></td>
		</tr>
		<tr>
			<td>Reservation End Date: </td>
			<td><input type="date" name="" value="" /></td>
		</tr>
	</table>
	<input type="submit" value="Save"/>	
	</form>	
</body>
</html>