<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}

	<c:if test="${!empty userEntry}">
		<h2>My Profile</h2>

		Unique ID :${userEntry.id} <br>
		Email : ${userEntry.email} <br>
		Name : ${userEntry.name} <br>
		Address : ${userEntry.address} <br>

		<h2>Change Password</h2>
		<form action="userPassUpdate" method="post">
			Current Password : <input type="password" name="oldPass" required /><br>
			Enter New Password : <input type="password" name="newPass" required /><br>
			Confirm New Password : <input type="password" name="confNewPass"
				required /><br> 
				<input type="submit" value="Update">
		</form>
	</c:if>

	<c:if test="${!empty userMyOrders}">
		<h3>My Orders</h3>
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
			<c:forEach items="${userMyOrders}" var="item">
				<tr>
					<td><a href="/userOrderViewDetailsById?id=${item.id}">View</a></td>
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

	<c:if test="${empty userMyOrders}">
		<h3>No orders for you.</h3>
	</c:if>

	<c:if test="${!empty userOrderSumary}">
		<h3>Order Details</h3>

		Order# : ${userOrderSumary.id} &nbsp;&nbsp; 
		Date :   ${userOrderSumary.orderDate} &nbsp;&nbsp; 
		Status : ${userOrderSumary.status} &nbsp;&nbsp; 
		Dispatch Date : ${userOrderSumary.shipDate} &nbsp;&nbsp; 
		<br>
		Total Price : ${userOrderSumary.totalPrice} &nbsp;&nbsp; 
		Postage : ${userOrderSumary.postage} &nbsp;&nbsp; 
		Final Price : ${userOrderSumary.finalPrice} &nbsp;&nbsp; 
		<br>
		Name : ${userOrderSumary.name} &nbsp;&nbsp;
		<br>
		Address : ${userOrderSumary.address} &nbsp;&nbsp; 
		 	
		<c:if test="${!empty userOrderDetails}">
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
				<c:forEach items="${userOrderDetails}" var="item">
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