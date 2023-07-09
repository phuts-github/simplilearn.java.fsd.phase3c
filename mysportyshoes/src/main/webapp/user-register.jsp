<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
	${message}
	<form action="userRegister" method="post">
		<h2>User Registration</h2>
		<p>
			ID:<input type="number" name="id" value="0" readonly='readonly'/>
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
			ADDRESS:<input type="text" name="address" placeholder="enter address"
				required />
		</p>
		<p>
			<input type="submit" value="Register">
		</p>
	</form>
</body>
</html>