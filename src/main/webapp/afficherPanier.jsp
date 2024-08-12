<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/afficherPanier.css">
    <title>Votre Panier</title>

</head>
<body>
<h1>Votre Panier</h1>

<c:choose>
    <c:when test="${empty animaux}">
        <p>Votre panier est vide.</p>
    </c:when>
    <c:otherwise>
        <div class="table-wrapper">
        <table class="fl-table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Sexe</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Total</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="animal" items="${animaux}">
                <c:set var="quantite" value="${animal.quantite}"/>
                <c:set var="total" value="${animal.prixAnimal * quantite}"/>
                <c:set var="tps" value="${totaux * 0.05 }"/>
                <c:set var="tvq" value="${totaux * 0.09975 }"/>
                <c:set var="totaux" value="${total + tps + tvq }"/>
                <tr>
                    <td>${animal.nom}</td>
                    <td>${animal.sexe}</td>
                    <td>${animal.prixAnimal}</td>

                    <td>${quantite}</td>
                    <td>${total}</td>
                </tr>
            </c:forEach>
                <tr>
                    <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>TPS 5%</td>
                    <td><fmt:formatNumber value="${tps}" type="number" maxFractionDigits="2" /></td>
                </tr>
                <tr>
                    <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>TVQ 9,9975%</td>
                    <td><fmt:formatNumber value="${tvq}" type="number" maxFractionDigits="2" /></td>
                </tr>
                <tr>
                    <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>Totaux</td>
                    <td><fmt:formatNumber value="${totaux}" type="number" maxFractionDigits="2" /></td>
                </tr>

            </tbody>
        </table>
        </div>
    </c:otherwise>
</c:choose>

<a href="checkout.html">Payer votre facture ICI</a>

</body>
</html>
