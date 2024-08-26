<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/afficherPanier.css">
    <script src="${pageContext.request.contextPath}/javaScript/afficherAnimal.js"></script>
    <link rel="stylesheet" href="css/navbar.css">
    <title>Votre Panier</title>
</head>
<body>
<!--Barre de navigation-->
<nav>
    <ul>
        <li><a href="acceuil.jsp">Accueil</a></li>
        <li><a href="AfficherAnimalServlet">Animal</a></li>
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
                <!-- Récupération des données de la servlet -->
                <c:set var="total" value="0"/>
                <c:forEach var="animal" items="${animaux}">
                    <c:set var="quantite" value="${animal.quantite}"/>
                    <c:set var="animalTotal" value="${animal.prixAnimal * quantite}"/>
                    <c:set var="total" value="${total + animalTotal}"/>
                    <tr>
                        <td>${animal.nom}<br></td>
                        <td>${animal.sexe}</td>
                        <td>
                            <fmt:formatNumber value="${animal.prixAnimal}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                        </td>
                        <td>
                            <form action="AjouterAnimalServlet" method="post">
                                <input type="hidden" name="animalId" value="${animal.id}"/>
                                <input type="hidden" name="qty" value="${quantite}"/>
                                <div class="quantity-button">
                                    <button type="submit" name="supprimer" value="true">-</button>
                                    <p class="quantity">${quantite}</p>
                                    <button type="submit" name="ajouter" value="true">+</button>
                                </div>
                            </form>
                        </td>
                        <td>
                            <fmt:formatNumber value="${animalTotal}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                            <form action="AfficherPanierServlet" method="post">
                                <input type="hidden" name="animalId" value="${animal.id}"/>
                                <button type="submit" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet animal ?');">Supprimer</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                <!-- Calcul des taxes et des totaux -->
                <c:set var="tps" value="${total * 0.05}"/>
                <c:set var="tvq" value="${total * 0.09975}"/>
                <c:set var="totauxAvTaxe" value="${total}"/>
                <c:set var="totauxApTaxe" value="${total + tps + tvq}"/>

                <tr>
                    <td colspan="3"></td>
                    <td>Total</td>
                    <td>
                        <!-- Formatage du total avant taxes -->
                        <fmt:formatNumber value="${totauxAvTaxe}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td>TPS 5%</td>
                    <td>
                        <!-- Formatage de la TPS -->
                        <fmt:formatNumber value="${tps}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td>TVQ 9.9975%</td>
                    <td>
                        <!-- Formatage de la TVQ -->
                        <fmt:formatNumber value="${tvq}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td>Total Avec les Taxes</td>
                    <td>
                        <!-- Formatage du total après taxes -->
                        <fmt:formatNumber value="${totauxApTaxe}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
    </c:otherwise>
</c:choose>

<!-- Formulaire pour la facturation -->
<form action="UpdateBBDServlet" method="post">
    <c:forEach var="animal" items="${animaux}">
        <input type="hidden" name="animalId" value="${animal.id}"/>
        <input type="hidden" name="qty_${animal.id}" value="${animal.quantite}"/>
    </c:forEach>
    <input type="hidden" name="total" value="${totauxApTaxe}"/>
    <button type="submit">Payer Votre Commande ICI</button>
</form>
<script src="${pageContext.request.contextPath}/javaScript/afficherAnimal.js"></script>
</body>
</html>
