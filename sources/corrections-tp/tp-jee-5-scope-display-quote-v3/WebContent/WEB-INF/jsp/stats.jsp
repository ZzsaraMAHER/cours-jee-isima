<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="jumbotron">
	<ul class="list-group">
		<li class="list-group-item">Nombre total de citation vue dans
			l'application : ${stats.nombreCitationVuAuTotal}</li>
		<li class="list-group-item">Nombre de session d'utilisation en
			cours : ${stats.nombreSessionEnCours}</li>
		<li class="list-group-item">Nombre de citation pour l'utilisateur
			(toutes sessions confondus) : ${stats.nombreDeCitationPourLUtilisateur}</li>
		<li class="list-group-item">Nombre de citation pour la session en
			cours : ${stats.nombreCitationVuPourLaSessionEnCours}</li>
	</ul>
</div>
