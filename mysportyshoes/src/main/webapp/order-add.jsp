<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<%@include file="WEB-INF/jsp/include/header-menu-admin.html"%>
<%@include file="WEB-INF/jsp/include/shop-name.html"%>
<body>
${message}
<form action="orderAddUpdate" method="post">
<h2>Add / Update Product</h2>
<br>ID:<input type="number" name="id" value="0" required disabled/>
<br>TYPE:<input type="text" name="type" placeholder="product type" required/>
<br>BRAND:<input type="text" name="brand" placeholder="product brand" required/>
<br>CODE:<input type="text" name="code" placeholder="product code" required/>
<br>DESC:<input type="text" name="descr" placeholder="product desc" required/>
<br>COLOR:<input type="number" name="color" placeholder="product color" required/>
<br>SIZE:<input type="number" name="size" placeholder="product size" required/>
<br>STATUS:<input type="text" name="status" placeholder="product status" required/>
<br>PRICE:<input type="number" name="price" placeholder="product price" required/>
<br><br><input type="submit" name="submit" disabled="disabled">
</form>
</body>
</html>