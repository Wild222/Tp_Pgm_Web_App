<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${param.lang}" />
<!-- Définir le bundle de messages -->
<fmt:setBundle basename="ChoixLangue"/>

<html lang="${param.lang}">
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


                <li><a href="?lang=en_US"><fmt:message key="nav.select.anglais" /></a></li>

                <li><a href="?lang=fr_CA"><fmt:message key="nav.select.francais" /></a></li>


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

<!-- Section Produits -->
<form action="JSP/afficherProduit.jsp" name="maFormProduit">
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
</form>

</body>
</html>
