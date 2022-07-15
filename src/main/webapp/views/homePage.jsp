<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title> Home Page </title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="./img/favicon.ico">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px">

<!-- Header -->
<header class="w3-panel w3-center w3-opacity" style="padding:80px 14px">
  <h1 class="w3-xlarge w3-xlargecolor">HOME PAGE</h1>
  <h3 class="w3-xlarge">Benvenuto <b> ${nome } ${cognome }</b> sul sito RJC Assicurazione  </h3>
	<div style="display: flex;justify-content: center;">
	  <h2 class="w3-large" style="display: flex;align-items: center;padding: 0px 1vh">Ruolo: <b style="color: green; padding: 0px 1vh"> ${ruolo }</b></h2>
  	</div>
  <div class="w3-padding-32">
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/MainServlet"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Visualizza Tabella</button></a></div>
			<c:if test="${ruolo == 'Admin' }">
				<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Inserimento"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Inserimento</button></a></div>
			</c:if>
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Logout"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button" onClick="confirmAction()">Log-out</button></a></div>
					<script>
						//funzione aler
				      function confirmAction() {
				        let confirmAction = confirm("Sei sicuro di voler effettuare il Log-out");
				        if (confirmAction) {
				        	//true
				          alert("premi ok per confermare");
				        } else {
				        	//false
				        	alert("vuoi annullare l'opzione?");
				        	//killo il processo della form
			        	    event.preventDefault();
				        	
				        }
				      }
				    </script>
  </div>
</header>
  
<!-- End Page Content -->
</div>
<br><br>
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