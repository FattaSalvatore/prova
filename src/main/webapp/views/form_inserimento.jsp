<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="../WEB-INF/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title> Inserisci Auto</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="./img/favicon.ico">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>


<h1 class="w3-xlarge w3-xlargecolor w3-opacity" style="color:green">INSERIMENTO AUTO</h1>

	

      <c:if test = "${Error != null}">
         <div style="display: flex; justify-content: center; width: auto"><p>Errore nell'inserimento dati</p></div>
      </c:if>
	
	<div class="w3-opacity" style="display: flex; justify-content: center; width: 100%">
	<form method="POST" action="/Provawebapp/FormAutoServlet" style="width:30%;">
		<label for="idMarca">Marca:</label><br>
		<input id="idMarca" name="marca" type="text"><br><br>
		<label for="idModello">Modello:</label><br>
		<input id="idModello" name="modello" type="text"><br><br>
		<label for="idTarga">Targa:</label><br>
		<input id="idTarga" name="targa" type="text"><br><br>
		
		
		<label for="idProprietario">Proprietario:</label><br>
		<input id="proprietario" name="proprietario" type="text">
		<br><br>
		<label for="idPrezzo">Prezzo:</label><br>
		<input id="idPrezzo" name="prezzo" type="text"><br><br>
		
		<label for="idRevisione">Revisione:</label><br>
		 <br><input type="date" id="revisione" name="revisione"  value="yyyy-mm-dd"><br><br>
		<br>
		<label for="idInizioPolizza">Inizio Polizza:</label><br>
		<br><input type="date" id="i_polizza" name="i_polizza"  value="yyyy-mm-dd"><br><br>
		<br>
		
		<label for="idFinePolizza">Fine Polizza:</label><br>
		<br><input type="date" id="f_polizza" name="f_polizza"  value="yyyy-mm-dd"><br><br>
		<br><br>
		
		<div style="display: flex; justify-content: center; width: auto">
			<input type="submit" class="button-40" onClick="confirmAction()"><br></br><br>
					<script>
						//funzione aler
				      function confirmAction() {
				        let confirmAction = confirm("Sei sicuro di voler inserire questa vettura?");
				        if (confirmAction) {
				        	//true
				          alert("premi ok per confermare");
				        } else {
				        	//false
				        	alert("Hai annullato l'inserimento della vettura");
				        	//killo il processo della form
			        	    event.preventDefault();
				        	
				        }
				      }
				    </script>
				<div style="display: flex; justify-content: center; width: auto; padding-left:5%">
					<input type="reset" class="button-40" >
				</div>
		</div>
	</form>
	</div>
	<div class="w3-opacity" >
		<form action="/Provawebapp/Home">
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Home"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Torna alla Home</button></a></div>
		</form>
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