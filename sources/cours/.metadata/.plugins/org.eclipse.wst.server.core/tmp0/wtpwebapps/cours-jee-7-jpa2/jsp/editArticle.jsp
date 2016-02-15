<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrer un article</title>
<%@include file="head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/formulaire-elegant.css">
</head>
<body>
<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Création d'un nouvel article</h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form" method="post" action="${pageContext.request.contextPath}/saveArticle">
	    					<div class="form-group ${form.errors.reference.kindOfMessage}">
	               				<input id="reference" name="reference" type="text" placeholder="Référence de l'article" class="form-control input-sm" value="${form.bean.reference}">
	               				<c:if test="${form.errors.reference.error}">
									<span class="help-block"> ${form.errors.reference.errorMessage}</span>
								</c:if>
	  	            		</div>
	    		
			    			<div class="form-group control-group ${form.errors.description.kindOfMessage}">
								<textarea id="description" name="description" class="form-control" placeholder="Description de l'article">${form.bean.description}</textarea>
								<c:if test="${form.errors.description.error}">
									 <span class="help-block"> ${form.errors.description.errorMessage}</span>
								</c:if>
			    			</div>
			    			
			    			<div class="form-group control-group ${form.errors.category.kindOfMessage}">
			    				<select class="form-control" name="category">
				    				<c:forEach items="${form.bean.allCategories}" var="category">
				    					<c:choose>
				    						<c:when test="${category.selected}">
						    					<option value="${category.id}" selected="selected">${category.libelle}</option>
				    						</c:when>
				    						<c:otherwise>
						    					<option value="${category.id}">${category.libelle}</option>					
				    						</c:otherwise>
				    					</c:choose>
				    				</c:forEach>
	   							</select>
								<c:if test="${form.errors.category.error}">
									 <span class="help-block"> ${form.errors.category.errorMessage}</span>
								</c:if>	   							
							</div>	
										
			    			<input type="submit" value="Enregistrer l'article" class="btn btn-info btn-block">
			    			<input type="hidden" name="id" value="${form.bean.id}"/>
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
</body>
</html>
