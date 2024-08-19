
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${param.lang}" />
<!-- Définir le bundle de messages -->
<fmt:setBundle basename="ChoixLangue"/>

<html lang="${param.lang}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/afficherAnimal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title><fmt:message key="page.affichageAnimaux"/></title>
</head>
<body>
<!--Barre de naviguation-->
<nav>
    <ul>
        <li><a href="acceuil.jsp"><fmt:message key="nav.affichageAnimaux.acceuil"/></a></li>
        <li><a href="#"><fmt:message key="nav.affichageAnimaux.produit"/></a></li>
        <li><a href="#"><fmt:message key="nav.affichageAnimaux.animal"/></a></li>
        <li><a href="afficherPanier.jsp"><fmt:message key="nav.affichageAnimaux.panier"/></a></li>
        <li><a href="?lang=en_US"><fmt:message key="nav.select.anglais"/></a></li>
        <li><a href="?lang=fr_CA"><fmt:message key="nav.select.francais"/></a></li>
        <li><a href="AfficherPanierServlet"><fmt:message key="nav.affichageAnimaux.paiement"/></a></li>
        <li><a href="checkout.jsp"><fmt:message key="section.affichageAnimaux.linkPaiement"/></a></li>
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
    </ul>
</nav>

<div id="dogCardsContainer">
    <c:forEach var="animal" items="${animaux}">
        <div class="card">
            <img class="card-img-top" src="${animal.imageUrl}"/>
            <p class="descript-dest">
                <c:out value="${animal.nom}"/>
                (<c:out value="${animal.sexe}"/>) <br>
                Prix: <c:out value="${animal.prixAnimal}"/>
            </p>
            <!-- Lorsque que l'utilisateur appuie sur ajouter, ça envoie l'information à la servlet AjouterAnimal -->
            <form action="AjouterAnimalServlet" method="post">
                <input type="hidden" name="animalId" value="${animal.id}"/>
                <b>Quantité: </b>
                <input style="width: 50px" type="number" name="qty" size="3" value="1" min="1">
                &nbsp;
                <input class="bouton" type="submit" value="<fmt:message key='ajouterAuPanier'/>" name="ajouter"/>
            </form>
        </div>
    </c:forEach>

    <script src="${pageContext.request.contextPath}/javaScript/afficherAnimal.js"></script>
</div>
</body>
</html>
