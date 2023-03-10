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
			<h1>${boardName} Add Page</h1>
		</div>

		<div class="row">
			<form action="./reply" method="post">
				<div class="mb-2 contrainer-fluid my-5">
				<input type="hidden" name="num" value="${boardDTO.num}">

					<legend>작성자</legend>
					<input type="txet" class="col-2" name="writer" id="writer">
				</div>

				<div class="mb-3 contrainer-fluid">
					<legend>제목</legend>
					<input type="text" class="col-1" name="title" id="title"><br>
				</div>

				<div class="mb-3 contrainer-fluid">
					<legend>상세정보</legend>
					<textarea class="form-control col-md-7" name="contents" id="contents"></textarea> <br>
				</div>

					 <div id="fileList"> 
					<div class="mb-3">
					<label for="files" class="form-label">Image</label> 
					<input type="file" class="form-control" id="files" name="pic">
				</div> 
			</div>

				<button type="submit" class="btn btn-outline-primary col-1 my-3">글쓰기</button>
		</div>

		</form>
	</div>
	</div>
	<script src="../resources/js/fileManger.js"></script>
	<script>
		setMax(5);
		setparam('files');
	</script>
	<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>