$(function() {
	console.log("call linkToUrl");
	var $node = $(".linkToUrl");	
	if($node.length) {
		$node.click(function(e){
			e.preventDefault();	
			window.onbeforeunload = null;
			window.location.href = $(this).data("url");
		});
	}
	
	$("#btnCarSearch").on("click",function() {		
		searchCar();
	});
});

function searchCar(){
	var txtquery = $("input#txtCarSearch").val();
	$.ajax({
		type:"GET",
		url: "/ea-fp/cars/search?query=" + txtquery ,
		cache: false,
		 contentType: "application/json; charset=utf-8",
		//crossDomain: true,
		dataType: 'jsonp',
		success: function(result) {
			console.log("Success");
		},
		error: function(xhr, textStatus, errorThrown){
		alert("Unexpected error "+errorThrown+" textStatus "+textStatus);
		}  
	});	
}