<%@page import="com.iu.s1.board.BbsDTO"%>
<%@page import="java.util.List"%>
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
<div class="container-fluid">
	<div class="row">
	<div class="row my-5">
		<h1>${boardName} List</h1>
	</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>NUM</th><th>TITLE</th><th>WRITER</th><th>DATE</th><th>HIT</th>			
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
					<td>${dto.num}</td>
					<td>
					<c:catch>
					<!-- notice에는 depth가 없어서 Exception 발생 -->
					<!--Exception 처리  catch  -->
					<c:forEach begin="1" end="${dto.depth}">-></c:forEach>
					</c:catch>
					<a href="./detail?num=${dto.num}">${dto.title}</a></td>
					<td>
					<c:choose>
						<c:when test="${boardName eq 'notice'}">
							관리자
						</c:when>	
					<c:otherwise>
					${dto.writer}
					</c:otherwise>
					</c:choose>
					</td>
					<td>${dto.regDate}</td>
					<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>
			<!-- pageing -->				
				<div class="row">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
						<li class="page-item">
							<a class="page-link" href="#"aria-label="Previous" data-board-page="1"> 
								<span aria-hidden="true">&laquo;</span></a> 					
						
							<li class="page-item ${pager.before ? 'disabled':''}">
							<a class="page-link" href="#"aria-label="Previous" data-board-page="${pager.startNum-1}" > 
								<span aria-hidden="true">&lsaquo;</span></a> 
							
							<!-- for(int i = 1; i<=??; i++){i} step=1  1씩 증가 default 는 1이라서 1일때는 setp은 생략가능 -->
							<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1" var="i"></li>

							<li class="page-item"><a class="page-link"href="#" data-board-page="${i}">${i}</a></li>
							</c:forEach>
							
							<li class="page-item ${pager.after eq false ? 'disabled':''}">
							
							<a class="page-link" href="#" aria-label="Next" data-board-page="${pager.lastNum+1}"> 
							<span aria-hidden="true">&rsaquo;</span>
							</a>
							</li>
							<li class="page-item">
							
							<a class="page-link" href="#" aria-label="Next" data-board-page="${pager.totalPage}"> 
							<span aria-hidden="true">&raquo;</span>
							</a>
							</li>							
						</ul>
					</nav>
				</div>
					
		<!-- 검색창 -->
		<div class="row">
			<form class="row col-md-7 mx-auto" action="./list" method="get" id="searchForm">
				<input type="hidden" name="page" value="1" id="page">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Kind</label> 
					<select class="form-select" name="kind" id="kind" aria-label="Default select example">
						<option value="title" ${pager.kind eq 'title'?'selected':''}>상품명</option>
						<option value="contents" ${pager.kind eq 'writer'?'selected':''}>상품내용</option> 
						<option value="writer"${pager.kind eq 'writer'?'selected':''}>작성자</option> 
						</select>
				</div>
				<div class="col-auto">
					<label for="search" class="visually-hidden">Search</label>
					<input type="text" class="form-control" value="${pager.search}" id="search" name="search" placeholder="검색어를 입력하세요">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>
		</div>
	
		<c:if test="${not empty member}">
				<c:if test="${boardName eq 'notice' and member.roleDTO.roleName eq 'ADMIN'}">
					<div class="row">
						<a href="./add" class="btn btn-primary">글작성</a>
					</div>
				</c:if>
				
				<c:if test="${boardName ne 'notice'}">
					<div class="row">
						<a href="./add" class="btn btn-primary">글작성</a>
					</div>
				</c:if>
			</c:if>
</div>

<c:import url="../template/common_js.jsp"></c:import>
<script src="../resources/js/pageing.js"></script>
<script>
	setData('${pager.search}')
</script>
</body>
</html>