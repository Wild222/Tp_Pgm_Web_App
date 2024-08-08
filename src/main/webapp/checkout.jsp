<%@ page session="true" import="java.util.*, model.TypeAnimal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Checkout Animaux</title>
</head>
<body bgcolor="#33CCFF">
<font face="Times New Roman,Times" size=+3>
    Checkout Animaux
</font>
<hr>
<p>

<table border="1">
    <tr>
        <th>Nom</th>
        <th>Sexe</th>
        <th>Prix</th>
        <th>Quantité</th>
    </tr>
    <c:forEach var="anOrder" items="${sessionScope.shoppingcart}" varStatus="status">
        <tr>
            <td>${anOrder.nom}</td>
            <td>${anOrder.sexe}</td>
            <td>${anOrder.prixAnimal}</td>
            <td>${anOrder.quantity}</td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="3"><b>Total</b></td>
        <td><b>${sessionScope.amount}</b></td>
        <td></td>
    </tr>
</table>

<p>
    <a href="EShop.jsp">Continuer à magasiner!</a>
</body>
</html>
