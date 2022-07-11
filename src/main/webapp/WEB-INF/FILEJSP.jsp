<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${Auto}" var="a">
        <div class="content">
            <div class="content-body">
<%--                 <h4 class="content-stamp">${a.id} ${a.marca} ${a.modello} ${a.targa} ${a.proprietario} ${a.prezzo_auto} ${a.datarevisione} ${a.inizio_polizza} ${a.fine_polizza}</h4> --%>
                
            </div>
        </div>
    </c:forEach>
</body>
</html>