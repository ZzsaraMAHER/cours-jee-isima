<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une page generant une citation aleatoire</title>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
</head>
<body>
<div class="container">
        <div class="row centered-form">
	        <div class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2 col-md-offset-2">
	        	<div class="panel panel-default">
	        		<div class="panel-heading">
			    		<h3 class="panel-title">Liste des articles enregistrés&nbsp;<a href="${pageContext.request.contextPath}/addNewArticle" style="float:right">Créer un article</a></h3>
		 			</div>
		 			<div class="panel-body">
		 				<table class="table table-striped">
		 					<thead>
			 					<tr>
			 						<th>#</th>
			 						<th>Reference</th>
			 						<th>Description</th>
			 						<th>Catégorie</th>
			 						<th>Actions</th>
			 					</tr>
		 					</thead>
		 					<tbody>
			 					<c:forEach items="${articles}" var="article">
					    			<tr>
					    				<td>${article.id}</td>
					    				<td>${article.reference}</td>
					    				<td>${article.description}</td>
					    				<td>${article.category.libelle}</td>
					    				<td><a href="${pageContext.request.contextPath}/editArticle?id=${article.id}">modifier</a>&nbsp;<a href="${pageContext.request.contextPath}/deleteArticle?id=${article.id}">supprimer</a></td>
					    			</tr>
					    		</c:forEach>
				    		</tbody>
				    	</table>
			    	</div>
	    		</div>
	   		</div>
    	</div>
    </div>
</body>
</html>
