<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une page generant une citation aleatoire</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.2.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Citation <span id="number"><c:if test="${quote.number > 0}">${quote.number}</c:if></span></h1>
			<p class="lead" style="height: 150px">
				<span id="content">${quote.content}</span> <br /> <span
					style="font-style: italic;" id="author">${quote.author}</span>
			</p>

			<p>
				<div class="btn-group" role="group">
					<c:forEach items="${quote.directions}" var="direction">
					  <button type="button" class="btn btn-lg btn-success direction-button" id="${direction.id}"
							targetIndex="${direction.indexOfDirection}" enabled="${direction.enabled}">${direction.targetLabel}</button>
					</c:forEach>
				</div>
			</p>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/quotes.js"></script>
</body>
</html>