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
			<c:forEach var="productsFound" items="${productsFound}">
				<li class="list-group-item">${productsFound.name}</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>