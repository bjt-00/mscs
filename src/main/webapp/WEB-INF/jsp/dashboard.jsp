<jsp:include page="structure/header.jsp"/>

	<div style="text-align:center">
		<h2>
			Dashboard -- ${(not empty view ?view:"welcome")}--<br> <br>
			
			<jsp:include page="${(not empty view ?view:'welcome')}.jsp"/>
		</h2>
	</div>
