<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Payment Form -- ${id}--</h2>
<form:form method="POST" action="payNow.do">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
     <tr>
        <td colspan="2">
            <input type="submit" value="Pay Now"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>