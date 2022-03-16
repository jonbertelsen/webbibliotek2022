<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Forside</title>
    <link rel="stylesheet" type="text/css"  href="css/style.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Forside</a>

<h1>Her kan du logge ind</h1>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">Brugernavn: </label>
    <input type="text" id="email" name="email"/>
    <label for="kodeord">Kodeord: </label>
    <input type="password" id="kodeord" name="kodeord"/>
    <input type="submit"  value="Log ind"/>
</form>

</body>
</html>