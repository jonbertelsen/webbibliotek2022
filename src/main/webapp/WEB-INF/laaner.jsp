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

        <form action="laaner" method="post">
            <input type="hidden" name="command" value="fjernrediger"/>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Låner Id</th>
                    <th>Navn</th>
                    <th>Adresse</th>
                    <th>Postnr</th>
                    <th>By</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="laaner" items="${requestScope.laanerliste}">
                    <tr>
                        <td>${laaner.laaner_id}</td>
                        <td>${laaner.navn}</td>
                        <td>${laaner.adresse}</td>
                        <td>${laaner.postnummer}</td>
                        <td>${laaner.by}</td>
                        <td>
                            <button name="fjern" value="${laaner.laaner_id}">fjern</button>
                            <button name="rediger" value="${laaner.laaner_id}">rediger</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>

        <form action="laaner" method="post">
            <input type="hidden" name="command" value="opretlaanerside"/>
            <input type="submit" value="Opret ny låner">
        </form>

    </jsp:body>
</t:pagetemplate>