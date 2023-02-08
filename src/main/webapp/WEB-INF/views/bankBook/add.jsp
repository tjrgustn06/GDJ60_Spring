<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품등록 Page</h1>
	
	<form action="./add", method="post">
	
	상품명:<input type="text" name="bookName" placeholder="제품명 입력"><br>
	
	이자율:<input type="text" name="bookRate" value="1.5"><br>
	
	상품정보:<textarea name="bookDetail" rows="10" cols="30"></textarea> <br>
	
	판매여부:<input type="text" name="bookSale"><br>
	
	전송 버튼:<button type="submit">등록</button>
	
	
	</form>
</body>
</html>