<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Forside</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<a href="laanere">Lånere</a> |
<a href="bogliste">Bøger</a> |
<a href="udlaan">Se udlån</a> |
<a href="login.jsp">Login</a>

<h1>Biblioteket</h1>
<p>Velkommen til 2. semesters biblioteksapplikation. </p>

<c:if test="${sessionScope.bruger != null}">
    <p>Du er nu logget på med rollen "${sessionScope.bruger.rolle}".</p>
</c:if>

<c:if test="${sessionScope.bruger == null}">
    <p>Du er ikke logget på endnu. Du kan gøre det her: <a
            href="login.jsp">Login</a></p>
</c:if>

</body>
</html>