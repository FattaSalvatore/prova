<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="../WEB-INF/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title> Modifica Auto</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="./img/favicon.ico">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<h1 class="w3-xlarge w3-xlargecolor w3-opacity" style="color:green">MODIFICA AUTO</h1>
	<br><br>
      <c:if test = "${Error != null}">
         <div style="display: flex; justify-content: center; width: auto"><p>Errore nella modifica dati</p></div>
      </c:if>
	
	<div class="w3-opacity" style="display: flex; justify-content: center; width: 100%">
	<form method="POST" action="/Provawebapp/FormAutoServlet" style="width:30%;">
		<label for="idMarca">Marca:</label><br>
		<input id="idMarca" name="marca" type="text" value="${marca }"><br><br>
		<label for="idModello">Modello:</label><br>
		<input id="idModello" name="modello" type="text" value="${modello }"><br><br>
		<label for="idPrezzo">Prezzo:</label><br>
		<input id="idPrezzo" name="prezzo" type="text" value="${prezzo }"><br><br>
		<label for="idRevisione">Revisione:</label><br>
		 <br><input type="date" id="revisione" name="revisione"  value="${datarevisione }"><br><br>
		<br>	
		<label for="idInizioPolizza">Inizio Polizza:</label><br>
		<br><input type="date" id="i_polizza" name="i_polizza"  value="${i_polizza }"><br><br>
		<br>
		<label for="idFinePolizza">Fine Polizza:</label><br>
		<br><input type="date" id="f_polizza" name="f_polizza"  value="${f_polizza }"><br><br>
		<br><br>
		
				<div style="display: flex; justify-content: center; width: auto">
					<input type="reset" class="button-40" >
		<input type="hidden" name="id" value="${id }">
		<div style="display: flex; justify-content: center; width: auto; padding-left:5%">
			<input type="submit" class="button-40" onClick="confirmAction()"><br></br><br>
					<script>
						//funzione aler
				      function confirmAction() {
				        let confirmAction = confirm("Sei sicuro di voler modificare questa vettura?");
				        if (confirmAction) {
				        	//true
				          alert("premi ok per confermare");
				        } else {
				        	//false
				        	alert("Hai annullato la modifica della vettura");
				        	//killo il processo della form
			        	    event.preventDefault();        	
				        }
				      }
				    </script>
				</div>
		</div>
	</form>
	</div>
	<div class="w3-opacity" >
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/MainServlet"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Torna alla Visualizzazione delle Auto</button></a></div>
	</div>
	<br><br>
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