<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Details du colis</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" ></style>
</head>
<body>
	<h1>Détails du Colis</h1>
	<h2>Informations colis :</h2>
	<p>id     : ${colis.id }</p>
	<p>poids  : ${colis.poids } kg </p>
	<p>valeur :  <fmt:formatNumber type="currency" currencySymbol="&euro;"
	   value="${colis.valeur }"></fmt:formatNumber> </p>
    <p>Etat : ${colis.etape.etat } </p>
    <p>_____________________________________________</p>
    <h2>Origine du colis        :</h2>
    <p>Lieu d'origine           : ${colis.origine.nom } </p>
    <p>Longitude d'origine      : ${colis.origine.position.longitude } </p>
    <p>Latitude d'origine       : ${colis.origine.position.latitude } </p>
    <p>_____________________________________________</p>
    <h2>Destination du colis    :</h2>
    <p>Lieu de destination      : ${colis.destination.nom } </p>
    <p>Longitude de destination : ${colis.destination.position.longitude } </p>
    <p>Latitude de destination  : ${colis.destination.position.latitude } </p>
    <p>_____________________________________________</p>
    <h2>Etape actuelle du colis :</h2>
    <p>Lieu de l'étape          : ${colis.etape.emplacement.nom } </p>
    <p>Longitude de l'étape     : ${colis.etape.emplacement.position.longitude } </p>
    <p>Latitude de l'étape      : ${colis.etape.emplacement.position.latitude } </p>
    <br/>
	<a href="index.html">Revenir à la page principale</a>
</body>
</html>