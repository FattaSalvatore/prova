<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="../WEB-INF/style.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Errore</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<header class="w3-panel w3-center w3-opacity" style="padding:60px 14px">
  <h1 class="w3-xlarge" style="color: red">Errore</h1>
  <h3 class="w3-xlarge">${Error }</h3>

</header>
	<div class="w3-opacity" >
		<form action="/Provawebapp/Home">
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Home"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Torna alla Home</button></a></div>
		</form>
	</div>
	  <div class="w3-padding-32">
      	
  </div>  <div class="w3-padding-32">
      	
  </div>
	<br><br>
	<footer class="w3-container w3-padding-64 w3-red w3-center w3-large"> 
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