<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
<c:import url="../template/header.jsp"></c:import>
</head>
<body>
<c:import url="../template/common_css.jsp"></c:import>

<div class="contrainer-fluid my-5">
		<div class="row mb-4">
	<h1 class="title col-md-7 xm-duto text-center border-bottom border-dark pb-4">BankBook List page</h1>
	</div>
	<div>
	<div class="row col-md-7 mx-auto">
	<table class="table table-hover">
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
	
	
	</div>
	</div>
	<div class="row col-md-7 mx-auto">
		<a href="./add" class="btn btn-primary col-2">상품등록</a>
	</div>
	</div>
<c:import url="../template/common_js.jsp"></c:import>
</body>

</html>