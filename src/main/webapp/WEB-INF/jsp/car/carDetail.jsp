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
	<div> <br/>
	<h3>Car Details</h3>
	</div>
	<div id = "panelCarDetail">
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/cars/save" method="post" id="frmCarDetail">
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
		<td>Rent Per Hour:</td>
		<td><input type="text" name="rentPerHour" value="${car.rentPerHour}"> </td>
		</tr>
		<tr>
		<td>Status:</td>
		<td>
			<select name="status">				
				<c:forEach var="s" items="${carStatus}">
					<c:choose>
						<c:when test="${s eq car.status }">
							<option value="${s}" selected="selected">${s}</option>
						</c:when>
						<c:otherwise>
							<option value="${s}">${s}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</td>
		</tr>
	</table>
	<!-- <input type="submit" value="Save"/> -->
	<input type="button" id="btnCarSave" value="Save"/>
	<input id="btnCarDelete" data-reurl="${pageContext.request.contextPath}/cars"
		data-url="${pageContext.request.contextPath}/cars/remove?id=${car.id}" 
		type="button" value="Delete">
	<input type="button" class ="linkToUrl" data-url="${pageContext.request.contextPath}/cars" value="Cancel"/>
	<input type="hidden" name="id" value="${car.id}">
	</form>
	</div>	
</body>
</html>