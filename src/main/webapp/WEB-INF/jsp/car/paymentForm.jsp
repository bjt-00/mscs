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
		<form id="frmPayment" action="${pageContext.request.contextPath}/payment/byCash" method="post">
			<input name="id" id ="paymentid" type="hidden" value="${payment.id}">
 		 <div class="row">
			<div class="col-lg-12">
			<div class="alert alert-info" >
 				 <strong>Info!</strong> It assumes you have paid amount at counter.
			</div>
			</div>
 		</div>
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
        Payment By Bank</a>
      </h4>
    </div>
    <div id="collapse2" class="panel-collapse collapse">
      <div class="panel-body">
		<form action="${pageContext.request.contextPath}/payment/byBank" method="post">
			<input name="id" type="hidden" value="${payment.id}">
 
 		 <div class="row">
			<div class="col-lg-12">
			<div class="alert alert-info" >
 				 <strong>Info!</strong> It assumes you have paid amount at Bank Account FFB897654231.
 				 And You have Bank Receipt with you.
			</div>
			</div>
 		</div>
      
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
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse3" data-murl="${pageContext.request.contextPath}/payment/byPaypal" class="clsPaynow">
        Payment By PayPal</a>
      </h4>
    </div>
    <div id="collapse3" class="panel-collapse collapse">
      <div class="panel-body">
 
  		 <div class="row">
			<div class="col-lg-12">
			      <a class="btn btn-default paypaylink" style="font-family:verdana;color:#ffffff;background-color:orange;font-size:14px;padding-left:5px;padding-right:5px;border:1px solid #e1e1e1;" 
			      href="https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=DNB4QB9XHGYJ2&lc=AE&item_name=CRS : Car Reservation System&amount=${payment.amountPayable}&no_note=1&cn=Add%20special%20instructions%20to%20the%20seller%3a&no_shipping=1&rm=1&return=http%3a%2f%2fwww%2ethesuffah%2eorg%2fsuccess&cancel_return=http%3a%2f%2fwww%2ethesuffah%2eorg%2fcancel&currency_code=USD&bn=PP%2dDonationsBF%3abug_rollover%2epng%3aNonHosted" target="_new" title="PayPal payment" > Pay Now </a>
			</div>	
		</div>
      
      
      </div>
    </div>
  </div>
</div>
</body>
</html>