<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une page affichant l'heure courante</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>

</head>
<body>
	<div>
		<h1>Un clic sur un bouton pour modifier un champ</h1>
		<div>
			<span>Valeur du champ a inserer</span> <input type="text"
				id="to-insert"> <input type="button" id="insert-button"
				value="Insérer">
		</div>
		<br /> <span>Le champ tape est</span>&nbsp;<span id="field-value"></span>
		<br />
	</div>
	<div>
		<h1>Je change la couleur du texte</h1>
		<div>
			<input type="button" id="red-button" class="color-change-button" alt="red"
				value="Red"> 
			<input type="button" id="blue-button"
				class="color-change-button" alt="blue" value="Blue"> 
			<input
				type="button" id="black-button" class="color-change-button" alt="black" value="Black">
			<input type="button" id="green-button" class="color-change-button" alt="green"
				value="Green">
		</div>
		<br /> <span id="text-changeable">Je suis un texte que l'on peut colorer</span> <br />
	</div>
	<div>
		<h1>Je désactive le changement de couleur</h1>
		<input type="button" id="desactiver-changement-couleur"
			value="Desactiver changement de couleur">
	</div>
		<div>
		<h1>J'affiche toutes les infos sur les boutons</h1>
		<input type="button" id="add-list-des-bouttons"
			value="Liste des boutons de la page">
			
		<ul id="liste-des-boutons">
		</ul>
	</div>
</body>
<script type="text/javascript" src="js/jquery-examples.js">

</script>
</html>
