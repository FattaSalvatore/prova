<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Scegli quale operazione vorresti fare</h1>
	<form action="MainServelet">
		<input type="hidden"  id="lname" name="NomePagina" value="FILEJSP">
           	<button type="submit" class="form-control-submit-button">Visualizza Auto</button>
	</form>
</body>
</html>