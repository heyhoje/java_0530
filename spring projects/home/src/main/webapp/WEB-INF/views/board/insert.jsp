<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<!-- 섬머노트 - 겟스타트 - 인스톨 - 부트4 -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>게시글 등록</h1>
	<!-- 게시글을 서버로 전송 -->
	<form action="<c:url value='/board/insert'/>" method="post">
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="bo_title">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<!-- 로그인 필요. readonly -->
			<input type="text" class="form-control" name="bo_me_id" value="${user.me_id }" readonly>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea name="bo_contents" id ="summernote"></textarea>
		</div>
		<button class="btn btn-outline-success col-12">등록하기</button>
	</form>
	
	<!-- 게시글 양식 폼 / textarea에 아이디 추가필요 -->
	<div id="summernote"></div>
    <script>
      $('#summernote').summernote({
        placeholder: '내용을 입력하세요',
        tabsize: 2,
        height: 400
      });
    </script>
    
</body>
</html>
