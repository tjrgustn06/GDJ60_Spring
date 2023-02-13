<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/table.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/common_css.jsp"></c:import>
<c:import url="../template/header.jsp"></c:import>

	<h1 class="title">Product List</h1>
	
	<table class="tbl2" border="1">
	<thead>
		<tr>
			<th>상품명</th><th>평점</th>
		</tr>	
	</thead>
	
	<tbody>
	
	<c:forEach items="${list}" var="dto"><!-- dto는 page영역에 담김 -->
		<tr>
		<td><a  href = "./detail?productNum=${dto.productNum}">${pageScope.dto.productName}</a></td>
		<td>${dto.productScore}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	
		<a class="btn btn-danger" href="./productAdd">상품등록</a>
	
</body>
</html>