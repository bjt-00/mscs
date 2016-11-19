<jsp:include page="structure/header.jsp"/>

	<div style="text-align:center">
			<jsp:include page="${(not empty view ?view:'welcome')}.jsp"/>
	</div>
