<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car list Page</title>
</head>
<body>
<br>
<span class="PageTitle">&nbsp; Find a Car to Reserve</span>
<br>
	
	
		<div class="col-lg-12" style="text-align:right">
		&nbsp;
		<sec:authorize access="hasAuthority('ADMIN')">
		<button class ="btn btn-default linkToUrl" data-url="${pageContext.request.contextPath}/cars/add" id="btnAddCar" type="button" style="background-color: orange; color:#ffffff"> Add New Car</button>
		</sec:authorize>
	 </div>
<div class="listing Box">
	<table class="sortable" id='tblList' width="100%">
	<tr>		
	    <th></th>
	</tr>	
	<c:forEach var="car" items="${cars}">
		<tr class="tdClickUrl" data-url="${pageContext.request.contextPath}/cars/u/${car.id}">
			<td>
				<div class="col-lg-4">
				<img alt="" src="${pageContext.request.contextPath}/cars/${car.id}.jpg" width="150" height="100" />
				</div>
				<div class="col-lg-4">
				<span class="btn" style="color:orange;font-size: 25px"> $ ${car.rentPerHour} </span>/Hour
				<br>
				<span class="btn">${car.status}</span> | 
				<c:if test="${car.status != 'NOT AVAILABLE'}">
				<a class="btn btn-default" href="${pageContext.request.contextPath}/cars/reservation/${car.id}" > Reserve </a>
				</c:if>
				</div>
				
				<div class="col-lg-4">
					<ul>
						<li>Manufacturer : ${car.manufacturer}</li>
						<li>Model : ${car.carModel}</li>
						<li>Year : ${car.year}</li>
						<li>Speed : ${car.speed}</li>
					</ul>
				</div>
			</td>
			<%-- <td> <input type="button" class="linkToUrl" data-url="${pageContext.request.contextPath}/reservations/add?cid=${car.id}"
			 id="btnCarReserve" value="Reserve"/></td> reservation--%>  			
		</tr>		 
	</c:forEach>	
	</table>	
				<div id="Pagination" class="pagination"></div>
			<input value="Prev" name="prev_text" id="prev_text" type="hidden"><input value="Next" name="next_text" id="next_text" type="hidden"><input value="10" name="items_per_page" id="items_per_page" class="numeric" type="hidden"><input value="10" name="num_display_entries" id="num_display_entries" class="numeric" type="hidden"><input value="2" name="num_edge_entries" id="num_edge_entries" class="numeric" type="hidden">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTable/filterTable.js"></script>

<script type="text/javascript">
//this script is important So, don't remove it
         var table=document.getElementById('tblList');
         if(table!=null)
         {/*
	        var pager = new Pager('tblList', 10); 
	        pager.init(); 
	        pager.showPageNav('pager', 'pageNavPosition'); 
	        pager.showPage(1);
 	        */
         }
    </script>
    </div>
	
</body>
</html>