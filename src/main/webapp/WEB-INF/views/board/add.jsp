<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">

		<div class="row">
			<h1>${boardName} Add Page</h1>
		</div>

		<div class="row">
			<form action="./add" method="post" enctype="multipart/form-data">
				<div class="mb-2 contrainer-fluid my-5">
				
				 <fieldset disabled>
					<legend>작성자</legend>
					<input type="txet" class="col-2" name="writer" id="writer" readonly value="${member.id}">
				</div>
				 </fieldset>

				<div class="mb-3 contrainer-fluid">
					<legend>제목</legend>
					<input type="text" class="col-1" name="title" id="title" placeholder="제목 입력"><br>
				</div>

				<div class="mb-3 contrainer-fluid">
					<legend>내용</legend>
					<textarea class="form-control col-md-7" name="contents" id="contents" placeholder="내용 입력" rows="7"></textarea> <br>
				</div>

				<div id="fileList">
				<div class="mb-3">
					<label for="files" class="form-label">Image</label>
					<input type="file" class="form-control" id="files" name="pic">
					<button type="button" class="btn btn-outline-danger">X</button>
				</div> 
				<button type="button" id="fileAdd" class="btn btn-primary">ADD</button>
			</div>

				<button type="submit" class="btn btn-outline-primary col-1 my-3">글쓰기</button>
		</div>

		</form>
	</div>
	</div>
<script src="../resources/js/fileManger.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
<script>
	setMax(5);
	setparam('addFiles');
	$("#contents").summernote();
</script>
</body>
</html>