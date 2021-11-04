<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
					<td>
						<h3>Price: ${product.price}</h3>
						<h4>items left: ${product.quantity}</h4> 
						<c:if
							test="${averageRating > 0}">
							<h4>
								Average user rating:
								<fmt:formatNumber value="${averageRating}" type="number" maxFractionDigits="1"/> 
								
							</h4>
						</c:if> <!-- put button inside form to use it as link -->
						
						<form action="cartResolution" method="POST">
							<input type="hidden" name="productId" value="${product.id}">
							<input type="submit" value="Add to cart">
						</form>
					</td>
				</tr>
			</table>

			<p>
				Product description:<br>${product.description}</p>

			<p>
				<a href="#" onClick="history.back()">Back</a>
			</p>


			<c:if test="${empty product.reviews}">
				<p>No reviews yet, write one!</p>
			</c:if>

			<form:form action="review/saveReview" modelAttribute="reviewWrapper"
				method="POST">
				<form:hidden path="productId" value="${product.id}" />
				<form:select path="rating">
					<form:option value="5" label="5" />
					<form:option value="4" label="4" />
					<form:option value="3" label="3" />
					<form:option value="2" label="2" />
					<form:option value="1" label="1" />
				</form:select>
				<form:textarea path="text" />
				<input type="submit" value="Save">
			</form:form>

			<c:forEach var="review" items="${product.reviews}">
				<p>User rating: ${review.rating}</p>
				<p>${review.text}</p>
			</c:forEach>


		</div>
	</div>

</body>
</html>