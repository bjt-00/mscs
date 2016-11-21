<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>
<br>
<span class="PageTitle">&nbsp; Customers List</span>
<br>
<div class="listing Box">
	<table class="sortable" id='tblList'>
	<tr>		
		<th>First Name</th>
		<th>Last Name</th>
		<th>Phone</th>
		<th>Email</th>
		<th>login Id</th>
		<th>Role</th>
		<th>Status</th>
		<th>Operations</th>
	</tr>	
	<c:forEach var="user" items="${customersList}">
		<tr>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.phone}</td>
			<td>${user.email}</td>
			<td>${user.loginId}</td>
			<td>${user.role}</td>
			<td>${user.active}</td>
			<td>
			<a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">edit</a>
			<a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">x</a>
			</td>
		</tr>
	</c:forEach>	
	</table>	
	
			<div id="Pagination" class="pagination"></div>
			<input value="Prev" name="prev_text" id="prev_text" type="hidden"><input value="Next" name="next_text" id="next_text" type="hidden"><input value="10" name="items_per_page" id="items_per_page" class="numeric" type="hidden"><input value="10" name="num_display_entries" id="num_display_entries" class="numeric" type="hidden"><input value="2" name="num_edge_entries" id="num_edge_entries" class="numeric" type="hidden">
	
	<script type="text/javascript" src="js/dataTable/filterTable.js"></script>

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