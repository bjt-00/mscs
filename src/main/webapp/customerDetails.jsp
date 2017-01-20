<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.customerDetails" text="default text" /></title>
<jsp:include page="imports.jsp"/>
</head>
<body>
<h1>${user.userName} <spring:message code="label.customerDetails" /></h1>
<p>Language : <a href="?language=en_US">English</a> 
| <a href="?language=ur_PK"><spring:message code="label.language" /></a>
 | Current Locale : ${pageContext.response.locale}
</p>

	 <form action="customer" method="post">
  <div class="form-group">
    <label for="userName"><spring:message code="label.userName" />:</label>
    ${user.userName}
  </div>
 <div class="form-group">
    <label for="address"><spring:message code="label.address" />:</label>
    ${user.address}
  </div>
 <div class="form-group">
    <label for="birthDate"><spring:message code="label.birthDate" />:</label>
    ${user.birthDate}
  </div>
 <div class="form-group">
    <label for="password"><spring:message code="label.password" />:</label>
    ${user.password}
  </div>
  <div class="form-group">
    <label for="sex"><spring:message code="label.sex" />:</label>
    ${user.sex}
  </div>
</form>
</body>
</html>