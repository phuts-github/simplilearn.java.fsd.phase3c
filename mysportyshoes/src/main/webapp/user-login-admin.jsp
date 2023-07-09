<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="adminLogin" method="post">
		<h2>Admin Login</h2>
		<p>
			EMAIL:<input type="email" name="email" placeholder="enter email" required />
		</p>
		<p>
			PASSWORD:<input type="password" name="pass" placeholder="enter password"
				required />
		</p>
		<p>
			ADMIN CODE:<input type="text" name="admin" placeholder="enter admin code"
				required />
		</p>
		<p>
			ADMIN PASSWORD:<input type="password" name="adminpass"
				placeholder="admin password" required />
		</p>
		<p>
			<input type="submit" value="Admin Login">
		</p>
	</form>
	<p>
		<a href="user-register-admin.jsp">Register</a>
	</p>	
</body>
</html>