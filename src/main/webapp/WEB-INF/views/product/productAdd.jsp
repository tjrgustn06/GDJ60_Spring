<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-6">
		<form action="./productAdd" method="post">
			상품명
		<input type="text" name ="productName" value="test"> <br>
			상품정보
		<textarea name="productDetail" rows="6" cols="20"></textarea> <br>
			전송버튼
			<button type="submit">등록</button>
			
		</form>
	
	</div>
</body>
</html>