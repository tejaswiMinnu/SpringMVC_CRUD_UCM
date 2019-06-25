<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Show Products</title>
</head>
<body>
	<h1>Show Products</h1>
	
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<p:forEach items="${products}" var="product">
				<tr>
					<td>${product.pId}</td>
					<td>${product.pDesc}</td>
					<td>${product.qtyInStock}</td>
				</tr>
			</p:forEach>
		</tr>
	</table>
	<table>
		<tr>
			<td><a href="/spring/">Home</a></td>
			<td><a href="/spring/addProduct">Add Product</a></td>
			<td><a href="/spring/showCustomers">List Customers</a></td>
			<td><a href="/spring/showOrders">List Orders</a></td> 
		</tr>
	</table>
</body>
</html>