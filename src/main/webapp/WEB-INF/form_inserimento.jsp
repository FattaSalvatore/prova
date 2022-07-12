<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Inserimento</title>
</head>
<body>

	<form method="POST" action="/Inserimento">
		<label for="idMarca">Marca</label>
		<input id="idMarca" name="marca" type="text">
		<label for="idModello">Modello</label>
		<input id="idModello" name="modello" type="text">
		<label for="idTarga">Targa</label>
		<input id="idTarga" name="targa" type="text">
		
		
		<label for="idProprietario">Proprietario</label>
		<select id="idProprietario" name="color" name="proprietario">
			<c:forEach var="p" items="${proprietari}">
				<option value='${(p.id) }'>${p.nome }</option>
			</c:forEach>
		</select>
		
		<label for="idPrezzo">Prezzo</label>
		<input id="idPrezzo" name="prezzo" type="text">
		
		<label for="idRevisione">Revisione</label>
		<input id="idRevisione" name="revisione" type="text">
		
		<label for="idInizioPolizza">Inizio Polizza</label>
		<input id="idInizioPolizza" name="i_polizza" type="text">
		
		<label for="idFinePolizza">Fine Polizza</label>
		<input id="idFinePolizza" name="f_polizza" type="text">
		
		
	</form>
</body>
</html>