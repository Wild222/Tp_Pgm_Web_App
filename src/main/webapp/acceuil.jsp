<!doctype html>

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
    <link rel="stylesheet" href="css/acceuil.css">
    <link rel="stylesheet" href="css/navbar.css">
    <title><fmt:message key="page.acceuil"/></title>
</head>
<body>
<!--Barre de navigation-->
<nav>
    <ul>
        <li><a href="#"><fmt:message key="nav.acceuil"/></a></li>
        <li><a href="#"><fmt:message key="nav.produit"/></a></li>
        <li><a href="AfficherAnimalServlet"><fmt:message key="nav.animal"/></a></li>
        <li><a href="afficherPanier.jsp"><fmt:message key="nav.panier"/></a></li>
        <li><a href="checkout.jsp"><fmt:message key="nav.paiement"/></a></li>
        <li>
            <form action="change-language" method="get">
                <select name="lang" onchange="this.form.submit()">
                    <option value="fr_CA" <c:if test="${sessionScope.lang == 'fr_CA'}">selected</c:if>><fmt:message key="nav.select.francais" /></option>
                    <option value="en_US" <c:if test="${sessionScope.lang == 'en_US'}">selected</c:if>><fmt:message key="nav.select.anglais" /></option>
                </select>
            </form>
        </li>
    </ul>
</nav>

<!-- Contenu de la page -->
<header>
    <div class="header">
        <h1><fmt:message key="header.bienvenue"/></h1>
        <p>
        <h3><fmt:message key="header.description"/></h3>
        </p>
    </div>
</header>

<!-- Section images  -->
<div class="containerImage">
    <img src="images/chien1.jpg">
    <img src="images/chat2.jpeg">
    <img src="images/cheval2.jpeg">
    <img src="images/lapin1.jpeg">
    <img src="images/oiseau1.jpeg">
</div>

<!-- Section Animaux -->
<form action="AfficherAnimalServlet" name="maFormAnimal">
    <div class="container">
        <img class="image" src="images/ima_1.jpeg" width="650" height="350" alt="ima_1"/>
        <div class="text-container">
            <h3><fmt:message key="section.animalDisp"/></h3>
            <ul style="text-align: left;">
                <li><fmt:message key="section.chien"/></li>
                <li><fmt:message key="section.chat"/></li>
                <li><fmt:message key="section.cheval"/></li>
                <li><fmt:message key="section.oiseau"/></li>
                <li><fmt:message key="section.hamster"/></li>
                <li><fmt:message key="section.perroquet"/></li>
            </ul>
            <input class="bouton" type="submit" value="<fmt:message key='section.animalDisp.bouton'/>" name="typeAnimal"/>
        </div>
    </div>
</form>
<br>
<br>
<!-- Section Produits
<form action="#" name="maFormProduit">
    <div class="container-reverse">
        <img class="image" src="images/ima_2.jpeg" width="800" height="350" alt="ima_2"/>
        <div class="text-container">
            <h3><fmt:message key="section.produitDisp"/></h3>
            <ul style="text-align: left;">
                <li><fmt:message key="section.nourriture"/></li>
                <li><fmt:message key="section.collier"/></li>
                <li><fmt:message key="section.cage"/></li>
                <li><fmt:message key="section.jouet"/></li>
            </ul>
            <input class="bouton" type="submit" value="<fmt:message key='section.produit.bouton'/>" name="typeProduit"/>
        </div>
    </div>
</form>-->
</body>
</html>
