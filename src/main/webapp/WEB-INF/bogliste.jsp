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
                    <th></th>
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
                            <c:if test="${sessionScope.bruger != null}">
                                <button name="bogid" formaction="laanbog" value="${bog.bogId}" class="btn btn-secondary">Lån bog</button>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </jsp:body>
</t:pagetemplate>