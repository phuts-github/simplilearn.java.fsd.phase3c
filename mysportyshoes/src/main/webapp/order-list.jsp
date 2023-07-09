<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order list</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu-admin.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="orderListByCategory" method="post">
		<h2>Orders by Category</h2>
		<p>
			CATEGORY:<input type="number" name="id" value="0" required /> <input
				type="submit" value="Get by Category">
		</p>
	</form>
	<form action="orderListByRange" method="post">
		<h2>Orders by Dates</h2>
		<p>
			FROM DATE:<input type="text" name="fromDate" placeholder="yyyy-mm-dd" /><br>
			TO DATE:<input type="text" name="toDate" placeholder="yyyy-mm-dd" /><br>
			<input type="submit" value="Get by Date">
		</p>
	</form>
	<form action="orderList" method="post">
		<h2>Order List: Get All</h2>
		<p>
			<input type="submit" value="Get all">
		</p>
	</form>

	<c:if test="${!empty orderList}">
		<h3>Order List</h3>
		<table>
			<tr>
				<th>Action</th>
				<th>Order#</th>
				<th>Date</th>
				<th>Status</th>
				<th>Dispatch <br> Date
				</th>
				<th>Order<br> Total
				</th>
			</tr>
			<c:forEach items="${orderList}" var="item">
				<tr>
					<td><a href="/orderViewDetailsById?id=${item.id}">View</a></td>
					<td>${item.id}</td>
					<td>${item.orderDate}</td>
					<td>${item.status}</td>
					<td>${item.shipDate}</td>
					<td>${item.finalPrice}</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${!empty orderSumary}">
		<h3>Order Details</h3>

		Order# : ${orderSumary.id} &nbsp;&nbsp; 
		Date :   ${orderSumary.orderDate} &nbsp;&nbsp; 
		Status : ${orderSumary.status} &nbsp;&nbsp; 
		Dispatch Date : ${orderSumary.shipDate} &nbsp;&nbsp; 
		<br>
		Total Price : ${orderSumary.totalPrice} &nbsp;&nbsp; 
		Postage : ${orderSumary.postage} &nbsp;&nbsp; 
		Final Price : ${orderSumary.finalPrice} &nbsp;&nbsp; 
		<br>
		Name : ${orderSumary.name} &nbsp;&nbsp;
		<br>
		Address : ${orderSumary.address} &nbsp;&nbsp; 
		 	
		<c:if test="${!empty orderDetails}">
			<h3>Ordered Items</h3>
			<table>
				<tr>
					<th>Brand</th>
					<th>Category</th>
					<th>Desc</th>
					<th>Color</th>
					<th>Size</th>
					<th>Status</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${orderDetails}" var="item">
					<tr>
						<td>${item.brand}</td>
						<td>${item.category}</td>
						<td>${item.descr}</td>
						<td>${item.color}</td>
						<td>${item.size}</td>
						<td>${item.status}</td>
						<td>${item.price}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</c:if>

</body>
</html>