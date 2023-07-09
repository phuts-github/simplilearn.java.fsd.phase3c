<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout Listing</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<c:if test="${basketCount > 0}">

		<h2>Basket items</h2>
		<p>Item Count : ${basketCount} | Basket Total: ${basketTotal}
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
					<td><a href="/basketDelete?id=${item.id}">Remove</a></td>

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

		<h2>Payment Details</h2>
		<form action="/basketPay" method="post">
			<p>
				Card Type: <input type="text" name="cardType"
					placeholder="Visa / Master Card / Revolut" required />
			</p>
			<p>
				Card Holder Name: <input type="text" name="holderName"
					placeholder="Card holder name" required />
			</p>
			<p>
				Card Number: <input type="number" name="cardNo"
					placeholder="Card number" />
			</p>
			<p>
				Expiry Date: <input type="text" name="expiryDate"
					placeholder="Expiry date" required />
			</p>
			<p>
				Security No: <input type="number" name="securityNo"
					placeholder="Three digits at the back" required />
			</p>
			<p>
				<input type="submit" value="Pay Now" />
			</p>
		</form>
	</c:if>


</body>
</html>