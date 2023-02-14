<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar bg-dark navbar navbar-expand-lg bg-body-tertiary " data-bs-theme="dark">
  <div class="container-fluid">
  	<a href="/" class="navbar-brand"><img src="/resources/images/logo.png"></a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active" href="#">공지사항</a></li>
				<li class="nav-item"><a class="nav-link active" href="/product/list">제품목록</a></li>
				<li class="nav-item"><a class="nav-link active" href="/bankBook/list">저축상품</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">기타메뉴</a></li>
	</ul>
	
	<ul class="navbar-nav">
		<c:if test="${empty member}">
		<li class="nav-item"><a class="nav-link" href="/member/memberlogin">LOGIN</a></li>
		<li class="nav-item"><a class="nav-link" href="/member/memberjoin">JOIN</a></li>
		<li class="nav-item"><a class="nav-link" href="#">KO</a></li>
		<li class="nav-item"><a class="nav-link" href="#">EN</a></li>
		<li class="nav-item"><a class="nav-link" href="#">JP</a></li>
		<li class="nav-item"><a class="nav-link" href="#">CN</a></li>
		</c:if>
		<c:if test="${not empty mwmber}">
		<li class="nav-item"><a class="nav-link" href="/member/membermypage">MYPAGE</a></li>
		<li class="nav-item"><a class="nav-link" href="/member/memberlogout">LOGOUT</a></li>
		<li class="nav-item"><a class="nav-link" href="#">KO</a></li>
		<li class="nav-item"><a class="nav-link" href="#">EN</a></li>
		<li class="nav-item"><a class="nav-link" href="#">JP</a></li>
		<li class="nav-item"><a class="nav-link" href="#">CN</a></li>
		</c:if>
	</ul>
	
	  </div>
</nav>

