<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>MyShop - ${product.name}</title>
</head>
<body>
	<div class="container">
		<div class="main-div">
			<%@include file="header.jsp"%>

			<h1>${product.name}</h1>

			<figure>
				<img src="https://picsum.photos/200" alt="fake image placeholder">
				<figcaption>Fake image placeholder</figcaption>
			</figure>


			<h3>Price: ${product.price}, items left: ${product.quantity}</h3>
			<h4>${product.description}</h4>
			<br> <input type="submit" value="Place in cart">
		</div>
	</div>
</body>
</html>