<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h2 class="pt-5">게시글 등록</h2>
		<form action="<c:url value='/board/insert'/>" method="get">
			<div class="form-group">
				<input class="form-control" placeholder="제목" name="bo_title">
			</div>
			<div class="form-group">
				<input class="form-control" placeholder="작성자" name="bo_writer" readonly>
			</div>
			<div class="form-group">
				<textarea class=form-control" placeholder="내용" name="bo_contents" style="min-height: 400px"></textarea>
			</div>
			
			<!-- 첨부파일 -->
			<div class="form-group">
				<label>첨부파일</label>
				<input type="file" class="form-control" name="fileList">
				<input type="file" class="form-control" name="fileList">
				<input type="file" class="form-control" name="fileList">
			</div>
			<button class="btn btn-sucess">게시글 등록</button>
			
			
		    
	    </form>
	</div>

			<div class="input-group mb-3">
				<input type="text" name="bo_title"> <br>
				<textarea name="bo_context" placeholder="내용을 입력하세요"></textarea>
		    </div>
</body>
</html>