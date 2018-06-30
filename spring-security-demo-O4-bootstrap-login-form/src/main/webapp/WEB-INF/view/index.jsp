<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h1>Welcome, <security:authentication property="principal.username"/> - <security:authentication property="principal.authorities"/></h1>

	<security:authorize access="hasRole('MANAGER')">
	<hr>
	<a href="${pageContext.request.contextPath}/leaders">Leadership meeting</a>
	(Only for manager people)
	<hr>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<hr>
	<a href="${pageContext.request.contextPath}/systems">Admin meeting</a>
	(Only for admin people)
	<hr>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>