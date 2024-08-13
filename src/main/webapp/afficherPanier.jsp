<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/afficherPanier.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title>Votre Panier</title>
</head>
<body>
<!--Barre de naviguation-->
<nav>
    <ul>
        <li><a href="acceuil.html">Accueil</a></li>
        <li><a href="#">Produit</a></li>
        <li><a href="afficherAnimal.jsp">Animal</a></li>
        <li><a href="#">Panier</a></li>
    </ul>
</nav>

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

                <!--Récupération des donner de la servlet-->
                <c:set var="total" value="0"/>
                <c:forEach var="animal" items="${animaux}">
                    <c:set var="quantite" value="${animal.quantite}"/>
                    <c:set var="animalTotal" value="${animal.prixAnimal * quantite}"/>
                    <!--Prend le total actuel et ajoute si un animal est ajouter-->
                    <c:set var="total" value="${total + animalTotal}"/>

                    <!--Affichage des animaux qui sont ajouter au panier-->
                        <td>${animal.nom}</td>
                        <td>${animal.sexe}</td>
                        <td><fmt:formatNumber value="${animal.prixAnimal}" type="number" maxFractionDigits="2"/></td>
                        <td>${quantite}</td>
                        <td><fmt:formatNumber value="${animalTotal}" type="number" maxFractionDigits="2"/></td>
                    </tr>
                </c:forEach>

                <!--Donner des valeur au taxe et total d'une commande-->
                <c:set var="tps" value="${total * 0.05}"/>
                <c:set var="tvq" value="${total * 0.09975}"/>
                <c:set var="totauxAvTaxe" value="${total}"/>
                <c:set var="totauxApTaxe" value="${total + tps + tvq}"/>

                <tr>
                    <td style="background-color: rgba(71, 147, 227, 1)" colspan="3"></td>
                    <td>Total</td>
                    <!--
                    1-Formater les nombre pour qu'il soit maximum 2 chiffre apres la virgule
                    2-Affiche le total avant les taxes
                    -->
                    <td><fmt:formatNumber value="${totauxAvTaxe}" type="number" maxFractionDigits="2" /></td>
                </tr>
                <tr>
                    <td style="background-color: rgba(71, 147, 227, 1)" colspan="3"></td>
                    <td>TPS 5%</td>
                    <!--
                    1-Formater les nombre pour qu'il soit maximum 2 chiffre apres la virgule
                    2-Affiche le total des taxes pour la tps
                    -->
                    <td><fmt:formatNumber value="${tps}" type="number" maxFractionDigits="2" /></td>
                </tr>
                <tr>
                    <td style="background-color: rgba(71, 147, 227, 1)" colspan="3"></td>
                    <td>TVQ 9,9975%</td>
                    <!--
                    1-Formater les nombre pour qu'il soit maximum 2 chiffre apres la virgule
                    2-Affiche le total des taxes pour la tvq
                    -->
                    <td><fmt:formatNumber value="${tvq}" type="number" maxFractionDigits="2" /></td>
                </tr>
                <tr>
                    <td style="background-color: rgba(71, 147, 227, 1)" colspan="3"></td>
                    <td>Total Apres Taxe</td>
                    <!--
                    1-Formater les nombre pour qu'il soit maximum 2 chiffre apres la virgule
                    2-Affiche le total apres les taxes
                    -->
                    <td><fmt:formatNumber value="${totauxApTaxe}" type="number" maxFractionDigits="2" /></td>
                </tr>
                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>

<!--Ajout de la variable pour la récuperer dans checkout.jsp-->
<a href="checkout.jsp?total=${totauxApTaxe}">Payer votre facture ICI</a>
</body>
</html>
