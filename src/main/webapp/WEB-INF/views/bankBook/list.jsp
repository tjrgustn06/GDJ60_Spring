<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
<c:import url="../template/common_css.jsp"></c:import>
<c:import url="../template/header.jsp"></c:import>
	
	<h1 class="title">BankBook List page</h1>
	<div class="image">
	<img alt="박지현 이미지" src="../resources/images/park.jpg">
	</div>

	<table class="tbl2">
		<thead>
			<tr>
				<th>상품명</th>
				<th>이자율</th>
				<th>판매여부</th>
			</tr>		
		</thead>
		<tbody>
		<c:forEach items="${list}" var="dto"> <!-- var = "이름은 내가 원하는거써도 가능하다" -->
			<tr>
				<td ><a href="./detail?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>		
				<td class="tbl_td" >${dto.bookRate}</td>
				<td class="tbl_td">
				<c:choose>
					<c:when test="${dto.bookSale eq 1}">판매중</c:when>
					<c:otherwise>판매중단</c:otherwise>
				</c:choose>
				
<%-- 			<c:if test="${dto.bookSale eq 1}">판매중</c:if>  
				<c:if test="${dto.bookSale eq 0}">판매중단</c:if> 
--%> 				
				</td>
		</c:forEach>		
			</tr>
		</tbody>	
	</table>
	
	<a href="./add">상품등록</a>
	
	
	
	
</body>

</html>