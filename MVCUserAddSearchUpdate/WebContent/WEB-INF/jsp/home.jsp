<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Maintenance</title>
</head>
<body>
	<%@include file="header.html"%>
	${message}<br>
	<h2>Add User:</h2>
	<form action="addUser">
		User Name: <input type="text" name="uName"><br> User age:
		<input type="text" name="uAge"><br> Password:<input
			type="password" name="uPass"><br> <br> <input
			type="submit" value="Add user"><br>
	</form>
	<br>
	<h2>Get User with ID:</h2>
	<form action="readUser">
		User ID: <input type="text" name="uId"><br> <br> <input
			type="submit" value="Get user"><br>
	</form>
</body>
</html>