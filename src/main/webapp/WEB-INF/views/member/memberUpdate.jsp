<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/common_css.jsp"></c:import>
<meta charset="UTF-8">
<title>정보수정</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	<h1>UpdatePage</h1>
	
	<form action="./update" method="post">
	  
		<fieldset>
			<legend>회원명</legend>
		<input type="text" name="memberName" value="${dto.memberName}"><br>
	</fieldset>
	
	<fieldset>
			<legend>전화번호</legend>
		<input type="text" name="memberPhone" value="${dto.memberPhone}"><br>
	</fieldset>
	
	<fieldset>
			<legend>EMAIL</legend>
		<input type="text" name="email" value="${dto.email}"> <br>
	</fieldset>






<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>