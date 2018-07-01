<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer confirmation page</title>
</head>
<body>

<h2>Customer confirmed...</h2>
<hr>
First Name: ${customer.getFirstName()} <br>
Last Name: ${customer.getLastName()} <br>
Mobile: ${customer.getMobile()} <br>
Email: ${customer.getEmail()} <br>
Free Passes: ${customer.getFreePasses()} <br>
Customer Code: ${customer.getCustomerCode()}
<hr>
<a href="${pageContext.request.contextPath}/">Go Back</a>
</body>
</html>