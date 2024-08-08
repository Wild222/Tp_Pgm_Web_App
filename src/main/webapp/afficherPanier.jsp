<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Votre Panier</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
<h1>Votre Panier</h1>

<c:choose>
    <c:when test="${empty animaux}">
        <p>Votre panier est vide.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Sexe</th>
                <th>Prix</th>
                <th>Quantité</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="animal" items="${animaux}">
                <tr>
                    <td>${animal.nom}</td>
                    <td>${animal.sexe}</td>
                    <td>${animal.prixAnimal}</td>
                    <td>${animal.quantite}</td>
                    <td>${animal.quantite*animal.prixAnimal}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>
