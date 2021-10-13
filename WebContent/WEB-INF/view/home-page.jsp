<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyShop - where shopping matters</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	
	
	
	<!-- main content of page -->
	<div class="container">
	
		<!-- include file containing navigation links -->
		<%@ include file="header.jsp" %>	

		<div class="search">

			<h2>Welcome to my training shop!</h2>


			<!-- search bar -->
			<f:form action="searchProduct" modelAttribute="passingString"
				method="GET">
				<!-- search phrase input window -->
				Search for 
				<input type="text" name="searchPhrase">

				<!-- category selection dropdown list -->
				 in 
				<select name="category">
					<option>Everywhere</option>
					<c:forEach var="cat" items="${categories}">
						<option>${cat.name}</option>
					</c:forEach>
				</select>

				<!-- submit button -->
				<input type="submit" value="Go!">
				<br>
			</f:form>
		</div>

		<div class="categories">
			Categories:
			<ul>
			<c:forEach var="categories" items="${categories}">
				<li><a href="/my-allegro/${categories.name}">${categories.name}</a></li>
			</c:forEach>
			</ul>




		</div>

		<div class="main-div">
			<!-- testing sending data via model -->
			<hr>
			<br> ${greeting} <br> <br>
			<hr>
			<br>



			<h2>database connection test</h2>

			<ul class="list-group">
				<c:forEach var="products" items="${products}">
					<li class="list-group-item">${products.id}.${products.name}</li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="footer">
			<p> hello from my footer </p>
		</div>
	</div>
</body>
</html>