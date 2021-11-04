<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>MyShop - cart</title>
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>
		<h3>You have ${itemsNo} items in cart</h3>

		<table>
			<tr>
				<th>Product name</th>
				<th>Price</th>
				<th>Action</th>
			<tr>
			<c:forEach var="product" items="${items}">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td><a href="cart/remove?id=${product.id}">Remove from cart</a></td>
			</c:forEach>
		</table>


		<a href=# onclick="history.back()">Back</a>


	</div>
</body>
</html>