<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Forside</title>
    <link rel="stylesheet" type="text/css"  href="css/style.css">
</head>
<body>
<h1>Bogliste</h1>

<table>
    <c:forEach var="bog" items="${requestScope.bogliste}">
        <tr>
            <td>${bog.bogId}</td>
            <td>${bog.titel}</td>
            <td>${bog.forfatterNavn}</td>
            <td>${bog.udgivelsesaar}</td>
        </tr>
    </c:forEach>

</table>



<a href="">Home</a>
</body>
</html>