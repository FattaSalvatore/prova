<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Ciao</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Marca</th>
			<th>Modello</th>
			<th>Targa</th>
			<th>Id_Proprietario</th>
			<th>Prezzo</th>
			<th>Data Revisione</th>
			<th>Inizio Polizza</th>
			<th>Fine Polizza</th>
		</tr>
		<c:forEach var="a" items="${Lista}">
		<tr>
			<td>${a.id}</td> 
    		<td>${a.marca}</td>
    		<td>${a.modello}</td>
    		<td>${a.targa}</td>
    		<td>${a.proprietario}</td>
    		<td>${a.prezzo_auto}</td>
    		<td>${a.datarevisione}</td>
    		<td>${a.inizio_polizza}</td>
    		<td>${a.fine_polizza}</td>
    	</tr>
    	</c:forEach>
	</table>
	</center>
</body>
</html>