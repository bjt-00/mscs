<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>SignUp Page</title>
</head>
<body>
<br>
	
	<br /> Language : <a href="?lang=en">English</a>|<a href="?lang=np">Nepali</a><br />
	
<br>
<span class="PageTitle">&nbsp; SignUp</span>
	<form:form modelAttribute="user" action="/signUp"
		method="post">
	<input name="id" type="hidden" value="${user.id}">	
	<form:errors path="firstName" cssStyle="color:red" /><br>
		
	<form:errors path="account.username" cssStyle="color:red"></form:errors><br>
UserName:
 <form:input path="account.username" type="text" class="form-control" />
		<br>		
	
	<form:errors path="account.password" cssStyle="color:red" />
		<br>	
Password:
<form:input path="account.password" type="password" class="form-control" />
		<br>
		
		<form:button class="btn btn-default" value="SignUp" name="submit">Submit</form:button>
	</form:form>
	
</body>
</html>