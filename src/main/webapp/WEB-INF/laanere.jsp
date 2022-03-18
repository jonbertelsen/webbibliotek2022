<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Forside</title>
    <link rel="stylesheet" type="text/css"  href="css/style.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Forside</a>

<h1>Oversigt over alle laanere på vores bibliotek</h1>

<table>
    <c:forEach var="laaner" items="${requestScope.laanerliste}">
        <tr>
            <td>${laaner.laaner_id}</td>
            <td>${laaner.navn}</td>
            <td>${laaner.adresse}</td>
            <td>${laaner.postnummer}</td>
            <td>${laaner.by}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>