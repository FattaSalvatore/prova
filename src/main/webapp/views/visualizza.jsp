<!-- TAGLIB -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- HTML STRUCTURE -->
<!DOCTYPE html>
<html>
	<!-- HEAD -->
	<head>
		<meta charset="UTF-8">
		<link href="./style.css" rel="stylesheet" type="text/css">
		<!-- TITLE PAGE -->
		<title>Visualizza</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- PAGE LINK -->
		<link rel="icon" type="image/x-icon" href="./img/favicon.ico">
		<link rel="stylesheet" href="./css/style.css">
		<link rel="stylesheet" href="./js/javascript.js">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		</head>
		
		<!-- STYLE CSS FOR THIS PAGE -->
		<style>
			body,h1 {font-family: "Raleway", Arial, sans-serif}
			h1 {letter-spacing: 6px}
			.w3-row-padding img {margin-bottom: 12px}
			
					
			.my-custom-scrollbar {
			position: relative;
			height: 400px;
			overflow: auto;
			}
			.table-wrapper-scroll-y {
			display: block;
			}
			
			.center {
			  text-align:center
			}
			
		</style>
		
	</head>
	<body>

	<!-- !PAGE CONTENT! -->
		<div class="w3-content" style="max-width:1500px">
		<!-- Header -->
		<header class="w3-panel w3-center w3-opacity" style="padding:100px 16px 10px 16px">
		  <h1 class="w3-xlarge w3-xlargecolor">VISUALIZZA AUTO ASSICURATE</h1>
		  <h3>Sei nella sezione Visualizza, scorri per vedere le auto assicurate	</h3>
		</header>
		
		<!-- End Page Content -->
		</div>
		<br><br>
				<!-- TABLE AUTO -->
				<center>
					<h1>Tabella Auto</h1>
				<div class="table-wrapper-scroll-y my-custom-scrollbar">
					<table class="w3-table-all w3-centered" style="width:70%" >
				<tr>
							<th>Marca</th>
							<th>Modello</th>
							<th>Targa</th>
							<th>Codice Fiscale</th>
							<th>Prezzo</th>
							<th>Data Revisione</th>
							<th>Inizio Polizza</th>
							<th>Fine Polizza</th>
							<c:if test="${ruolo == 'Admin' }">
								<th>Modifica</th>
							</c:if>
						</tr>
						<c:forEach var="a" items="${Lista}">
						<tr>
				    		<td>${a.marca}</td>
				    		<td>${a.modello}</td>
				    		<td>${a.targa}</td>
				    		<td>${a.CF}</td>
				    		<td>${a.prezzo_auto}</td>
				    		<td>${a.datarevisione}</td>
				    		<td> <fmt:formatDate type = "date" value = "${a.inizio_polizza}" /></td>
				            <td> <fmt:formatDate type = "date" value = "${a.fine_polizza}" /></td>
				            <c:if test="${ruolo == 'Admin' }">
				            <td>
				            <div class="w3-panel w3-center">
				            	<form action="/Provawebapp/ModificaAuto" method="POST" >
				            		<input type="hidden" name="marca" value="${a.marca }">
				            		<input type="hidden" name="modello" value="${a.modello }">
				            		<input type="hidden" name="prezzo" value="${a.prezzo_auto }">
				            		<input type="hidden" name="datarevisione" value="${a.datarevisione }">
				            		<input type="hidden" name="i_polizza" value="${a.inizio_polizza }">
				            		<input type="hidden" name="f_polizza" value="${a.fine_polizza }">
				            		<input type="hidden" name="id" value="${a.id }">
				            		<input type="submit" value="MODIFICA">
				            	</form>
				            </div>
				            </td>
				            </c:if>
				    	</tr>
				    	</c:forEach>
				   </div>
		</table>
					<!-- TABLE USERS -->
					</center>
					<br><br>
					<c:if test="${ruolo == 'Admin' }">
						<center>
						<h1>Tabella User</h1>
						<div class="table-wrapper-scroll-y my-custom-scrollbar">
						<table class="w3-table-all w3-centered" style="width:70%">
							<tr>
								<th>Nome</th>
								<th>Cognome</th>
								<th>CodiceFiscale</th>
								<th>Data di Nascita</th>
							</tr>
							<c:forEach var="p" items="${PersonaLista}">
							<tr>
					    		<td>${p.nome}</td>
					    		<td>${p.cognome}</td>
					    		<td>${p.cf}</td>
					    		<td>${p.datanascita}</td>
					    	</tr>
					    	</c:forEach>
						</table>
						</div>
						</center>
					</c:if>
					
			<header class="w3-panel w3-center w3-opacity" style="padding:5px 5px">	
		  		<div class="w3-padding-32">
					<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Home"><button class="button-30" style="width: 100%; margin-bottom: 1vh;" role="button">Torna alla Home</button></a></div>
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