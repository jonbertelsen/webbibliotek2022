<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Lånere
    </jsp:attribute>

    <jsp:attribute name="footer">
            Footertekst
    </jsp:attribute>

    <jsp:body>

        <table class="table table-striped">
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

    </jsp:body>
</t:pagetemplate>