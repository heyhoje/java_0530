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
	<textarea rows="" cols="" placeholder="댓글" id="inputComment"></textarea>
	<button id=btnCommentInsert>등록</button>
	
	<hr>
	<div class="box-comment">
		<ul class="comment-list">
			<li class="comment-item">
				<span class="comment-contents">댓글1</span>
				<span class="comment-contents">[작성자]</span>
				<button>수정</button>
				<button>삭제</button>
			</li>
		</ul>
		<div class="pagination">
			<a href="#">이전</a>
			<a href="#">1</a>
			<a href="#">다음</a>
		</div>
	</div>		
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('#btnCommentInsert').click(function(){
			let co_contents =$('#inputComment').val();
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
			let comment = {
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
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){
					//console.log(data);
					if(data.res){
						alert('댓글 등록 성공');
						$('#inputComment').val('');
						cri.page = 1;
						getCommentList(cri);
					}else{
						alert('댓글 등록 실패');
					}
				}
			})
		});
		// 현재 페이지 변수 : 전역변수로
		let cri = {
				page : 2,
				// perPageNum : 3,
		}
		
		function getCommentList(cri){
			$.ajax({
				async : false, // 동기화
				method : "post",
				url : '<c:url value="/comment/list/"/>' + '${board.bo_num}',
				data : JSON.stringify(cri),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){
					// console.log(data);
					let str = '';
					for(comment of data.list){
						str += `
						<li class="comment-item">
							<span class="comment-contents">\${comment.co_contents}</span>
							<span class="comment-writer">[\${comment.co_me_id}]</span>
							<button>수정</button>
							<button>삭제</button>
						</li>`		
					}
					$('.comment-list').html(str);
					//console.log(data);
					let pm = data.pm;
					str = '';
					// 이전 버튼을 배치
					if(pm.prev){
						str += `<a href="javascript:void(0);" onclick="changePage(\${pm.startPage-1})">이전</a>`;
					}
					// 숫자 버튼을 배치
					for(i = pm.startPage; i <= pm.endPage; i++){
						str += `<a href="javascript:void(0);" onclick="changePage(\${i})">\${i}</a>`
					}
					// 다음 버튼을 배치
					if(pm.next){
						str += `<a href="javascript:void(0);" onclick="changePage(\${pm.startPage+1})">다음</a>`;
					}
					$('.pagination').html(str);			
				}
			})
		}
		function changePage(page){
			cri.page = page;
			getCommentList(cri);
		}
	</script>
</body>
</html>