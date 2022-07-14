<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./style.css" rel="stylesheet" type="text/css">
		<title> visualizza </title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" type="image/x-icon" href="./img/favicon.ico">
		<link rel="stylesheet" href="./css/style.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		</head>
		
		<style>
			body,h1 {font-family: "Raleway", Arial, sans-serif}
			h1 {letter-spacing: 6px}
			.w3-row-padding img {margin-bottom: 12px}
		</style>
	</head>
	<body>
	
		<!-- !PAGE CONTENT! -->
		<div class="w3-content" style="max-width:1500px">
		<!-- Header -->
		<header class="w3-panel w3-center w3-opacity" style="padding:100px 16px 10px 16px">
		  <h1 class="w3-xlarge w3-xlargecolor">VISUALIZZA TABELLE</h1>
		  <h3>Sei nella sezione Visualizza, scorri per vedere la stampa delle tabelle</h3>
		</header>
		
		<!-- End Page Content -->
		</div>

		<br><br>
				<center>
					<h1>Tabella Auto</h1>
					<table class="w3-table-all w3-centered" style="width:70%">
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
				    		<td> <fmt:formatDate type = "date" value = "${a.inizio_polizza}" /></td>
				            <td> <fmt:formatDate type = "date" value = "${a.fine_polizza}" /></td>
				    	</tr>
				    	</c:forEach>
					</table>
					</center>
					<br><br>
					
					<center>
					<th>
					<h1>Tabella User</h1>
					<table class="w3-table-all w3-centered" style="width:60%">
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>CodiceFiscale</th>
							<th>Data di Nascita</th>
						</tr>
						<c:forEach var="p" items="${PersonaLista}">
						<tr>
							<td>${p.id}</td> 
				    		<td>${p.nome}</td>
				    		<td>${p.cognome}</td>
				    		<td>${p.cf}</td>
				    		<td>${p.datanascita}</td>
				    	</tr>
				    	</c:forEach>
					</table>
					</center>
	<br></br>			
	
			<header class="w3-panel w3-center w3-opacity" style="padding:5px 5px">	
		  		<div class="w3-padding-32">
		      		<form action="/Provawebapp/Home">
					<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/MainServlet"><button class="button-30" style="width: 100%; margin-bottom: 1vh;" role="button">Torna alla Home</button></a></div>
					</form>
		  		</div>
		 </header>	
		 			
		<!-- Footer -->
		<footer class="w3-container w3-padding-64 w3-green w3-center w3-large"> 
		  <i class="fa fa-facebook-official w3-hover-opacity"></i>
		  <i class="fa fa-instagram w3-hover-opacity"></i>
		  <i class="fa fa-snapchat w3-hover-opacity"></i>
		  <i class="fa fa-pinterest-p w3-hover-opacity"></i>
		  <i class="fa fa-twitter w3-hover-opacity"></i>
		  <i class="fa fa-linkedin w3-hover-opacity"></i>
		  <p>Created by <a>rjc soft</a></p>
		</footer>		
		</body>
</html>