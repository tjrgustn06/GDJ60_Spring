<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
 <table>
 <c:forEach items="${list}" var="dto" >
 	<tr>
 	<td id="contents${dto.num}">
		<textarea rows="" cols="" readonly>${dto.contents}</textarea>
		<button class="btn btn-primary upd" data-comment-num="${dto.num}">UPDATE</button>
	</td>
 	<td>${dto.writer}</td>
 	<td>${dto.regDate}</td>
 		<td>
 	<c:if test="${member.id eq dto.writer}">
 	<button class="btn btn-primary upd" data-comment-num="${dto.num}">UPDATE</button>
	</c:if>
 	</td>
 	
 	<td>
 	<c:if test="${member.id eq dto.writer}">
 	<button class="btn btn-danger del" data-comment-num="${dto.num}">DELETE</button>
	</c:if>
 	</td>
 	</tr>
 	
 </c:forEach>
 </table>
 
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