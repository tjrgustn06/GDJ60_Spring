<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world! 
</h1>

	<a href="./product/list?num=1&num=2&num=3" class="menu">Product List</a>
	<a href="/product/list" class="menu">Product List</a>
	<a href ="/bankBook/list" class="menu">BankBook List</a>
	<a href ="./bankBook/list" class="menu">BankBook List</a><br>
	
	<img alt="박지현이미지" src="/resources/images/park.jpg"><br>
	<img alt="박지현이미지2" src="./resources/images/par.jpg">
	


<P>  The time on the server is ${serverTime}. </P>


</body>
</html>
