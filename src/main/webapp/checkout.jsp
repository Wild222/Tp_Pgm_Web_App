<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>GevStack - Order confirm animation</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,500,700&amp;display=swap'>
    <link rel="stylesheet" href="css/checkout.css">
    <link rel="stylesheet" href="css/navbar.css">
</head>

<!--
1-Tableau qui prend les renseignements pour le paiement
2-Afiichage du montant avec le montant de la jsp afficherPanier.jsp
-->
<body>
<div>
    <!--Barre de naviguation-->
    <nav>
        <ul>
            <li><a href="acceuil.jsp">Accueil</a></li>
            <li><a href="AfficherProduitServlet">Produit</a></li>
            <li><a href="AfficherAnimalServlet">Animal</a></li>
            <li><a href="afficherPanier.jsp">Panier</a></li>
            <li><a href="#">Retour au Paiement</a></li>
        </ul>
    </nav>

    <div class="component">
        <div class="form-container">
            <table border="1">
                <thead>
                <tr>
                    <th>Information Personnelle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" placeholder="Nom"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="Prénom"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="Courriel"/></td>
                </tr>
                <thead>
                <tr>
                    <th>Information Carte</th>
                </tr>
                </thead>
                <tr>
                    <td><input type="text" placeholder="Titulaire de la carte"/></td>
                </tr>
                <tr>
                    <td>
                        Mode de Paiement<br>
                        <input type="radio" name="modeP" value="VISA" />VISA<br>
                        <input type="radio" name="modeP" value="MASTER CARD" />MASTER CARD<br>
                    </td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="Numéro de carte"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="Date d'expiration"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="CCV"/></td>
                </tr>
                <tr>

                    <td>
                        Montant à Payer:<br>
                        <!--
                        récupération de la variable totauxApTaxe pour afficher
                        le montant a payer au moment de compléter la commande
                        -->
                       <fmt:formatNumber value="${param.total}" type="number" maxFractionDigits="2" />
                    </td>
                </tr>

                <tr>
                    <td class="boutonCheckout">
                        <!--Bouton trouver sur internet je l'aimais-->
                        <button class="order">
                            <span class="default">Terminer Votre Commande</span>
                            <span class="success">Commande Effectuer
                                <svg viewbox="0 0 12 10">
                                    <polyline points="1.5 6 4.5 9 10.5 1"></polyline>
                                </svg>
                            </span>
                            <div class="box"></div>
                            <div class="truck">
                                <div class="back"></div>
                                <div class="front">
                                    <div class="window"></div>
                                </div>
                                <div class="light top"></div>
                                <div class="light bottom"></div>
                            </div>
                            <div class="lines"></div>
                        </button>
                    </td>
                </tr>


                </tbody>
            </table>
            <div class="image">
                <img src="images/petStore.jpeg" alt="store">
            </div>
        </div>
    </div>

<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src="javaScript/checkout.js"></script>
</div>
</body>
</html>
