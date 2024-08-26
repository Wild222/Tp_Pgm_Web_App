<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang != null ? sessionScope.lang : 'fr_CA'}"/>
<fmt:setBundle basename="ChoixLangue"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="${sessionScope.lang != null ? sessionScope.lang : 'fr_CA'}">
<head>
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/AuRevoir.css">
    <title><fmt:message key="page.merci"/></title>
</head>
<body>

<!--Barre de navigation-->
<nav>
    <ul>
        <li><a href="acceuil.jsp"><fmt:message key="nav.acceuil"/></a></li>
        <li><a href="AfficherAnimalServlet"><fmt:message key="nav.animal"/></a></li>
        <li><a href="#"><fmt:message key="nav.panier"/></a></li>
        <li>
            <form action="ChangeLanguageServlet" method="get">
                <select name="lang" onchange="this.form.submit()">
                    <option value="fr_CA" <c:if test="${sessionScope.lang == 'fr_CA'}">selected</c:if>><fmt:message key="nav.select.francais" /></option>
                    <option value="en_US" <c:if test="${sessionScope.lang == 'en_US'}">selected</c:if>><fmt:message key="nav.select.anglais" /></option>
                </select>
            </form>
        </li>
    </ul>
</nav>

<div class="text">
    <h1><fmt:message key="page.auRevoir"/></h1>
    <h2><fmt:message key="page.client"/></h2>
</div>

</body>
</html>
