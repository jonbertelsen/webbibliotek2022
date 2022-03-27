<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Opret låner
    </jsp:attribute>

    <jsp:attribute name="footer">
            Footertekst
    </jsp:attribute>

    <jsp:body>

        <p>Indtast låners stamdata</p>
        <form action="laaner" method="post">
            <input type="hidden" name="command" value="opret"/>
            <label for="navn">Navn: </label>
            <input type="text" name="navn" id="navn"/><br/>
            <label for="adresse">Adresse: </label>
            <input type="text" name="adresse" id="adresse"/><br/>
            <label for="postnr">Postnr: </label>
            <input type="text" name="postnr" id="postnr"/><br/>
            <input type="submit" value="opret låner"/>
        </form>
    </jsp:body>
</t:pagetemplate>