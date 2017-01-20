
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.customerForm" text="default text" /></title>
<jsp:include page="imports.jsp"/>
</head>
<body>
<fmt:setLocale value="${param.language}"/>
<h1><spring:message code="label.customerForm"/></h1>

<p>Language : <a href="?language=en_US">English</a> | <a href="?language=ur_PK">
<spring:message code="label.language" /></a>
 | Current Locale : ${pageContext.response.locale}
</p>
<form:form action="customer" method="post" modelAttribute="user" >
  <div class="form-group">
    <label for="userName"><spring:message code="label.userName" text="default text" /></label>
    <form:input  class="form-control" path="userName"  />
    <form:errors path="userName" cssStyle="color:red" />
  </div>
 
 <div class="form-group">
    <label for="address"><spring:message code="label.address" />:</label>
    <form:input  class="form-control" path="address"  />
  </div>
 <div class="form-group">
    <label for="birthDate"><spring:message code="label.birthDate" />:</label>
    <form:input type="date" class="form-control" path="birthDate"  placeholder="MM/DD/YYYY" />
    <form:errors path="birthDate" cssStyle="color:red" />
  </div>
  <div class="form-group">
    <label for="password"><spring:message code="label.password" />:</label>
    <form:password class="form-control"  path="password"  />
    <form:errors path="password" cssStyle="color:red" />
  </div>
  <div class="form-group">
    <label for="sex"><spring:message code="label.sex" />:</label>
    <label><form:radiobutton  path="sex" value="Male" /> <spring:message code="label.male" /></label>
     <label><form:radiobutton path="sex" value="Female" /> <spring:message code="label.female" /></label>
    <form:errors path="sex" cssStyle="color:red" />
  </div>
  <button type="submit" class="btn btn-default"><spring:message code="label.submit" /></button>
</form:form>
</body>
</html>