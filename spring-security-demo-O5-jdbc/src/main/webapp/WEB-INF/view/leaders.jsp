<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leaders Page</title>
</head>
<body>
<h1>Welcome, <security:authentication property="principal.username"/></h1>
<hr>
<h2>See you at Mumbai for annual meeting...</h2>
<hr>
<a href="${pageContext.request.contextPath}/">Back to homepage</a>
</body>
</html>