<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyShop - where shopping matters</title>
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous"> -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="container">

		<div class="search-header">

			Welcome to my training shop!


			<!-- search bar -->
			<f:form action="searchProduct" modelAttribute="passingString"
				method="GET">
				<!-- search phrase input window -->
				<input type="text" name="searchPhrase">

				<!-- category selection dropdown list -->
				<select name="category">
					<c:forEach var="cat" items="${categories}">
						<option>${cat.name}</option>
					</c:forEach>
				</select>

				<!-- submit button -->
				<input type="submit" value="Search!">
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