<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products List</title>
<jsp:include page="imports.jsp"/>
</head>
<body>
<div class="container">
  <h1>Products List</h1>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Product Name</th>
        <th>Unit Price</th>
        <th>Category</th>
        <th>Manufacturer</th>
        <th>Condition</th>
      </tr>
    </thead>
    <tbody>
<c:forEach items="${productsList}" var="product" >
      <tr>
        <td><a href="${product.productId}/productDetails"  >${product.name}</a></td>
        <td>${product.unitPrice}</td>
        <td>${product.category}</td>
        <td>${product.manufacturer}</td>
        <td>${product.condition}</td>
      </tr>
</c:forEach>

    </tbody>
  </table>
<a class="btn btn-default" href="${pageContext.request.contextPath}"  > Welcome</a>

</div>

</body>
</html>