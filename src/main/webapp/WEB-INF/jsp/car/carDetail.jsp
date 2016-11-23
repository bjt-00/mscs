<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/CrsCustomTags" prefix="crs"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Detail Page</title>
</head>
<body>
<br>
<span class="PageTitle">&nbsp; Cars Details</span>

	<div> <br/>
	</div>
	<div id = "panelCarDetail">
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<sec:authorize access="hasAuthority('USER') and !hasAuthority('ADMIN') " var="isCustomer" />	
	<form action="${pageContext.request.contextPath}/cars/save" method="post" id="frmCarDetail">
	<table border="1" data-test="${isCustomer}">
		<tr>
			<td>Make:</td>
			<td><crs:input type="text" name="manufacturer" value="${car.manufacturer}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
			<td>Model:</td>
			<td><crs:input type="text" name="carModel" value="${car.carModel}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><crs:input type="text" name="year" value="${car.year}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
			<td>Color:</td>
			<td><crs:input type="text" name="color" value="${car.color}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
			<td>Speed:</td>
			<td><crs:input type="text" name="speed" value="${car.speed}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
			<td>Plate No:</td>
			<td><crs:input type="text" name="plateNo" value="${car.plateNo}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
		<td>Rent Per Hour:</td>
		<td><crs:input type="text" name="rentPerHour" value="${car.rentPerHour}" disabled="${isCustomer}" /> </td>
		</tr>
		<tr>
		<td>Status:</td>
		<td>
			<c:choose >
			<c:when test="${not empty car.id}">
				<input type="text" disabled="disabled" value="${car.status}">
			</c:when>
			<c:otherwise>
				<select name="status">
					<c:forEach var="s" items="${carStatus}">
						<option value="${s}">${s}</option>
					</c:forEach>
				</select>
			</c:otherwise>
			</c:choose>
			<%-- 
			<select name="status" disabled="disabled">				
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
			</select> --%>
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