<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Update Customer</h1>
	<h2>Name :  ${content_update.cName}</h2>
	<form action="content_update" method="post"
		modelAttribute="content_update">
		<table border="2">
			<tr>
				<td>ID</td>
				<td><input type="text" name="cId" readonly="readonly"
					value="${content_update.cId}"></td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="cName"
					value="${content_update.cName}"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="cPassword"
					value="${content_update.cPassword}"></td>
			</tr>
		</table>
		<input type="submit" value="update" />

	</form>

	<br />

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