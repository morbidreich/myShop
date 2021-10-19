<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<form:form action="saveUser" modelAttribute="user" method="POST">
			<form:hidden path="id"/>
			<form:input path="name" />
			<form:input path="surname" />
			<input type="submit" value="Save">
		</form:form>


	</div>
</body>
</html>