
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
        <li><a href="acceuil.html">Accueil</a></li>
        <li><a href="#">Produit</a></li>
        <li><a href="#">Animal</a></li>
        <li><a href="afficherPanier.jsp">Panier</a></li>
        <li><a href="checkout.jsp">Retour au Paiement</a></li>
        <li><div id="basketCounterContainer">
            <a style="color: black;" href="AfficherPanierServlet">
                <i class="fas fa-shopping-cart"></i>
            </a>
            <span id="basketCounter">  <c:out value="${quantite}"/> </span>
            <%--    <input type="button" name="ViderPanier" >--%>

        </div></li>
    </ul>
</nav>
<br>
<br>

<div id="dogCardsContainer">


    <c:forEach var="animal" items="${animaux}">
        <div class="card">

            <img class="card-img-top" src="${animal.imageUrl}"/>
            <p class="descript-dest">
                <c:out value="${animal.nom}"/>
                (<c:out value="${animal.sexe}"/>) <br>
                Prix: <c:out value="${animal.prixAnimal}"/>

            </p>
                    <!--Lorsque que l'utilisateur appuie sur ajouter ca envoie l'information a la servlet ajouteranimal-->
                    <form action="AjouterAnimalServlet" method="post">
                        <input type="hidden" name="animalId" value="${animal.id}"/>
                        <b>Quantity: </b><input type="number" name="qty" SIZE="3" value=1 min="1">
                        <button type="submit"  style="line-height:2px ; height:34px;width:150px;border:3px solid darkblue; font-size: smaller" name="ajouter" data-mdb-button-init="" data-mdb-ripple-init="" class="btn btn-primary btn-lg" data-mdb-button-initialized="true" style="">Ajouter au panier</button>
<%--                    <button class="btnAnimal" type="submit" name="ajouter">Ajouter au panier</button>--%>
                    </form>

        </div>
    </c:forEach>


    <script src="${pageContext.request.contextPath}/javaScript/afficherAnimal.js"></script>
</div>
</body>
</html>
