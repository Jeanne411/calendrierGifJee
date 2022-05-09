<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:if test="${sessionScope.utilisateur.theme.id==1}">
	<style type="text/css">
<%@ include file="Style/theme1.css"%>
</style>
</c:if>
<c:if test="${sessionScope.utilisateur.theme.id==2}">
	<style type="text/css">
<%@ include file="Style/theme2.css"%>
</style>
</c:if>
<title>Gif t�l�vers�</title>
</head>
<body>
<h1>Ajoutez votre gif :</h1>
<form action= "" method= "post" enctype="multipart/form-data">
        <input type="file" name="nom_fichier_original" placeHolder="nom du fichier" required><br>
		<input type="text" name="legende" placeHolder="L�gende" required><br>
	    <input class="button" type="submit" value="Ajouter votre gif">
</form>

</body>
</html>