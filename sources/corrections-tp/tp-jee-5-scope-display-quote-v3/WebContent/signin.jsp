<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Page de login pour l'application</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<link href="${pageContext.request.contextPath}/css/signin.css"
	rel="stylesheet">

</head>

<body>

	<div class="container">

		<form class="form-signin" action="${pageContext.request.contextPath}/signin" method="post">
			<h2 class="form-signin-heading">Authentification</h2>
			<label for="pseudo" class="sr-only">Pseudonyme</label> 
			<input id="ipseudo" class="form-control" placeholder="Pseudonyme" name="pseudo" required autofocus> 			
			<br/>
			<button class="btn btn-lg  btn-success btn-block" type="submit">S'authentifier</button>
		</form>

	</div>
</body>
</html>
