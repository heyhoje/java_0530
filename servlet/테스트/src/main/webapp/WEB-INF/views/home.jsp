<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/home입니다.</h1>
	<h2><%=request.getAttribute("abc") %></h2>
	<form action="/test/home" method="post">
		<input type="text" name="id">
		<button>전송</button>
	</form>
</body>
</html>