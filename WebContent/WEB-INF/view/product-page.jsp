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


			<table style="width: 70%; border: 0px; align: center;">
				<tr>
					<td>
						<figure>
							<img src="https://picsum.photos/240" alt="fake image placeholder">
							<figcaption>Fake image placeholder</figcaption>
						</figure>
					</td>
					<td >
						<h3>Price: ${product.price}</h3>
						<h4>items left: ${product.quantity}</h4>
						<input type="submit" value="Add to cart">
					</td>
				</tr>
			</table>
			
			<p>Product description:<br>${product.description}</p>
		</div>
	</div>
</body>
</html>