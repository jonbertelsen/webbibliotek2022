<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Rediger låner
    </jsp:attribute>

    <jsp:attribute name="footer">
            Footertekst
    </jsp:attribute>

    <jsp:body>

        <p>Rediger låners stamdata</p>
        <form action="laaner" method="post">
            <input type="hidden" name="command" value="opdater"/>
            <label for="id">Id: </label>
            <input type="text" name="id" id="id" readonly value="${requestScope.laaner.laaner_id}"/><br/>
            <label for="navn">Navn: </label>
            <input type="text" name="navn" id="navn" value="${requestScope.laaner.navn}"/><br/>
            <label for="adresse">Adresse: </label>
            <input type="text" name="adresse" id="adresse" value="${requestScope.laaner.adresse}"/><br/>
            <label for="postnr">Postnr: </label>
            <input type="text" name="postnr" id="postnr" value="${requestScope.laaner.postnummer}"/><br/>
            <input type="submit" value="opdater låner"/>
        </form>
    </jsp:body>
</t:pagetemplate>