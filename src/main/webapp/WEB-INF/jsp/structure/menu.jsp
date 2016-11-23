<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

<img id="Logo" src="${pageContext.request.contextPath}/themes/default/images/crs.png" alt="CRS ::: Car Reservtion System" title="CRS ::: Car Reservtion System" />
   
<div class="Menu">        
        <!-- Brand and toggle get grouped for better mobile display -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"></button>
                <div class="navbar-header Menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                 </div>
            <!-- Collect the nav links, forms, and other content for toggling -->

			<div class="collapse navbar-collapse Menu" id="bs-example-navbar-collapse-1">
				<!-- left menu -->
                <ul class="nav navbar-nav">
                <sec:authorize access="hasAuthority('ADMIN')">
                     <li class="${(not empty view and fn:containsIgnoreCase(view, '/user') ?'active':'')}">
                        <a href="${pageContext.request.contextPath}/user/list.do">Users</a>
                    </li>				
					<li
						class="${(not empty view and fn:containsIgnoreCase(view, '/customer') ?'active':'')}">
						<a href="${pageContext.request.contextPath}/customer/list.do">Customers</a>
					</li>				
				</sec:authorize>
				<li class="${(not empty view and fn:containsIgnoreCase(view, 'car/') ?'active':'')}">
                        <a href="${pageContext.request.contextPath}/cars.do">View Cars</a>
                </li>
				<sec:authorize access="hasAuthority('ADMIN') or hasAuthority('USER')">
					<li class="${(not empty view and view eq 'car/paymentForm'?'active':'')}">
                        <a href="${pageContext.request.contextPath}/payment/paymentForm.do">Payment Form</a>
                    </li>
                    <li class="">
                       <a  href="${pageContext.request.contextPath}/reservationsList.do">My Reservations</a>
                    </li>
                </sec:authorize>
                   </ul>
      <!-- right menu  -->     
      <ul class="nav navbar-nav navbar-right">		
		<sec:authorize access="isAnonymous()">
        	<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <sec:authentication var="principal" property="principal" />
        	<li><a href="${pageContext.request.contextPath}/user/userProfile">${principal.username}</a></li>	
        	<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </sec:authorize>
	</ul>
                
                
            </div>
             <!-- /.navbar-collapse -->
  </div>
        <!-- /.container -->
</nav><!-- Half Page Image Background Carousel Header -->
<br><br><br><br>