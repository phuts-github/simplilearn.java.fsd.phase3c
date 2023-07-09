<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="userLogin" method="post">
		<h2>User Login</h2>
		<p>
			EMAIL:<input type="email" name="email" placeholder="enter email"
				required />
		</p>
		<p>
			PASSWORD:<input type="password" name="pass" placeholder="enter password"
				required />
		</p>
		<p>
			<input type="submit" value="Login">
		</p>
	</form>
	<p>
		<a href="user-register.jsp">Register</a>
	</p>
</body>
</html>