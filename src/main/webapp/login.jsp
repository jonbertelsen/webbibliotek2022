<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Forside</title>
    <link rel="stylesheet" type="text/css"  href="css/style.css">
</head>
<body>
<a href="index.jsp">Forside</a>

<h1>Her kan du logge ind</h1>

<form action="login" method="post">
    <label for="email">Brugernavn: </label>
    <input type="text" id="email" name="email"/>
    <label for="kodeord">Kodeord: </label>
    <input type="password" id="kodeord" name="kodeord"/>
    <input type="submit"  value="Log ind"/>
</form>

</body>
</html>