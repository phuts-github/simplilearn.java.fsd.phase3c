<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu-admin.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="userAddUpdate" method="post">
		<h2>User: Add / Update</h2>
		<c:if test="${!empty entry}">
			<c:forEach items="${entry}" var="item">
				<p>
					ID:<input type="number" name="id" value="${item.id}"
						readonly='readonly' />
				</p>
				<p>
					EMAIL:<input type="email" name="email" value="${item.email}"
						readonly='readonly' />
				</p>
				<p>
					NAME:<input type="text" name="name" value="${item.name}" required />
				</p>
				<p>
					PASSWORD:<input type="password" name="pass" value="${item.pass}"
						readonly='readonly' />
				</p>
				<p>
					ADMIN:<input type="text" name="admin" value="${item.admin}"
						value="${item.admin}" readonly='readonly' />
				</p>
				<p>
					ADMIN PASSWORD:<input type="password" name="adminPass"
						value="${item.adminPass}" readonly='readonly' />
				</p>
				<p>
					ADDRESS:<input type="text" name="address" value="${item.address}"
						required />
				</p>
			</c:forEach>
		</c:if>
		<c:if test="${empty entry}">
			<p>
				ID:<input type="number" name="id" value="0" readonly='readonly' />
			</p>
			<p>
				EMAIL:<input type="email" name="email" placeholder="enter email" required />
			</p>
			<p>
				NAME:<input type="text" name="name" placeholder="enter name" required />
			</p>
			<p>
				PASSWORD:<input type="password" name="pass" placeholder="enter password"
					required />
			</p>
			<p>
				ADMIN:<input type="text" name="admin" placeholder="enter admin code"
					required />
			</p>
			<p>
				ADMIN PASSWORD:<input type="password" name="adminPass"
					placeholder="enter admin password" required />
			</p>
			<p>
				ADDRESS:<input type="text" name="address" placeholder="enter address"
					required />
			</p>
		</c:if>
		<p>
			<input type="submit" value="Add / Update">
		</p>
	</form>
	<form action="userById" method="post">
		<h2>User: Get By ID</h2>
		<p>
			ID:<input type="number" name="id" value="0" required />
			<input type="submit" value="Get by ID">
		</p>
	</form>
	<form action="userByEmail" method="post">
		<h2>User: Get By Email</h2>
		<p>
			EMAIL:<input type="email" name="email" placeholder="enter email address"
					required />
			<input type="submit" value="Get by Email">
		</p>
	</form>

	<form action="userList" method="post">
		<h2>User: Get All</h2>
		<p>
			<input type="submit" value="Get all">
		</p>
		<c:if test="${!empty entries}">
			<table>
				<tr>
					<th>Edit</th>
					<th>Delete</th>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>ADDRESS</th>
				</tr>
				<c:forEach items="${entries}" var="item">
					<tr>
						<td><a href="/userById?id=${item.id}">Edit</a></td>
						<td><a href="/userDeleteById?id=${item.id}">Delete</a></td>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.email}</td>
						<td>${item.address}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form>
</body>
</html>