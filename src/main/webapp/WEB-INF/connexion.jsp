<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Calendrier Gif</title>
	<style type="text/css">
<%@include file="Style/theme2.css"%>
</style>
</head>
<body>
	<h1>Calendrier Gif</h1>

	<form action="connexion" method="post">
		<input type="email" name="EMAIL" placeHolder="Email" required><br>
		<input type="password" name="MOT_DE_PASSE" placeHolder="Mot de Passe"
			required><br> <input class="button" type="submit" value="Connexion">
	</form>
	<a href="inscription">S'inscrire</a>

</body>
</html>