<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Autenticazione</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="./img/favicon.ico">
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

</style>

	<h1 class="w3-xlarge w3-xlargecolor w3-opacity" style="color: #6666ff">AUTENTICAZIONE</h1>
	
	<div class="w3-opacity" style="display: flex; justify-content: center; width: 100%">
	<form method="POST" action="/Provawebapp/Login">

		<label for="idEmail">Email:</label> 
		<input id="idEmail" type="email" name="email"> 
	<center>
	<br></br>
		<label for="idPwd">Password:  </label> 
		<input id="idPwd" type="password" name="pwd"> 
	</center>
		<br><br>
		<br><br>
			<div style="display: flex; justify-content: center; width: auto">
			<input type="submit" class="button-40" onclick="confirmAction()"><br></br><br>
					<script>
						//funzione aler
				      function confirmAction() {
				        let confirmAction = confirm("Sei sicuro di voler procedere con queste credenziali?");
				        if (confirmAction) {
				        	//true
				          alert("premi ok per confermare");
				        } else {
				        	//false
				        	alert("Hai annullato l'inserimento delle credenziali");
				        	//killo il processo della form
			        	    event.preventDefault();	        	
				        }
				      }
				    </script>
				<div style="display: flex; justify-content: center; width: auto; padding-left:10%">
					<input type="reset" class="button-40" >
				</div>
			</div>
	</form>
	</div>
</body>
</html>
	
	


