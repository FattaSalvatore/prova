<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./style.css" rel="stylesheet" type="text/css">
		<title> Visualizza tabelle </title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
		  <h1 class="w3-xlarge">VISUALIZZA TABELLE</h1>
		  <h3>Sei nella sezione Visualizza, scorri per vedere la stampa delle tabelle</h3>
		</header>
		
		<!-- End Page Content -->
		</div>
	
	</body>
	
		<!-- CSS Code: Place this code in the document's head (between the <head> -- </head> tags) -->
	<style>
	table{
	  width: 100%;
	  background-color: #FFFFFF;
	  border-collapse: collapse;
	  color: #000000;
	}
	
	td,th{
	border-bottom: 2px solid #F5F5F5;
	  padding: 5px;
	}
	
	th{
	  background-color: #CACACA;
	}
	</style>
		<body>
		<br><br>
				<center>
					<h1>Tabella Auto</h1>
					<table style="width:70%">
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
					<table style="width:60%">
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
	<body>
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

		<style>
		/* CSS */
		.button-30 {
		  align-items: center;
		  appearance: none;
		  background-color: #FCFCFD;
		  border-radius: 4px;
		  border-width: 0;
		  box-shadow: rgba(45, 35, 66, 0.4) 0 2px 4px,rgba(45, 35, 66, 0.3) 0 7px 13px -3px,#D6D6E7 0 -3px 0 inset;
		  box-sizing: border-box;
		  color: #36395A;
		  cursor: pointer;
		  font-family: "JetBrains Mono",monospace;
		  height: 45px;
		  justify-content: center;
		  line-height: 1;
		  list-style: none;
		  overflow: hidden;
		  padding-left: 16px;
		  padding-right: 16px;
		  position: relative;
		  text-align: left;
		  text-decoration: none;
		  transition: box-shadow .15s,transform .15s;
		  user-select: none;
		  -webkit-user-select: none;
		  touch-action: manipulation;
		  white-space: nowrap;
		  will-change: box-shadow,transform;
		  font-size: 18px;
		}
		
		.button-30:focus {
		  box-shadow: #D6D6E7 0 0 0 1.5px inset, rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
		}
		
		.button-30:hover {
		  box-shadow: rgba(45, 35, 66, 0.4) 0 4px 8px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
		  transform: translateY(-2px);
		}
		
		.button-30:active {
		  box-shadow: #D6D6E7 0 3px 7px inset;
		  transform: translateY(2px);
	</style>
		</body>
</html>