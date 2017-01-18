<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<jsp:include page="imports.jsp"/>
</head>
<body>
<div class="container">
<h1>${product.name} Details</h1>
	<table class="sortable" id='tblList' width="100%">
	<tr>		
	    <th></th>
	</tr>	
		<tr class="tdClickUrl" data-url="${product.productId}/productDetails.do">
			<td>
			<div class="row">
				<div class="col-lg-4">
				<img alt="" src="${pageContext.request.contextPath}/products/${product.productId}.jpg" width="250" height="200" />
				</div>
				<div class="col-lg-4">
				<span class="btn" style="color:orange;font-size: 25px"> $ ${product.unitPrice} </span>
				<br>
				<span class="btn">Discontinued: ${(product.discontinued?"Yes":"No")}</span> |
				<a class="btn btn-default" href="#" > Order </a>
				</div>
	
				<div class="col-lg-4">
					<ul>
						<li>Manufacturer : ${product.manufacturer}</li>
						<li>Category : ${product.category}</li>
						<li>Condition : ${product.condition}</li>
						<li>Units In Stock : ${product.unitsInStock}</li>
						<li>Units In Order : ${product.unitsInOrder}</li>
						<li>Description:${product.description}</li>
					</ul>
				</div>
				</div>
			</td>
		</tr>		 
	</table>	
<br>
<a class="btn btn-default" href="${pageContext.request.contextPath}/productsList.do"  > Products List</a>
</div>
</body>
</html>