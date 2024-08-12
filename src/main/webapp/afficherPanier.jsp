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
                <c:set var="total" value="0"/>
                <c:forEach var="animal" items="${animaux}">
                    <c:set var="quantite" value="${animal.quantite}"/>
                    <c:set var="totalAnimal" value="${animal.prixAnimal * quantite}"/>
                    <c:set var="total" value="${total + totalAnimal}"/>

                    <tr>
                        <td>${animal.nom}</td>
                        <td>${animal.sexe}</td>
                        <td>${animal.prixAnimal}</td>
                        <td>${quantite}</td>
                        <td><fmt:formatNumber value="${totalAnimal}" type="number" maxFractionDigits="2" /></td>
                    </tr>
                </c:forEach>

                <!-- Calcul des taxes -->
                <c:set var="tps" value="${total * 0.05 }"/>
                <c:set var="tvq" value="${total * 0.09975 }"/>
                <c:set var="totauxAvTX" value="${total}"/>
                <c:set var="totauxApTX" value="${total + tps + tvq }"/>

                <tr> <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>Total Avant-Taxe</td>
                    <td><fmt:formatNumber value="${totauxAvTX}" type="number" maxFractionDigits="2" /></td>
                </tr>

                <tr> <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>TPS 5%</td>
                    <td><fmt:formatNumber value="${tps}" type="number" maxFractionDigits="2" /></td>
                </tr>
                <tr> <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>TVQ 9,9975%</td>
                    <td><fmt:formatNumber value="${tvq}" type="number" maxFractionDigits="2" /></td>
                </tr> <tr> <td style="background-color: rgba( 71, 147, 227, 1)" colspan="3"></td>
                    <td>Total Apres-Taxe</td>
                    <td><fmt:formatNumber value="${totauxApTX}+" type="number" maxFractionDigits="2" /></td>
                </tr>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>

<a href="checkout.html">Payer votre facture ICI</a>

</body>
</html>
