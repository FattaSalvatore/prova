<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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