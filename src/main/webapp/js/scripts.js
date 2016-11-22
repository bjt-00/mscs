$(function() {	
	/*if(("input[id*=Date], .datepicker").length > 0) {
		$.fn.datepicker.defaults.format = 'M dd, yyyy';
		
		$("input[id*=Date], .datepicker").datepicker({
			//datesDisabled: ['06/05/2015', '06/07/2015'],
		 	daysOfWeekDisabled: [0,6],
			changeMonth: true,
			changeYear: true
//			dateFormat: 'M dd, yy'
		});
	}*/
	var $node = $(".linkToUrl");	
	if($node.length) {
		$("body").on("click", ".linkToUrl" ,function(e) {
			e.preventDefault();	
			window.onbeforeunload = null;
			window.location.href = $(this).data("url");
		});
	}
	
	$("#btnCarSearch").on("click",function() {		
		searchCar(this);
	});
	
	$("#btnCarSave").on("click",function() {		
		saveCar(this);
	});
	
	$("#btnCarDelete").on("click",function() {		
		removeCar(this);
	});
	$("select#selectResCar").on("change",function(e) {		
		populateCarRatePerHour(this);
	});	
	
	$("tr.tdClickUrl td:not(.excLink)").on("click",function(e) {
		e.preventDefault();	
		window.onbeforeunload = null;
		window.location.href = $(this).parent().data("url");
	});	
});

function searchCar(data){
	var txtquery = $("input#txtCarSearch").val();
	var _url = $(data).data('url') + '?query=' + txtquery
	$.ajax({
		type:"GET",
		url: _url ,
		//cache: false,
		dataType: 'html',
		success: function(result) {
			var $tblCar = $("table#tblCarList");
			$tblCar.html($($.parseHTML(result)).find("table#tblCarList").html());			
		},
		error: function(xhr, textStatus, errorThrown){
		alert("Unexpected error "+errorThrown+" textStatus "+textStatus);
		}  
	});	
}

function saveCar(data) {
	var $form = $("form#frmCarDetail");
	var actionUrl = $form.attr('action');	
	$.ajax({
		type:"POST",
		url: actionUrl,
	    data: $form.serialize(),
	    dataType: 'html',
	    success: function (data) {
	    	$("div#panelCarDetail").html($($.parseHTML(data)).find("div#panelCarDetail").html());
	    }
	});
}

function removeCar(data){	
	var _url = $(data).data('url');
	$.ajax({
		type:"GET",
		url: _url ,
		cache: false,
		success: function(result) {			
			window.onbeforeunload = null;
			window.location.href = $(data).data("reurl");
		},
		error: function(xhr, textStatus, errorThrown){
		alert("Unexpected error "+errorThrown+" textStatus "+textStatus);
		}  
	});	
}

function populateCarRatePerHour(data) {
	var $el = $(data);
	var id = $el.val();
	if (id >= 0) {
		var actionUrl = $el.data('url');	
		$.ajax({
			type:"get",
			url: actionUrl,
		    data:{
		    	id: id
		    	},
		    success: function (data) {	    	
		    	$("input[name='rentPerHour'").val(data);
		    }
		});
	} else {
		$("input[name='rentPerHour'").val('');
	}
}