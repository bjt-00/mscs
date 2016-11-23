<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/scripts.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ui.datepicker.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Reservation</title>
</head>
<body>
	<h3>Reservation</h3>
	<div id="panelReservation">
		<c:if test="${not empty msg}">
			<p>${msg}</p>
		</c:if>
		<sec:authorize access="hasRole('ADMIN')" var="isAdmin" />

		<form action="${pageContext.request.contextPath}/reservations/add"
			method="post">
			<table>
				<tr>
					<td>Customer :</td>
					<td>
					<c:choose>
					   <c:when test="${isAdmin}">
						<select name="user">
								<option value="-1">--Select--</option>
								<c:forEach var="cus" items="${customers}">
									<c:choose>
										<c:when test="${cus.id eq reservation.user.id}">
											<option value="${cus.id}" selected="selected">${cus.fullName}</option>
										</c:when>
										<c:otherwise>
											<option value="${cus.id}">${cus.fullName}</option>
										</c:otherwise>
	
									</c:choose>
								</c:forEach>
						</select>
						</c:when>
					 	<c:otherwise>
					 			<select name="user" disabled="disabled">
									<option value="${reservation.user.id}">${reservation.user.fullName}</option>
								</select>
					 	</c:otherwise>
					</c:choose>
					</td>
				</tr>
				<tr>
					<td>Car list:</td>
					<td><select name="car" id="selectResCar" data-url="${pageContext.request.contextPath}/cars/rate">
							<option value="-1">--Select--</option>
							<c:forEach var="c" items="${cars}">
								<c:choose>
									<c:when test="${c.id eq reservation.car.id}">
										<option value="${c.id}" selected="selected">${c.shortDescription}</option>
									</c:when>
									<c:otherwise>
										<option value="${c.id}">${c.shortDescription}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Rent Per Hour:</td>
					<td><input type="text" name="rentPerHour" value="${reservation.car.rentPerHour}" disabled="disabled"> </td>
				</tr>		
				<tr>
					<td>Reservation Start Date:</td>
					<td><input type="text" class="datepicker" id="startDate" name="startDate"
						value="${reservation.displayStartDate}" /></td>
				</tr>
				<tr>
					<td>Reservation End Date:</td>
					<td><input type="text" class="datepicker" id="endDate" name="endDate"
						value="${reservation.displayEndDate}" /></td>
				</tr>
				<tr>
					<td>Status:</td>
					<td><select name="status">
							<option value="">--Select--</option>
							<c:forEach var="s" items="${statusList}">
								<c:choose>
									<c:when test="${s eq reservation.status }">
										<option value="${s}" selected="selected">${s}</option>
									</c:when>
									<c:otherwise>
										<option value="${s}">${s}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="Save" />
			<input type="button" class="linkToUrl"
				data-url="${pageContext.request.contextPath}/reservationsList" value="Cancel" />
			<input type="hidden" name="id" value="${reservation.id}"/>
			<c:if test="${not empty reservation.id}">
				<input type="button" data-url="${pageContext.request.contextPath}/payment/paymentForm?rid=${reservation.id}"
				 value="Pay Now" class="linkToUrl" />
			</c:if>	
		</form>
	</div>
</body>
</html>