<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyShop - where shopping matters</title>
</head>
<body>
	<h1>Welcome to my training shop!</h1>

	<!-- search bar -->
	<f:form action="searchProduct" modelAttribute="passingString" method="GET">
		<!-- search phrase input window -->
		<input type="text" name="searchPhrase">

		<!-- category selection dropdown list -->
		<select name="category">
			<c:forEach var="cat" items="${categories}">
				<option>${cat.name}</option>
			</c:forEach>
		</select>

		<!-- submit button -->
		<input type="submit" value="Search!"> <br>
	</f:form>

	<!-- testing sending data via model -->
	<hr>
	<br> ${greeting}
	<br>
	<br>
	<hr>
	<br>



	<h2>database connection test</h2>

	<c:forEach var="products" items="${products}">
		<p>${products.id}.${products.name}</p>
	</c:forEach>



</body>
</html>