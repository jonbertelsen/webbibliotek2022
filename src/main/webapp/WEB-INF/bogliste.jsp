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

        <table  class="table table-striped">
            <c:forEach var="bog" items="${requestScope.bogliste}">
                <tr>
                    <td>${bog.bogId}</td>
                    <td>${bog.titel}</td>
                    <td>${bog.forfatterNavn}</td>
                    <td>${bog.udgivelsesaar}</td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</t:pagetemplate>