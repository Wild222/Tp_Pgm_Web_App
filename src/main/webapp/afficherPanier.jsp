<%@ page session="true" import="java.util.*, model.ProduitAnimal" %>
<%@ page session="true" import="java.util.*, model.TypeAnimal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="buylist" value="${sessionScope.shoppingcart}" />
<h1>Résumé de votre panier</h1>
<c:if test="${buylist != null && buylist.size() > 0}">
    <center>
        <table border="1" cellpadding="0" width="100%" bgcolor="#FFFFFF">
            <tr>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Supprimer</th>
            </tr>
            <c:forEach var="anOrder" items="${buylist}" varStatus="status">
                <tr>
                    <td>${anOrder.nom}</td>
                    <td>${anOrder.description}</td>
                    <td>${anOrder.prix}</td>
                    <td>1</td>
                    <td>
                        <form name="deleteForm" action="AfficherProduitServlet" method="POST">
                         <input type="submit" value="Supprimer">
                            <input type="hidden" name="delindex" value="${status.index}">
                            <input type="hidden" name="action" value="DELETE">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
        <form name="checkoutForm" action="AfficherProduitServlet" method="POST">
            <input type="hidden" name="action" value="CHECKOUT">
            <input type="submit" name="Checkout" value="Checkout">
        </form>
    </center>
</c:if>
<a href="checkout.jsp">Payer vos articles ici</a>
