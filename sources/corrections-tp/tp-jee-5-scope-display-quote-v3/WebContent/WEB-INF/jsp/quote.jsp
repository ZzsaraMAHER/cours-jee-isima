<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="jumbotron">
		<h3>#<span id="number">${quote.number}</span></h3>
	<p class="lead" style="height: 150px">
		<span id="content">${quote.content}</span> <br /> <span
			style="font-style: italic;" id="author">${quote.author}</span>
	</p>

	<p>
	<div class="btn-group" role="group">
		<c:forEach items="${quote.directions}" var="direction">
			<button type="button" class="btn btn-lg btn-success direction-button"
				id="${direction.id}" targetIndex="${direction.indexOfDirection}"
				enabled="${direction.enabled}">${direction.targetLabel}</button>
		</c:forEach>
	</div>
</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/quotes.js"></script>
