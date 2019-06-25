<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h1>Add New Order</h1>
	
	<form:form modelAttribute="order">
		<table>
			<tr>
			  	<td>Customer ID:</td>
				<td><form:input path="cust.cId"></form:input></td>
				<td><form:errors path="cust.cId"></form:errors></td>
			</tr>
			
			<tr>
			  	<td>Product ID:</td>
				<td><form:input path="prod.pId"></form:input></td>
				<td><form:errors path="prod.pId"></form:errors></td>
			</tr>
			
			<tr>
			  	<td>Quantity:</td>
				<td><form:input path="qty"></form:input></td>
				<td><form:errors path="qty"></form:errors></td>
			</tr>
				
			<tr>
				<td><input type="submit" value="Add"/></td>
			</tr>
			
		</table>
	</form:form>

	<br/>
	
	<table>
		<tr>
			<td><a href="/spring/">Home</a></td>
			<td><a href="/spring/showOrders">List Orders</a></td>
			<td><a href="/spring/showProducts">List Products</a></td>
			<td><a href="/spring/showCustomers">List Customers</a></td>
		</tr>
	</table>
</body>
</html>