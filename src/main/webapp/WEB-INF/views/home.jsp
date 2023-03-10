<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home</title>
	<c:import url="./template/common_css.jsp"></c:import>
</head>
<body>
<!-- 서버 내부 주소, 상대경로 -->
<c:import url="./template/header.jsp"></c:import>
		
		<div class="contrainer-fluid my-5">
			<div id="carouselExampleAutoplaying" class="carousel slidex">
				<data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/resources/images/s1.jpg" class="d-block w-40"alt="...">
					</div>
					<div class="carousel-item">
						<img src="/resources/images/s2.jpg" class="d-block w-40"alt="...">
	
					</div>
					<div class="carousel-item">
						<img src="/resources/images/s3.jpg" class="d-block w-40"alt="...">						
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>

<div class="contrainer-fluid my-5" >
</div>
<%-- <c:import url="../template/common_js.jsp"></c:import>
<script src="../common/noticeResult.jsp"></script> --%>
</body>
</html>

