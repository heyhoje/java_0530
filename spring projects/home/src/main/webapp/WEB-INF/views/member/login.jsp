<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value='/member/login'/>" method="post">
		<input type="text" name="me_id" placeholder="아이디" requiered><br>
		<input type="password" name="me_pw" placeholder="비번" requiered><br>
		<button>로그인</button>
	</form>
</body>
</html>