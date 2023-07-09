<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.html"%>
	<h2>User Maintenance</h2>
	<br>${message}<br>
	<h2>Update User:</h2>
	<form action="updateUser">
		<%
			Integer uId = (Integer) session.getAttribute("uId");
			String uAge = (String) session.getAttribute("uAge");
			String uName = (String) session.getAttribute("uName");
			String uPass = (String) session.getAttribute("uPass");

			out.print("User Id: <input type='text' name='uId' value=" + uId + " readonly='readonly'>");
			out.print("<br>");
			out.print("User Name: <input type='text' name='uAge' value=" + uName + ">");
			out.print("<br>");
			out.print("User Age: <input type='text' name='uName' value=" + uAge + ">");
			out.print("<br>");
			out.print("User Password: <input type='password' name='uPass' value=" + uPass + ">");
			out.print("<br>");
			out.print("<br>");
		%>
		<input type="submit" value="Update user"><br>

	</form>
</body>
</html>