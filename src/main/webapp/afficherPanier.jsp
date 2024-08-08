<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Panier</title>
</head>
<body>
<h1>Votre Panier</h1>
<c:if test="${not empty panier}">
    <ul>
        <c:forEach var="animalId" items="${panier}">
            <!-- Vous devrez probablement récupérer les détails des animaux depuis la base de données en fonction de l'ID -->
            <li>
                Animal ID: <c:out value="${animalId}"/>
            </li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty panier}">
    <p>Votre panier est vide.</p>
</c:if>
<a href="index.jsp">Retourner à la boutique</a>
</body>
</html>
