<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search result</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	${greeting}
	<br>
	<br> Search result placeholder...
	<br>
	<br> Searching for ${searchPhrase} in ${category}
	<br>
	<hr>
	<br> Return from Search service:
	
		<ul class="list-group">
		<c:forEach var="productsFound" items="${productsFound}">
			<li class="list-group-item">${productsFound.name}</li>
		</c:forEach>
		</ul>

</body>
</html>