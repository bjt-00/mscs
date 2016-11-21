<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>
<br>
	<span class="PageTitle"> User Form</span>
	
	<form action="${pageContext.request.contextPath}/user/update" method="post">
		<input name="id" type="hidden" value="${user.id}">
		<input name="loginId" type="hidden" value="${user.loginId}">
		<input name="password" type="hidden" value="${user.password}">
		
		 <div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="firstName">First Name</label>
					<input name="firstName" value="${user.firstName}" placeholder="First Name" class="form-control" />
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<label for="lastName">Last Name</label>
					<input name="lastName" value="${user.lastName}" placeholder="Last Name" class="form-control" />
				</div>
			</div>	
		</div>
		 <div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="phone">Phone</label>
					<input name="phone"  value="${user.phone}" type="tel" placeholder="000 000 0000" class="form-control" />
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<label for="email">Email</label>
					<input name="email"  value="${user.email}" type="email" placeholder="crs@email.com" class="form-control" />
				</div>
			</div>	
			</div>
		 <div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="role">Role</label>
					<select name="role"  class="form-control" >
						<option value="Admin" ${(user.role eq 'Admin' ?'selected':'')} >Admin</option>
						<option value="Customer" ${(user.role eq 'Customer' ?'selected':'')}>Customer</option>
					</select>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<label for="status">Status</label>
					<select name="status"  class="form-control" >
						<option value="1" ${(user.active?'selected':'')} >Active</option>
						<option value="0" ${(not user.active?'selected':'')}>In Active</option>
					</select>
				</div>
			</div>	
		</div>
		 <div class="row">
			<div class="col-lg-12">
				<div class="form-group">
					<label for="address">Address</label>
					<textarea name="address"  class="form-control" rows="3"  placeholder="Address">${user.address}</textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
			<input type="submit" class="btn btn-default" value="Update">
			<input type="submit" class="btn btn-default" value="Delete" formmethod="get" formaction="${pageContext.request.contextPath}/user/delete?id=${user.id}" >
			<input type="submit" class="btn btn-default" value="Cancel" formmethod="get" formaction="${pageContext.request.contextPath}/user/list" >
		</div>
		</div>
	</form>
</body>
</html>