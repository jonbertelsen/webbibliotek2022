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

<h1>Oversigt over alle udlån</h1>

<table>
    <thead>
    <tr>
        <th>bogId</th>
        <th>laanerId</th>
        <th>laanerNavn</th>
        <th>adresse</th>
        <th>postnr</th>
        <th>titel</th>
        <th>udgivelsesaar</th>
        <th>forfatter_id</th>
        <th>forfatter_navn</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="udlaan" items="${requestScope.udlaanliste}">
        <tr>
            <td>${udlaan.bogId}</td>
            <td>${udlaan.laanerId}</td>
            <td>${udlaan.laanerNavn}</td>
            <td>${udlaan.adresse}</td>
            <td>${udlaan.postnr}</td>
            <td>${udlaan.titel}</td>
            <td>${udlaan.udgivelsesaar}</td>
            <td>${udlaan.forfatter_id}</td>
            <td>${udlaan.forfatterNavn}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>