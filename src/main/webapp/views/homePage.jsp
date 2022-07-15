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

<style>

.wrapper{
  display: flex;
  justify-content: center;
  
}
.wrapper .dynamic-txts{
  height: 100%;
  line-height: 0px;
  overflow: hidden;
}
.dynamic-txts li{
  list-style: none;
  font-size: 60px;
  font-weight: 500;
  position: relative;
  animation: slide 12s steps(4) infinite;
}
@keyframes slide {
  100%{
    top: -360px;
  }
}
.dynamic-txts li span{
  position: relative;
  line-height: 90px;
}
.dynamic-txts li span::after{
  content: "";
  position: absolute;
  left: 0;
  height: 120%;
  width: 100%;
  background: white;
  border-left: 2px solid green;
  animation: typing 3s steps(10) infinite;
}

@keyframes typing {
  40%, 60%{
    left: calc(100% + 40px);
  }
}
</style>



<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px">

<!-- Header -->
<header class="w3-panel w3-center w3-opacity" style="padding:80px 14px">
  	<div class="wrapper">
    <ul class="dynamic-txts" style="padding-inline-start: 0px">
      <li><span>Home Page</span></li>
    </ul>
  </div>

  <h3 class="w3-xlarge">Benvenuto <b> ${nome } ${cognome }</b> sul sito RJC Assicurazione  </h3>
	<div style="display: flex;justify-content: center;">
	  <h2 class="w3-large" style="display: flex;align-items: center;padding: 0px 1vh">Ruolo: <b style="color: green; padding: 0px 1vh"> ${ruolo }</b></h2>
  	</div>
  <div class="w3-padding-32">
			<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/MainServlet"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Visualizza Tabella</button></a></div>
			<c:if test="${ruolo == 'Admin' }">
				<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Inserimento"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Inserimento Vettura</button></a></div>
				<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/Inserimento"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Inserimento Utente</button></a></div>
				<div style="display: flex; justify-content: center; width: auto"><a href="/Provawebapp/ToFormUser"><button class="button-30" style="width: 100%; margin-bottom: 5vh;" role="button">Inserimento Utente</button></a></div>
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