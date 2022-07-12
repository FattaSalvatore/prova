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
body {
  font-family: "Roboto", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  background-color: #19191d;
  font-weight: 300; }

p {
  color: #b3b3b3;
  font-weight: 300; }

h1, h2, h3, h4, h5, h6,
.h1, .h2, .h3, .h4, .h5, .h6 {
  font-family: "Roboto", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji"; }

a {
  -webkit-transition: .3s all ease;
  -o-transition: .3s all ease;
  transition: .3s all ease; }
  a, a:hover {
    text-decoration: none !important; }

.content {
  padding: 7rem 0; }

h2 {
  font-size: 20px;
  color: #fff; }

.custom-table {
  min-width: 900px; }
  .custom-table thead tr, .custom-table thead th {
    border-top: none;
    border-bottom: none !important;
    color: #fff; }
  .custom-table tbody th, .custom-table tbody td {
    color: #777;
    font-weight: 400;
    padding-bottom: 20px;
    padding-top: 20px;
    font-weight: 300; }
    .custom-table tbody th small, .custom-table tbody td small {
      color: #b3b3b3;
      font-weight: 300; }
  .custom-table tbody tr:not(.spacer) {
    border-radius: 7px;
    overflow: hidden;
    -webkit-transition: .3s all ease;
    -o-transition: .3s all ease;
    transition: .3s all ease; }
    .custom-table tbody tr:not(.spacer):hover {
      -webkit-box-shadow: 0 2px 10px -5px rgba(0, 0, 0, 0.1);
      box-shadow: 0 2px 10px -5px rgba(0, 0, 0, 0.1); }
  .custom-table tbody tr th, .custom-table tbody tr td {
    background: #25252b;
    border: none;
    -webkit-transition: .3s all ease;
    -o-transition: .3s all ease;
    transition: .3s all ease; }
    .custom-table tbody tr th a, .custom-table tbody tr td a {
      color: #b3b3b3; }
    .custom-table tbody tr th:first-child, .custom-table tbody tr td:first-child {
      border-top-left-radius: 0px;
      border-bottom-left-radius: 0px; }
    .custom-table tbody tr th:last-child, .custom-table tbody tr td:last-child {
      border-top-right-radius: 0px;
      border-bottom-right-radius: 0px; }
  .custom-table tbody tr.spacer td {
    padding: 0 !important;
    height: 3px;
    border-radius: 0 !important;
    background: transparent !important; }
  .custom-table tbody tr.active th, .custom-table tbody tr.active td, .custom-table tbody tr:hover th, .custom-table tbody tr:hover td {
    color: #fff;
    background: #2e2e36; }
    .custom-table tbody tr.active th a, .custom-table tbody tr.active td a, .custom-table tbody tr:hover th a, .custom-table tbody tr:hover td a {
      color: #fff; }

/* Custom Checkbox */
.control {
  display: block;
  position: relative;
  margin-bottom: 25px;
  cursor: pointer;
  font-size: 18px; }

.control input {
  position: absolute;
  z-index: -1;
  opacity: 0; }

.control__indicator {
  position: absolute;
  top: 2px;
  left: 0;
  height: 20px;
  width: 20px;
  border-radius: 4px;
  border: 2px solid #3f3f47;
  background: transparent; }

.control--radio .control__indicator {
  border-radius: 50%; }

.control:hover input ~ .control__indicator,
.control input:focus ~ .control__indicator {
  border: 2px solid #007bff; }

.control input:checked ~ .control__indicator {
  border: 2px solid #007bff;
  background: #007bff; }

.control input:disabled ~ .control__indicator {
  background: #e6e6e6;
  opacity: 0.6;
  pointer-events: none;
  border: 2px solid #ccc; }

.control__indicator:after {
  font-family: 'icomoon';
  content: '\e5ca';
  position: absolute;
  display: none; }

.control input:checked ~ .control__indicator:after {
  display: block;
  color: #fff; }

.control--checkbox .control__indicator:after {
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -52%);
  -ms-transform: translate(-50%, -52%);
  transform: translate(-50%, -52%); }

.control--checkbox input:disabled ~ .control__indicator:after {
  border-color: #7b7b7b; }

.control--checkbox input:disabled:checked ~ .control__indicator {
  background-color: #007bff;
  opacity: .2;
  border: 2px solid #007bff; }

</style>
<center>
	<h1>Ciao</h1>
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

<title>Insert title here</title>
</head>
<body>
	<h1>Stampa Tabella test1_auto</h1>
	<c:forEach var="a" items="${Lista}">

        <div class="content">
            <div class="content-body">
                <h4 class="content-stamp">${a.id} ${a.marca} ${a.modello} ${a.targa} ${a.proprietario} ${a.prezzo_auto} ${a.datarevisione} ${a.inizio_polizza} ${a.fine_polizza}</h4> 
                
            </div>
        </div>
    </c:forEach>
</body>
</html>