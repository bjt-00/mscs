<jsp:include page="structure/header.jsp"/>

	<div class="Body">
			<jsp:include page="${(not empty view ?view:'welcome')}.jsp"/>
	</div>
<jsp:include page="structure/footer.jsp"/>
	