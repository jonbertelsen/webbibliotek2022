<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Fejlside</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<h1>Biblioteket</h1>
<p>UPS! Der er opstået en fejl. Her er den bedste besked vi kan give lige nu: </p>

<c:if test="${requestScope.fejlbesked != null}">
    <p>${requestScope.fejlbesked}</p>
</c:if>

<c:if test="${requestScope.fejlbesked  == null}">
    <p>Den er helt gal. Vi ved ikke hvordan du er havnet her. Så kontakt bibliotekaren.</p>
</c:if>

<p>Hop tilbage til <a href="index.jsp">Forsiden</a> her,
 eller prøv at <a href="login.jsp">logge</a> på igen.</p>

</body>
</html>