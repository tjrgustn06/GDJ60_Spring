<%@page import="com.iu.s1.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail Page</h1>
	<c:if test="${not empty detail}">	
	<h3>Number : ${detail.bookNumber}</h3>
	<h3>Title : ${detail.bookName}</h3>
	<h3>Detail : ${detail.bookDetail}</h3>
	<h3>Rate : ${detail.bookRate}</h3>
	<h3>Sale : ${detail.bookSale}</h3>
	<a href="./delete?bookNumber=${detail.bookNumber}">상품삭제</a>
	
	</c:if>
	<c:if test="${empty detail}">
		<h3>존재하지 않는 상품입니다.</h3>
	</c:if>
	
	<a href="./list">목록으로</a>
</body>
</html>