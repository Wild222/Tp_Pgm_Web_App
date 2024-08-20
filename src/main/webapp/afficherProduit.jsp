<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page session="true" %>

<fmt:setLocale value="${sessionScope.lang != null ? sessionScope.lang : 'fr_CA'}"/>
<fmt:setBundle basename="ChoixLangue"/>

<html lang="${sessionScope.lang != null ? sessionScope.lang : 'fr_CA'}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/afficherAnimal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title>Cartes avec animaux</title>
</head>
<body>
<!--Barre de naviguation-->
<nav>
    <ul>
        <li><a href="acceuil.jsp"><fmt:message key="nav.acceuil"/></a></li>
        <li><a href="#"><fmt:message key="nav.produit"/></a></li>
        <li><a href="AfficherAnimalServlet"><fmt:message key="nav.animal"/></a></li>
        <li><a href="afficherPanier.jsp"><fmt:message key="nav.panier"/></a></li>
        <li><a href="checkout.jsp"><fmt:message key="nav.paiement"/></a></li>

        <li>
            <div id="basketCounterContainer">
                <a style="color: white;" href="AfficherPanierServlet">
                    <i class="fas fa-shopping-cart">
                        &nbsp;
                        <span id="basketCounter"><c:out value="${quantite}"/></span>
                    </i>
                </a>
            </div>
        </li>
        <li>
            <!-- Choix de la langue -->
            <form action="change-language" method="get">
                <select name="lang" onchange="this.form.submit()">
                    <option value="fr_CA" style="text-align: center"
                            <c:if test="${sessionScope.lang == 'fr_CA'}">selected</c:if>>
                        <fmt:message key="nav.select.francais" />
                    </option>
                    <option value="en_US" style="text-align: center"
                            <c:if test="${sessionScope.lang == 'en_US'}">selected</c:if>>
                        <fmt:message key="nav.select.anglais" />
                    </option>
                </select>
            </form>
        </li>
    </ul>
</nav>
<!-- Afficher les cartes de produit -->
<div id="dogCardsContainer">
    <c:forEach var="produit" items="${listeProduit}">
        <div class="card">
            <img class="card-img-top" src="${produit.imageUrl}"/>
            <p class="descript-dest">
                <c:out value="${produit.nom}"/>
                <c:out value="${produit.description}"/><br>
                <fmt:message key="section.typeAnimal.quantiterDisp"/>&nbsp;<c:out value="${produit.quantiteDisponible}"/><br>
                <fmt:message key="section.typeAnimal.prix"/>&nbsp;<c:out value="${produit.prix}$"/>
            </p>
            <!-- Lorsque que l'utilisateur appuie sur ajouter ça envoie l'information à la servlet AjouterAnimal -->
            <form action="AjouterAnimalServlet" method="post">
                <input type="hidden" name="produitId" value="${produit.id}"/>
                <b><fmt:message key="section.typeAnimal.quantiter"/></b>
                <input style="width: 50px; text-align: center" type="number" name="qty" SIZE="3" value="1" min="1">
                &nbsp;
                <input class="bouton" type="submit" value="<fmt:message key='section.typeAnimal.ajouter'/>" name="ajouter" />
            </form>
        </div>
    </c:forEach>
</div>

<script src="${pageContext.request.contextPath}/javaScript/afficherAnimal.js"></script>

</body>
</html>
