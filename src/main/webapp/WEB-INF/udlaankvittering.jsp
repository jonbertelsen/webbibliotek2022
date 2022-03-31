<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Udlånskvittering
    </jsp:attribute>

    <jsp:attribute name="footer">
            Udlånskvittering
    </jsp:attribute>

    <jsp:body>

        <p>Tak for dit udlån. Det gik godt</p>
        <p>Du har lånt bogen "${requestScope.bog.titel}"</p>

    </jsp:body>
</t:pagetemplate>