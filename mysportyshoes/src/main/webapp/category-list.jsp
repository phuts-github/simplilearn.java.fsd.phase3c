<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Listing</title>
</head>
<body>
	<h2>Product Listing</h2>
	<table>
		<tr>
			<th>ID	 </th>
			<th>CODE </th>
			<th>NAME </th>
		</tr>
 	<c:forEach items="${list}" var="item">		
		<tr>
			<td>${item.id}</td>
			<td>${item.code}</td>
			<td>${item.name}</td>
		</tr>	
 	  </c:forEach>			
	</table>
</body>
</html>