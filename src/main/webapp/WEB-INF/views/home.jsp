<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello Keep Shopping   
</h1>

<img src = "/spring/resources/download.png">

<P>  The time on the server is ${serverTime}. </P>

<table>
		<tr>
			<td><a href="/spring/">Home</a></td>
			<td><a href="/spring/showCustomers">List Customers</a></td>
			<td><a href="/spring/showProducts">List Products</a></td>
			<td><a href="/spring/showOrders">List Orders</a></td> 
		</tr>
	</table>
</body>
</html>
