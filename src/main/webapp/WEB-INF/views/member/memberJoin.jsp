<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="../template/common_css.jsp"></c:import>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fulid my-5">
<div class="row mb-4">
	<h1 class="col-md-7 mx-auto text-center border-bottom border-dark pb-4">MemberJoin Page</h1>
	</div>	
	
	<div class="row justify-content-center">
		<form class="col-4" action="./join" method="post">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<input type="text" name="id" class="form-control" id="id" placeholder="ID 입력">
			</div>
			
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<input type="password" name="pw" class="form-control" id="pw" placeholder="PW 입력">
			</div>
			
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<input type="text" name="name" class="form-control" id="name" placeholder="NAME 입력">
			</div>
			
			<div class="mb-3">
				<label for="address" class="form-label">ADDRESS</label>
				<input type="text" name="address" class="form-control" id="address" placeholder="ADDRESS 입력">
			</div>
			
			<div class="mb-3">
				<label for="phone" class="form-label">PHONE</label>
				<input type="text" name="phone" class="form-control" id="phone" placeholder="PHONE 입력">
			</div>
			
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<input type="text" name="email" class="form-control" id="email" placeholder="EMAIL 입력">
			</div>
			
			<div class="mb-3">
				<button class="btn btn-primary" type="submit">등록</button>
			</div>
		</form>
	  </div>
	  </div>
	<c:import url="../template/common_js.jsp"></c:import>	
</body>
</html>