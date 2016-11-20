<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Detail Page</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<p><c:out value="${mgs}"/> Test Result </p>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/cars/add" method="post">
	<table border="1">
		<tr>
			<td>Make:</td>
			<td><input type="text" name="manufacturer" value="${car.manufacturer}" /> </td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><input type="text" name="carModel" value="${car.carModel}" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type="text" name="year" value="${car.year}" /> </td>
		</tr>
		<tr>
			<td>Color:</td>
			<td><input type="text" name="color" value="${car.color}" /> </td>
		</tr>
		<tr>
			<td>Speed:</td>
			<td><input type="text" name="speed" value="${car.speed}" /> </td>
		</tr>
		<tr>
			<td>Plate No:</td>
			<td><input type="text" name="plateNo" value="${car.plateNo}" /> </td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>
				<select name="status">
					<option value="0">--Select--</option>
					<option value="1">Available</option>
					<option value="2">Not Available</option>
				</select>
			</td>
		</tr>
	</table>
	<input type="submit" value="Save"/>
	<input id="btnCarDelete" data-url="${pageContext.request.contextPath}/cars/remove?carId=${car.id}" type="button" value="Delete">
	<input type="hidden" name="id" value="${car.id}">
	</form>	
</body>
</html>