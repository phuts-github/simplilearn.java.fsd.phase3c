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
			<th>ID	  </th>
			<th>TYPE  </th>
			<th>BRAND </th>
			<th>CODE  </th>
			<th>DESC  </th>
			<th>COLOR </th>
			<th>SIZE  </th>
			<th>STATUS</th>
			<th>PRICE </th>		
		</tr>
 	<c:forEach items="${list}" var="item">			
		<tr>
			<td>${item.id}</td>
			<td>${item.type}</td>
			<td>${item.brand}</td>
			<td>${item.code}</td>
			<td>${item.descr}</td>
			<td>${item.color}</td>
			<td>${item.size}</td>
			<td>${item.status}</td>
			<td>${item.price}</td>	
		</tr>	
	</c:forEach>	
	</table>
</body>
</html>