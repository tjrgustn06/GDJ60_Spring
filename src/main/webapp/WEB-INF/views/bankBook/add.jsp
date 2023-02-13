<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">

		<div class="row">
			<h1>상품등록 Page</h1>
		</div>

		<div class="row">
			<form action="./add" method="post">
				<div class="mb-2 contrainer-fluid my-5">

					<legend>상품명</legend>
					<input type="txet" class="col-2" name="bookName"
						placeholder="제품명 입력">
				</div>

				<div class="mb-3 contrainer-fluid">
					<legend>이자율</legend>
					<input type="text" class="col-1" name="bookRate"><br>
				</div>

				<div class="mb-3 contrainer-fluid">
					<legend>상세정보</legend>
					<textarea class="form-control col-md-7" name="bookDetail" rows="" cols=""></textarea> <br>
				</div>

				<input type="radio" class="btn-check" name="options-outlined"
					id="success-outlined" autocomplete="off" checked> <label
					class="btn btn-outline-success" for="success-outlined">판매중</label>

				<input type="radio" class="btn-check" name="options-outlined"
					id="danger-outlined" autocomplete="off"> <label
					class="btn btn-outline-danger" for="danger-outlined">판매중지</label><br>

				<button type="button" class="btn btn-outline-primary col-1 my-3">등록</button>
		</div>

		</form>
	</div>
	</div>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>