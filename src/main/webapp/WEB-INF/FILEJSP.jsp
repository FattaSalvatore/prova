<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="./style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<style>
/* Component styles */
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
*{
	font-family: 'Montserrat', sans-serif;
}
.component {
	line-height: 1.5em;
	margin: 0 auto;
	padding: 2em 0 3em;
	width: 90%;
	max-width: 1000px;
	overflow: hidden;
}
.component .filler {
	font-family: "Blokk", Arial, sans-serif;
	color: #d3d3d3;
}
table {
    border-collapse: collapse;
    margin-bottom: 3em;
    width: 100%;
    background: #fff;
}
td, th {
    padding: 0.75em 1.5em;
    text-align: left;
}
	td.err {
		background-color: #e992b9;
		color: #fff;
		font-size: 0.75em;
		text-align: center;
		line-height: 1;
	}
th {
    background-color: #31bc86;
    font-weight: bold;
    color: #fff;
    white-space: nowrap;
}
tbody th {
	background-color: #2ea879;
}
tbody tr:nth-child(2n-1) {
    background-color: #f5f5f5;
    transition: all .125s ease-in-out;
}
tbody tr:hover {
    background-color: rgba(129,208,177,.3);
}

/* For appearance */
.sticky-wrap {
	overflow-x: auto;
	overflow-y: hidden;
	position: relative;
	margin: 3em 0;
	width: 100%;
}
.sticky-wrap .sticky-thead,
.sticky-wrap .sticky-col,
.sticky-wrap .sticky-intersect {
	opacity: 0;
	position: absolute;
	top: 0;
	left: 0;
	transition: all .125s ease-in-out;
	z-index: 50;
	width: auto; /* Prevent table from stretching to full size */
}
	.sticky-wrap .sticky-thead {
		box-shadow: 0 0.25em 0.1em -0.1em rgba(0,0,0,.125);
		z-index: 100;
		width: 100%; /* Force stretch */
	}
	.sticky-wrap .sticky-intersect {
		opacity: 1;
		z-index: 150;

	}
		.sticky-wrap .sticky-intersect th {
			background-color: #666;
			color: #eee;
		}
.sticky-wrap td,
.sticky-wrap th {
	box-sizing: border-box;
}

/* Not needed for sticky header/column functionality */
td.user-name {
	text-transform: capitalize;
}
.sticky-wrap.overflow-y {
	overflow-y: auto;
	max-height: 50vh;
}


</style>
<center>
	<h1>Tabella Auto</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Marca</th>
			<th>Modello</th>
			<th>Targa</th>
			<th>Id_Proprietario</th>
			<th>Prezzo</th>
			<th>Data Revisione</th>
			<th>Inizio Polizza</th>
			<th>Fine Polizza</th>
		</tr>
		<c:forEach var="a" items="${Lista}">
		<tr>
			<td>${a.id}</td> 
    		<td>${a.marca}</td>
    		<td>${a.modello}</td>
    		<td>${a.targa}</td>
    		<td>${a.proprietario}</td>
    		<td>${a.prezzo_auto}</td>
    		<td>${a.datarevisione}</td>
    		<td>${a.inizio_polizza}</td>
    		<td>${a.fine_polizza}</td>
    	</tr>
    	</c:forEach>
	</table>
	</center>
</body>
</html>