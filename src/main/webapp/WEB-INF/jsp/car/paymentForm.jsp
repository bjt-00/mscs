<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    
</head>
<body>

	<span class="PageTitle"> Reservation Payment</span>
	
		<div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label>Amount Payable</label>
					<label>${payment.amountPayable}</label>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<label>Customer</label>
					<label>${payment.userId}</label>
					
				</div>
			</div>
		</div>
<div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
        Payment By Cash</a>
      </h4>
    </div>
    <div id="collapse1" class="panel-collapse collapse in">
      <div class="panel-body">
		<form action="${pageContext.request.contextPath}/payment/byCash" method="post">
			<input name="id" type="hidden" value="${payment.id}">
 
 		 <div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="amountPaid">Amount Paid</label>
					<input name="amountPaid" value="${payment.amountPaid}" placeholder="0" class="form-control" />
				</div>
			</div>
			<div class="col-lg-6">
				<input type="submit" class="btn btn-default" value="Amount Paid" formmethod="post" formaction="${pageContext.request.contextPath}/payment/byCash" >
			</div>	
		</div>
		</form>      
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
        Bank Payment</a>
      </h4>
    </div>
    <div id="collapse2" class="panel-collapse collapse">
      <div class="panel-body">
		<form action="${pageContext.request.contextPath}/payment/byBank" method="post">
			<input name="id" type="hidden" value="${payment.id}">
      
 		 <div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="bankPaymentNo">Bank Payment No</label>
					<input name="bankPaymentNo" value="${payment.bankPaymentNo}" placeholder="BRF098765" class="form-control" />
				</div>
			</div>
			<div class="col-lg-6">
				<div class="form-group">
					<label for="amountPaid">Amount Paid</label>
					<input name="amountPaid" value="${payment.amountPaid}" placeholder="0" class="form-control" />
				</div>
			</div>
		</div>
 		 <div class="row">
				<input type="submit" class="btn btn-default" value="Update Payment" formmethod="post" formaction="${pageContext.request.contextPath}/payment/byBank" >
		</div>
      </form>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
        PayPal</a>
      </h4>
    </div>
    <div id="collapse3" class="panel-collapse collapse">
      <div class="panel-body">PayPal</div>
    </div>
  </div>
</div>
</body>
</html>