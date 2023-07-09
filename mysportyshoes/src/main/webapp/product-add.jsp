<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu-admin.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="productAddUpdate" method="post">
		<h2>Product: Add / Update</h2>
		<c:if test="${!empty entry}">
			<c:forEach items="${entry}" var="item">
				<p>
					ID:<input type="number" name="id" value="${item.id}"
						readonly='readonly' />
				</p>
				<p>
					CATEGORY:<input type="text" name="category" value="${item.id}"
						required />
				</p>
				<p>
					BRAND:<input type="text" name="brand" value="${item.brand}"
						required />
				</p>
				<p>
					CODE:<input type="text" name="code" value="${item.code}" required />
				</p>
				<p>
					DESC:<input type="text" name="descr" value="${item.descr}" required />
				</p>
				<p>
					COLOR:<input type="text" name="color" value="${item.color}"
						required />
				</p>
				<p>
					SIZE:<input type="number" name="size" value="${item.size}" required />
				</p>
				<p>
					STATUS:<input type="text" name="status" value="${item.status}"
						required />
				</p>
				<p>
					PRICE:<input type="number" name="price" value="${item.price}"
						required />
				</p>
			</c:forEach>
		</c:if>
		<c:if test="${empty entry}">
			<p>
				ID:<input type="number" name="id" value="0" readonly='readonly' />
			</p>
			<p>
				CATEGORY:<input type="text" name="category"
					placeholder="Enter category" required />
			</p>
			<p>
				BRAND:<input type="text" name="brand" placeholder="Enter brand"
					required />
			</p>
			<p>
				CODE:<input type="text" name="code" placeholder="Enter code"
					required />
			</p>
			<p>
				DESC:<input type="text" name="descr" placeholder="Enter desc"
					required />
			</p>
			<p>
				COLOR:<input type="text" name="color" placeholder="Enter color"
					required />
			</p>
			<p>
				SIZE:<input type="number" name="size" placeholder="Enter size"
					required />
			</p>
			<p>
				STATUS:<input type="text" name="status" placeholder="Enter status"
					required />
			</p>
			<p>
				PRICE:<input type="number" name="price" placeholder="Enter price"
					required />
			</p>
		</c:if>
		<p>
			<input type="submit" value="Add / Update"> <input
				type="reset" value="Undo">
		</p>
	</form>
	<form action="productById" method="post">
		<h2>Product: Get By ID</h2>
		<p>
			ID:<input type="number" name="id" value="0" required />
		</p>
		<p>
			<input type="submit" value="Get by ID">
		</p>
	</form>

	<form action="productList" method="post">
		<h2>Products: Get All</h2>
		<p>
			<input type="submit" value="Get all">
		</p>
		<c:if test="${!empty entries}">
			<table>
				<tr>
					<th>Edit</th>
					<th>Delete</th>
					<th>ID</th>
					<th>CATEGORY</th>
					<th>BRAND</th>
					<th>CODE</th>
					<th>DESC</th>
					<th>COLOR</th>
					<th>SIZE</th>
					<th>STATUS</th>
					<th>PRICE</th>
				</tr>
				<c:forEach items="${entries}" var="item">
					<tr>
						<td><a href="/productById?id=${item.id}">Edit</a></td>
						<td><a href="/productDeleteById?id=${item.id}">Delete</a></td>
						<td>${item.id}</td>
						<td>${item.category}</td>
						<td>${item.brand}</td>
						<td>${item.code}</td>
						<td>${item.descr}</td>
						<td>${item.color}</td>
						<td>${item.size}</td>
						<td>${item.status}</td>
						<td>${item.price}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>