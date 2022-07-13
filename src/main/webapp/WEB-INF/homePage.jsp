<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title> Home Page </title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
		body,h1 {font-family: "Raleway", Arial, sans-serif}
		h1 {letter-spacing: 10px}
		.w3-row-padding img {margin-bottom: 12px}
	</style>
	</head>
	<body>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px">

<!-- Header -->
<header class="w3-panel w3-center w3-opacity" style="padding:80px 14px">
  <h1 class="w3-xlarge">HOME PAGE</h1>
  <h3 class="w3-xlarge">Benvenuto sul sito officina.it</h3>
  
  <div class="w3-padding-32">
      		<form action="/Provawebapp/MainServlet">
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/MainServlet"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Visualizza Tabella</button></a></div>
		</form>
		<form action="/Provawebapp/Inserimento">
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Inserimento"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Inserimento</button></a></div>
		</form>
  </div>
</header>
  
<!-- End Page Content -->
</div>

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
	
</html>