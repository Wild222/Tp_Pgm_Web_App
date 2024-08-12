<%@ page session="true" import="java.util.*, modele.CD" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="buylist" value="${sessionScope.shoppingcart}" />

<c:if test="${buylist != null && buylist.size() > 0}">
    <center>
        <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
            <tr>
                <td><b>ALBUM</b></td>
                <td><b>ARTIST</b></td>
                <td><b>COUNTRY</b></td>
                <td><b>PRICE</b></td>
                <td><b>QUANTITY</b></td>
                <td></td>
            </tr>
            <c:forEach var="anOrder" items="${buylist}" varStatus="status">
                <tr>
                    <td><b>${anOrder.album}</b></td>
                    <td><b>${anOrder.artist}</b></td>
                    <td><b>${anOrder.country}</b></td>
                    <td><b>${anOrder.price}</b></td>
                    <td><b>${anOrder.quantity}</b></td>
                    <td>
                        <form name="deleteForm" action="ShoppingServlet_0" method="POST">
                            <input type="submit" value="Delete">
                            <input type="hidden" name="delindex" value="${status.index}">
                            <input type="hidden" name="action" value="DELETE">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>
        <form name="checkoutForm" action="ShoppingServlet_0" method="POST">
            <input type="hidden" name="action" value="CHECKOUT">
            <input type="submit" name="Checkout" value="Checkout">
        </form>
    </center>
    <a href="Test.pdf">pdf</a>
</c:if>
