<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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

<meta charset="ISO-8859-1">
<title>Calendrier Gif</title>
</head>
<body>
	<header>
		<div></div>
		<h1>Calendrier Gif</h1>
		<nav>
			<a href="deconnexion">Déconnexion</a>
		</nav>
	</header>
	<h2>${sessionScope.utilisateur.prenom}</h2>
	<table>
		<thead>
			<tr>
				<th>Jours</th>
				<th>Gifs</th>
				<th>Utilisateurs</th>
				<th>Réactions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${jours}" var="jour">
				<tr>
					<td>${jour.date}</td>
					<td><c:choose>
							<c:when test="${jour.gif eq null}">
								<p>${jour.nbPoints}points</p>
								<ul>
									<li><a href="gifdistant?date=${jour.date}">Placer un
											gif distant</a></li>
									<li><a href="gifteleverse?date=${jour.date}">Placer un
											gif téléversé</a></li>
								</ul>
							</c:when>
							<c:otherwise>

								<c:if test="${jour.gif.getClass().simpleName eq 'GifDistant'}">
									<img src="${jour.gif.url}">
								</c:if>
								<c:if test="${jour.gif.getClass().simpleName eq 'GifTeleverse'}">
									<img src="img/${jour.gif.id}.gif" height="200"
										alt="${jour.gif.nomFichierOriginal}"
										title="${jour.gif.nomFichierOriginal}">
								</c:if>
								<p>${jour.gif.legende}</p>
							</c:otherwise>
						</c:choose></td>
					<td>${jour.gif.utilisateur.prenom}</td>
					<td>
                            <ul>
                                <c:forEach items="${jour.gif.reactions}" var="reaction">
                                    <li>${reaction.emotion.code}
                                        ${reaction.utilisateur.prenom} ${reaction.utilisateur.nom}</li>
                                </c:forEach>
                                <li><a href="reaction?gif=${jour.gif.id}">Réagir</a></li>
                            </ul>
                        </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>




