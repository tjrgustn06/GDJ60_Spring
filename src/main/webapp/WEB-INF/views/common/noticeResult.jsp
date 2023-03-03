<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<div class="container-fluid" id="noticeList">
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
					<a href="./detail?num=${dto.num}">${dto.title}</a>
					<c:if test="${i.first}">
					${dto.contents}
					</c:if>
					</td>
				</c:forEach>