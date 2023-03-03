<%@page import="com.iu.s1.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/header.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/common_css.jsp"></c:import>
	<h1>BankBook Detail Page</h1>
	<c:if test="${not empty detail}">
	<div>
  <form>
  <fieldset disabled>
    <div class="mb-3">
      <label for="${detail.bookNumber}" class="form-label">제품번호</label>     
      <input type="text" id="${detail.bookNumber}" class="form-control" placeholder="${detail.bookNumber}">
    </div>
    <div class="mb-3">
      <label for="${detail.bookName}" class="form-label">제품명</label>
      <input type="text" id="${detail.bookName}" class="form-control" placeholder="${detail.bookName}">
    </div>
    <div class="mb-3">
      <label for="${detail.bookRate}" class="form-label">이자율</label>
      <input type="text" id="${detail.bookRate}" class="form-control" placeholder="${detail.bookRate}">
    </div>
    <div class="mb-3">
      <label for="${detail.bookDetail}" class="form-label">상세정보</label>
      <textarea type="text" id="${detail.bookDetail}" class="form-control" placeholder="${detail.bookDetail}"></textarea>
    </div>
    <div class="mb-3">
      <label for="${detail.bookSale}" class="form-label">판매여부</label>
      <input type="text" id="${detail.bookSale}" class="form-control" placeholder="${detail.bookSale}">
    </div>
    <c:if test="${not empty detail.bankBookImgDTO}">
    <img src="../resources/upload/bankBook/${detail.bankBookImgDTO.fileName}">
   	 </c:if>
    <a class="btn btn-danger col-1" href="./delete?bookNumber=${detail.bookNumber}">상품삭제</a>
    
    	</c:if>
	<c:if test="${empty detail}">
		<h3>존재하지 않는 상품입니다.</h3>
		</c:if>
	<a class="btn btn-warning col-1" href="./update?bookNumber=${detail.bookNumber}">상품수정</a>
	<a class="btn btn-info col-1" href="./list ">목록으로</a>
    <div class="my-5">
      
    </div>

   	 </div>

      <div class="mb-3">
        <textarea class="form-control" id="replayContents" rows="3"></textarea>
        <button class="btn btn-primary col-1" id="replayAdd" data-book-bookNum="${dto.bookNumber}">등록</button>
      </div>
  </form>
	

	
<c:import url="../template/common_js.jsp"></c:import>
<script src="/resources/js/bankBookReply.js"></script>
</body>
</html>