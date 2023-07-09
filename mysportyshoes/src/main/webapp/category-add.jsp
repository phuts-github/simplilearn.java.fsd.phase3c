<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu-admin.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="categoryAddUpdate" method="post">
		<h2>Category Add / Update</h2>
		<c:if test="${!empty entry}">
			<c:forEach items="${entry}" var="item">
				<p>
					ID:<input type="number" name="id" value="${item.id}"
						readonly='readonly' />
				</p>
				<p>
					CODE:<input type="text" name="category" value="${item.category}"
						required />
				</p>
				<p>
					NAME:<input type="text" name="name" value="${item.name}" required />
				</p>
			</c:forEach>
		</c:if>
		<c:if test="${empty entry}">
			<p>
				ID:<input type="number" name="id" value="0" readonly='readonly' />
			</p>
			<p>
				CODE:<input type="text" name="category" placeholder="enter category"
					required />
			</p>
			<p>
				NAME:<input type="text" name="name" placeholder="enter name"
					required />
			</p>
		</c:if>
		<p>
			<input type="submit" value="Add / Update"> <input
				type="reset" name="Clear">
		</p>
	</form>

	<form action="categoryById" method="post">
		<h2>Category: Get By ID</h2>
		<p>
			ID:<input type="number" name="id" value="0" required />
		</p>
		<p>
			<input type="submit" value="Get by ID">
		</p>
	</form>


	<form action="categoryList" method="post">
		<h2>Category: Get all</h2>
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
					<th>NAME</th>
				</tr>
				<c:forEach items="${entries}" var="item">
					<tr>
						<td><a href="/categoryById?id=${item.id}">Edit</a></td>
						<td><a href="/categoryDeleteById?id=${item.id}">Delete</a></td>
						<td>${item.id}</td>
						<td>${item.category}</td>
						<td>${item.name}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>