<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html lang="en">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<%@include file="header.html"%>
<body>
	<form action="addFeedback" method="post">
		<div>Add New User Feedback Entry :</div>
		<br> Id:<br> <input type="number" name="id" value="0" readonly='readonly' /><br>
		Category:<br> <input type="text" name="name" required /><br>
		Feedback:<br> <input type="text" name="feedback" required /><br>
		<br> <input type="submit" /><br>
	</form>
	<br>
	<br>
	<form action="getFeedback" method="post" >
		Enter The Id To Get Specific User Feedback:<br> <input
			type="number" name="id" value="0" ><br> <br> <input
			type="submit"><br>
	</form>
	<br>
	<br>
	<form action="getAllFeedback" method="post">
		Get All User Feedback:<br> <br> <input type="submit"><br>
	</form>
	<br>
	${message}
	
	<c:if test="${!empty entries}">
		<h3>Feedback List</h3>
		<table>
			<tr>
				<th>ID</th>
				<th>Category</th>
				<th>Feedback</th>
			</tr>
			<c:forEach items="${entries}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.feedback}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>

</html>