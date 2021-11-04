<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>MyShop - ...</title>
</head>
<body>
<div class="container">
<%@include file="header.jsp" %>
cart placeholder<br>
product added:<br>
name: ${product.name}<br>
id: ${product.id}<br>
price: ${product.price}<br><br><br>
number of products in cart: ${productsInCart}<br>
total price: ${cart.totalPrice}
<br><br><br>
<a href=# onclick="history.back()">Back</a>
<a href="cart">Show shopping cart</a>

</div>
</body>
</html>