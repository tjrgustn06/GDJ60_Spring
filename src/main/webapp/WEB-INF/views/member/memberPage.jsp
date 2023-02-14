<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/common_css.jsp"></c:import>
<title>Insert title here</title>
</head>
<c:import url="./template/header.jsp"></c:import>
<body>
	<h1>Member Page</h1>
	
	<div>
		<h3>NAME:"${membername}"</h3>
		<h3>PHONE:"${memberphone}"</h3>
		<h3>EMAIL:"${email}"</h3>
		<a href:"./memberUpdate" class="btn btn-info">정보수정</a>
	</div>

	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>