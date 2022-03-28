<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
              Bogliste
    </jsp:attribute>

    <jsp:attribute name="footer">
            Boglisten
    </jsp:attribute>

    <jsp:body>
        <form method="post">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Bog Id</th>
                    <th>Titel</th>
                    <th>Forfatter navn</th>
                    <th>Udgivelsesår</th>
                    <th>Kommando</th>
                </tr>

                </thead>
                <tbody>
                <c:forEach var="bog" items="${requestScope.bogliste}">
                    <tr>
                        <td>${bog.bogId}</td>
                        <td>${bog.titel}</td>
                        <td>${bog.forfatterNavn}</td>
                        <td>${bog.udgivelsesaar}</td>
                        <td>
                            <button name="fjern" value="${bog.bogId}" formaction="fjernbog">fjern</button>
                            <button name="rediger" value="${bog.bogId}" formaction="redigerbog">rediger</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button name="opret" formaction="opretbogform">opret</button>
        </form>


    </jsp:body>
</t:pagetemplate>