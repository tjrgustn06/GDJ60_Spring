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
			<h1>${boardName} Update Page</h1>
		</div>

		<div class="row">
			<form action="./update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num}">
				<div class="mb-2 contrainer-fluid my-5">
				
				 <fieldset disabled>
					<legend>작성자</legend>
					<input type="txet" class="col-2" name="writer" id="writer" readonly value="${dto.writer}">
				</div>
				 </fieldset>

				<div class="mb-3 contrainer-fluid">
					<legend>제목</legend>
					<input type="text" class="col-1" name="title" value="${dto.title}" id="title" placeholder="제목 입력"><br>
				</div>

				<div class="mb-3 contrainer-fluid">
					<legend>내용</legend>
					<textarea class="form-control col-md-7" name="contents" value="${dto.contents}" id="contents" placeholder="내용 입력" rows="7"></textarea> <br>
				</div>

				</div>
				
				<div id="fileList">
				<button type="button" id="fileAdd" class="btn btn-primary">ADD</button>
					
					<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
 					<div class="input-group mb-3">
					<div class="input-group mb-3">
 					<div class="input-group-text">
  			  			<input class="form-check-input mt-0 deleteCheck" type="checkbox" name="fileNums" value="${fileDTO.fileNum}" aria-label="Checkbox for following text input">
  				</div>
  						<input type="text" disabled value="${fileDTO.oriName}"  class="form-control" aria-label="Text input with checkbox">
				</div>				
					</c:forEach>
				</div>  
					
			</div>

				<button type="submit" class="btn btn-outline-primary col-1 my-3">글쓰기</button>
		</div>

		</form>
	</div>
	</div>
	<script src="../resources/js/fileManger.js"></script>
	<c:import url="../template/common_js.jsp"></c:import>
	<script>
	$("#contents").summernote();
		setMax(5);
		setCount('${dto.boardFileDTOs.size()}');
		//setparam('addFiles');
	</script>
</body>
</html>