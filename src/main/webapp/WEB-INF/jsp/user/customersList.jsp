<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body class="Body">
<span class="PageTitle">&nbsp; Customers List</span>
	<table class="sortable" id='tblList'>
	<tr>		
		<th>Customer Id</th>
		<th>Name</th>
		<th>Operations</th>
	</tr>	
	<c:forEach var="customer" items="${customers}">
		<tr onclick="/cars/u/${customer.id}">
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>x</td>
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
         {
	    //    var pager = new Pager('tblList', 10); 
	    //    pager.init(); 
	   //     pager.showPageNav('pager', 'pageNavPosition'); 
	   //     pager.showPage(1);
         }
    </script>
</body>
</html>