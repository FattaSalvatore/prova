<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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