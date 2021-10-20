<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search result</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	<div class="container">
		<%@include file="header.jsp"%>


		${greeting} <br> <br> Search result placeholder... <br>
		<br> Searching for ${searchPhrase} in ${category} <br>
		<hr>
		<br> Return from Search service:

		<ul class="list-group">
			<c:forEach var="product" items="${productsFound}">


				<!-- create 'product' link with product id as param -->
				<c:url var="productLink" value="/productPage">
					<c:param name="productId" value="${product.id}" />
				</c:url>
				
				<c:url var="categoryLink" value="/${product.category.name}"/>
				
				

				<li class="list-group-item">
					<a href="${categoryLink}">${product.category.name}</a> > 
				
				
					<a href="${productLink}">
						${product.name} 
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>