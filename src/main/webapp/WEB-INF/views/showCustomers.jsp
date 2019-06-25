<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Customer</title>
</head>
<body>
	<h1>Show Customers</h1>


	<table border="2">
		<tr>
			<th>Customer ID</th>
			<th>Customer Name</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>

				<td><a href="content_update?cId=${customer.cId}&cName=${customer.cName}&cPassword=${customer.cPassword}">${customer.cId}</td>
				<td>${customer.cName}</td>

			</tr>
		</c:forEach>
	</table>


	<table>
		<tr>
			<td><a href="/spring/">Home</a></td>
			<td><a href="/spring/addCustomer">Add Customers</a></td>
			<td><a href="/spring/showProducts">List Product</a></td>
			<td><a href="/spring/showOrders">List Orders</a></td>
			<td><a href="/spring/logout">Logout</a></td>
		</tr>
	</table>
</body>
</html>