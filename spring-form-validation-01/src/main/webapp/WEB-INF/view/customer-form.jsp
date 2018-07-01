<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>Customer registration form</h2>
	<br>
	<hr>
	<form:form action="process-form" modelAttribute="customer"
		method="POST">

		First Name: <form:input path="firstName" />
		<br>
		<br>
		Last Name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />
		<br>
		<br>
		Mobile: <form:input path="mobile" />
		<form:errors path="mobile" cssClass="error" />
		<br>
		<br>
		Email: <form:input path="email" />
		<br>
		<br>
		Free Passes: <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		<br>
		<br>
		Customer Code: <form:input path="customerCode" />
		<form:errors path="customerCode" cssClass="error" />
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>