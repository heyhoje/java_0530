<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="<c:url value='/board/update'/>" method="post">
		<input type="hidden" name="bo_num" value="${board.bo_num}">
		<input type="text" name="bo_title" placeholde="제목" value="${board.bo_title}"> <br>
		<textarea name="bo_contents" rows="20" cols="30" placeholder="내용" >${board.bo_contents}</textarea> <br>
		<button>수정하기</button>
	</form>    
</body>
</html>