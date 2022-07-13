<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="./style.css" rel="stylesheet" type="text/css">
		<title> Login </title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./css/style.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
<body>

	<h2 class="w3-xlarge w3-xlargecolor">Login</h2>
	<form action="/Login" method="POST">
	
		<label for="idEmail">Email</label>
		<input id="idEmail" type="email" name="email">
		
		<label for="idPwd">Password</label>
		<input id="idPwd" type="password" name="pwd">
		
		<input type="submit" value="Invia">
		
	</form>
</body>
</html>