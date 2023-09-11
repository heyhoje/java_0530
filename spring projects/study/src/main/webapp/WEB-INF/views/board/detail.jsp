<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<h3>제목 : ${board.bo_title }</h3>
	<h3>작성자 : ${board.bo_me_id }</h3>
	<h3>조회수 : ${board.bo_views }</h3>
	<hr>
	<div>${board.bo_contents }</div>
	<h3>첨부파일</h3>
	<c:forEach items="${fileList}" var="file">
		<a  href="<c:url 
			value='/download${file.fi_name}'/>" 
			download="${file.fi_ori_name }"
		>${file.fi_ori_name }</a> <br>
	</c:forEach>
	<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>">수정</a>
	<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>">삭제</a>
	<hr>
	<h2>댓글</h2>
	<textarea rows="" cols="" placeholder="댓글 등록" id="inputComment"></textarea>
	<button id=btnCommentInsert>등록</button>
	
	<script type="text/javascript" src="//cod.jquery.com/jquiery-30501.js"></script>
	<script type="text/javascript">
		$('btnCommentInsert').click(function(){
			let co_contents =$('inputComment').val();
			let co_me_id = '${user.me_id}'; // 세션에 있는 정보
			let co_bo_num = '${board.bo_num}';
			
			if(co_me_id == ''){
				if(confirm('로그인이 필요한 서비스입니다. 로그인 하시겠습니까?')){
					location.href = '<c:url value = "/member/login"/>'
				}
				return;
			}
			if(co_contents.trim() == ''){
				alert('댓글 내용을 입력하세요.');
				$('inputComment').focus();
				return;
			}
			let commetn = {
					co_contents : co_contents,
					co_me_id : co_me_id,
					co_bo_num : co_bo_num 
			}
			console.log(comment)
			$.ajax({
				async : false, // 동기화
				method : "post",
				url : '<c:url value="/comment/insert"/>',
				data : JSON.stringify(comment),
				contentType : 'application/json; charset=utf-8'
				dataType : 'json',
				success : function(data){
					//console.log(data);
					if(data.res){
						alert('댓글 등록 성공');
						$('#inputComment').val('');
					}else{
						alert('댓글 등록 실패');
					}
				}
			})
		});
	</script>
</body>
</html>