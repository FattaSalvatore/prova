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

	<style>

button, input, select, textarea {
	color: #5A5A5A;
	margin: 0;
}

input {
	line-height: normal;
}

#container {
	border: solid 3px #474544;
	max-width: 768px;
	margin: 60px auto;
	position: relative;
}

form {
	margin: 5px 0;
}

h1 {
	padding: 50px;
	text-align: center;
	letter-spacing: 10px
}

h4 {
	letter-spacing: 10px
}

.underline {
	border-bottom: solid 2px #474544;
	margin: -0.512em auto;
	width: 80px;
}

.icon_wrapper {
	margin: 50px auto 0;
	width: 100%;
}

.icon {
	display: block;
	fill: #474544;
	height: 50px;
	margin: 0 auto;
	width: 50px;
}

.email {
	float: right;
	width: 45%;
}

input[type='text'], [type='email'], select, textarea {
	background: none;
	border: none;
	border-bottom: solid 2px #474544;
	color: #474544;
	font-size: 1.000em;
	font-weight: 400;
	letter-spacing: 1px;
	margin: 0em 0 1.875em 0;
	padding: 0 0 0.875em 0;
	text-transform: uppercase;
	width: 100%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	-o-box-sizing: border-box;
	box-sizing: border-box;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	-ms-transition: all 0.3s;
	-o-transition: all 0.3s;
	transition: all 0.3s;
}

input[type='text']:focus, [type='email']:focus, textarea:focus {
	outline: none;
	padding: 0 0 0.875em 0;
}

.message {
	float: none;
}

.name {
	float: left;
	width: 45%;
}

select::-ms-expand {
	display: none;
}

.subject {
	width: 100%;
}

.telephone {
	width: 100%;
}

textarea {
	line-height: 150%;
	height: 150px;
	resize: none;
	width: 100%;
}

::-webkit-input-placeholder {
	color: #474544;
}

:-moz-placeholder {
	color: #474544;
	opacity: 1;
}

::-moz-placeholder {
	color: #474544;
	opacity: 1;
}

:-ms-input-placeholder {
	color: #474544;
}

#form_button:hover {
	background: #474544;
	color: #F2F3EB;
}

@media screen and (max-width: 768px) {
	#container {
		margin: 20px auto;
		width: 95%;
	}
}

@media screen and (max-width: 480px) {
	h1 {
		font-size: 26px;
	}
	.underline {
		width: 68px;
	}
	#form_button {
		padding: 15px 25px;
	}
}

@media screen and (max-width: 420px) {
	h1 {
		font-size: 18px;
	}
	.icon {
		height: 35px;
		width: 35px;
	}
	.underline {
		width: 53px;
	}
	input[type='text'], [type='email'], select, textarea {
		font-size: 0.6;
	}
}
</style>

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
		<select id="idProprietario" name="proprietario">
			<option value='0'">Luca</option>
			<option value='1'">Andrea</option>
			<option value='2'">Giovanni</option>
		</select><br><br>
		
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
		<br><br><br>
		
	<center>
		<input type="submit" class="button-30" style="width: 20%" value="Invia"><br><br>
	</center>
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