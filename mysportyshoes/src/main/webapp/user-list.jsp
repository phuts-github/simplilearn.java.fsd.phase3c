<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Listing</title>
</head>
<body>
	<h2>User Listing</h2>
	<table>
		<tr>
			<th>ID	  </th>
			<th>EMAIL  </th>
			<th>NAME  </th>
			<th>PASS </th>
			<th>ADMIN  </th>
			<th>ADMINPASS  </th>
			<th>ADDRESS </th>
		</tr>
 	<c:forEach items="${list}" var="item">			
		<tr>
			<td>${item.id}</td>
			<td>${item.email}</td>
			<td>${item.name}</td>
			<td>${item.name}</td>
			<td>${item.admin}</td>
			<td>${item.adminPass}</td>
			<td>${item.address}</td>
		</tr>		
	</c:forEach>
	</table>
</body>
</html>