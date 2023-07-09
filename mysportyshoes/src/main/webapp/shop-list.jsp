<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop Listing</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<h2>Todays Specials</h2>
	<table>
		<tr>
			<th>Action</th>
<!-- 			<th>TYPE</th> -->
			<th>BRAND</th>
			<th>CATEGORY</th>
			<th>DESC</th>
			<th>COLOR</th>
			<th>SIZE</th>
			<th>STATUS</th>
			<th>PRICE</th>
		</tr>
		<c:forEach items="${entries}" var="item">
			<tr>
				<td><a href="/basketAdd?id=${item.id}">Buy</a></td>
<%-- 				<td>${item.type}</td> --%>
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

	<c:if test="${basketCount > 0}">

		<h2>Basket items</h2>
		<p>
			Item Count : ${basketCount} | Basket Total: ${basketTotal} | <a
				href="/basketCheckout">Checkout Now</a>
		</p>

		<table>
			<tr>
				<th>Action</th>

				<th>BRAND</th>
				<th>CATEGORY</th>
				<th>DESC</th>
				<th>COLOR</th>
				<th>SIZE</th>
				<th>STATUS</th>
				<th>PRICE</th>
			</tr>
			<c:forEach items="${sessBasket}" var="item">
				<tr>
					<td><a href="/basketDelete?id=${item.id}">Delete</a></td>

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
		<br>
	</c:if>
</body>
</html>