<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Reservation List</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>
<body>
	<h2>Reservation List</h2>
	
	<input id="txtBookingSearch" type="text" value=""/><span>
	<button id="btnBookingSearch" data-url="${pageContext.request.contextPath}/reservations/search" type="button"> Search</button> </span>		
	
	<span><button class ="linkToUrl" data-url="${pageContext.request.contextPath}/reservations/add" 
		id="btnAddBooking" type="button"> Add </button> </span>
	<table id="tblBookingList">
	<tr>		
		<th>Customer</th>
		<th>Car Description</th>
		<th>Reservation <br/> Start Date</th>
		<th>Reservation <br/> End Date</th>				
		<th>Status</th>
	</tr>	
	<c:forEach var="reservation" items="${reservations}">
		<tr class="linkToUrl" data-url="${pageContext.request.contextPath}/reservations/u/${reservation.id}">
			<td>${reservation.user.fullName}</td>
			<td>${reservation.car.shortDescription}</td>
			<td>${reservation.startDate}</td>
			<td>${reservation.endDate}</td>				
			<td>${reservation.status}</td>
		</tr>
	</c:forEach>	
	</table>	
</body>
</html>