<%-- 
    Document   : afficherAnimal
    Created on : 16 juil. 2024, 14:07:38
    Author     : gabla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Animal</title>
    </head>
    <body>
      <h1>Animaux disponibles</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Ajouter au Panier</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.nom}</td>
                    <td>${produit.description}</td>
                    <td>${produit.prix}</td>
                    <td>${produit.quantite}</td>
                    <td>
                        <form name="shoppingForm" action="AfficherProduitServlet" method="POST">
                            <input type="hidden" name="produitId" value="${produit.id}">
                            <b>Quantité: </b><input type="text" name="qty" size="3" value="1">
                            <input type="hidden" name="action" value="ADD">
                            <input type="submit" name="Submit" value="Ajouter au panier">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="afficherPanier.jsp">Aller au panier</a>
    </body>
</html>
