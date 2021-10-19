<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>MyShop - ...</title>
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>

		<h2>Users</h2>
		<p>(after adding security this will be only available to shop
			admin)</p>
		<hr>
		<div>
			<a href="addUserForm">Add user</a>
		</div>
		<br>

		<table>
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Actions</th>
			</tr>

			<!-- iterate through user -->
			<c:forEach var="user" items="${users}">
			
			<!-- prepare update link -->
			<c:url var="updateLink" value="updateUserForm?userId=${user.id}"/>
			
			<!-- prepare delete link -->
			<c:url var="deleteLink" value="deleteUser">
				<c:param name="userId" value="${user.id}"/>
			</c:url>
			
				<tr>
					<td>${user.name}</td>
					<td>${user.surname}</td>
					<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
				</tr>
			</c:forEach>


		</table>


	</div>
</body>
</html>