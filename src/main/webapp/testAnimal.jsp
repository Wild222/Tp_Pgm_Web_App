<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>Animal List</title>
</head>
<body bgcolor="#33EEFF">
<h1>List of Animals</h1>
<hr>
<c:out value="${animaux}" />
<ul style="text-align: center;">
    <c:choose>
        <c:when test="${not empty animaux}">
            <c:forEach var="animal" items="${animaux}">
                <li>
                    <strong>Id: </strong>${animal.id}<br>
                    <strong>Name:</strong> ${animal.nom} <br>
                    <strong>Sexe:</strong> ${animal.sexe} <br>
                    <strong>Price:</strong> ${animal.prixAnimal} <br>
                </li>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <li>No animals found.</li>
        </c:otherwise>
    </c:choose>
</ul>
</body>
</html>
