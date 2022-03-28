<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
              Opret bog
    </jsp:attribute>

    <jsp:attribute name="footer">
            Opret bog
    </jsp:attribute>

    <jsp:body>
        <form method="post" action="opretbog">
            <label for="titel">titel:</label>
            <input type="text" id="titel" name="titel" /><br/>
            <label for="aar">udgivelsesår: </label>
            <input type="text" id="aar" name="aar" /><br/>
            <label for="forfatter_id">forfatter_id: </label>
            <input type="text" id="forfatter_id" name="forfatter_id" /><br/>
            <input type="submit" value="opret"/>
        </form>
    </jsp:body>
</t:pagetemplate>