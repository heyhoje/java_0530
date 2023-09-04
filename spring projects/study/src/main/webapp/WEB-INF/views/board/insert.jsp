<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value='/board/insert'/>" method="post">
			<input type="text" name="bo_title" placeholde="제목"> <br>
			<textarea name="bo_contents" rows="20" cols="30" placeholder="내용"></textarea> <br>
		<button>등록하기</button>
	</form>    
</body>
</html>