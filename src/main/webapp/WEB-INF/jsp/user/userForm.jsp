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
	
	<h1>Sign Up</h1>
	<form:form modelAttribute="user" action="/signUp"
		method="post">
		
	<form:errors path="firstName" cssStyle="color:red" /><br>
<spring:message code="message.firstName" text="Default Text" />
 <form:input path="firstName" type="text" />
		
		<br>
	
	<form:errors path="lastName" cssStyle="color:red" /><br>
<spring:message code="message.lastName" text="Default Text" />
 <form:input path="lastName" type="text" />
		
		<br>
	
	<form:errors path="phone" cssStyle="color:red" /><br>	
<spring:message code="message.phone" text="Default Text" />
 <form:input path="phone" type="text" />
 <br>

   <form:errors path="email" cssStyle="color:red" /><br>
Email: 
   <form:input path="email" type="text" />
		<br>
		
	<form:errors path="account.username" cssStyle="color:red"></form:errors><br>
UserName:
 <form:input path="account.username" type="text" />
		<br>		
	
	<form:errors path="account.password" cssStyle="color:red" />
		<br>	
Password:
<form:input path="account.password" type="password" />
		<br>
		
	<form:errors path="address.city" cssStyle="color:red" />
		<br>	
City:
<form:input path="address.city" type="text" /> 
		 <br>
	
	<form:errors path="address.state" cssStyle="color:red" /><br>	 
 State:
 <form:input path="address.state" type="text" /> 
		 
		 <br>
		<form:errors path="address.zip" cssStyle="color:red" /><br>
ZIP:
<form:input path="address.zip" type="text" />
		 <br>
		 
	<form:errors path="address.address" cssStyle="color:red" /><br>	
Street Address:
<form:input path="address.address" type="text" />
		 <br>
		
		
		<form:button value="SignUp" name="submit">Submit</form:button>
	</form:form>
	
</body>
</html>