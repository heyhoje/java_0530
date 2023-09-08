<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<h1>게시글 상세</h1>
	<div class="form-group">
		<label>제목</label>
		<div class="form-control">${board.bo_title}</div>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<div class="form-control">${board.bo_me_id}</div>
	</div>
	<div class="form-group">
		<label>조회수</label>
		<div class="form-control">${board.bo_views}</div>
	</div>
	<div class="form-group">
		<label>등록일</label>
		<div class="form-control">${board.bo_reg_date_str}</div>
	</div>
	<c:if test="${board.bo_up_date != null }">
		<div class="form-group">
			<label>수정일</label>
			<div class="form-control">${board.bo_up_date_str}</div>
		</div>
	</c:if>
	
	<div class="form-group clearfix">
		<!-- 안에 c:if 태그를 넣은게 유튜브 좋아요처럼 색저장 처리? 를 하고 싶은거라는데 그게 어떻게 작동하는지는 잘 설명 안됨. 알아서 이해하라는거지 뭐 sb -->
		<button class="btn btn-like btn<c:if test="${like.li_state != 1}">-outline</c:if>-primary btn-up col-6 float-left">
			추천(<span class="text-up">${board.bo_up}</span>)</button>
		<button class="btn btn-like btn<c:if test="${like.li_state != -1}">-outline</c:if>-danger btn-down col-6 float-right">
			비추천(<span class="text-down">${board.bo_down}</span>)</button>
	</div>
	
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="min-height: 400px">${board.bo_contents}</div>
	</div>
	
	<div class="form-group">
		<c:choose>
			<c:when test="${board.fileVoList.size() != 0}">
				<label>첨부파일</label>
				<c:forEach items="${board.fileVoList}" var="file">
					<a class="form-control" href="<c:url value='/download${file.fi_name}'/>" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<label>첨부파일 없음</label>
			</c:otherwise>
		</c:choose>
	</div>
	<a href="<c:url value='/board/list${cri.currentUrl}'/>" class="btn btn-outline-primary">목록으로</a>
	<a href="<c:url value='/board/insert?bo_ori_num=${board.bo_num}'/>" class="btn btn-outline-success">답글</a>
	<c:if test="${user.me_id == board.bo_me_id}">
		<a href="<c:url value='/board/?bo_num=${board.bo_num}'/>" class="btn btn-outline-warning">수정</a>
		<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>" class="btn btn-outline-danger">삭제</a>
	</c:if>
	
	<div class="comment-container mt-3">
		<!-- 댓글 입력창 -->
		<div class="input-group mb-3">
			<textarea class="form-control" placeholder="댓글" name="co_coments"></textarea>
		    <div class="input-group-append">
		      <button class="btn btn-outline-success btn-comment-insert">등록</button>
		    </div>
		</div>
		<!-- 댓글 목록창 -->
			
		<!-- 댓글 페이지네이션 -->
	</div>
	
	<!-- 추천 기능 자바스크립트 -->
	<script type="text/javascript">
		// 추천 + 비추천
		$('.btn-like').click(function(){
			if('${user.me_id}' == ''){
				alert('로그인한 회원만 추천/비추천이 가능합니다.')
				if(confirm('로그인 화면으로 이동하시겠습니까?')){
					location.href = '<c:url value="/member/login"/>'
				}
				return;
			}
			
			let li_state = $(this).hasClass('btn-up')? 1 : -1;
			let data = {
					li_me_id : '${user.me_id}',
					li_bo_num : '${board.bo_num}',
					li_state : li_state
			};
			
			ajaxJsonToJson(false, 'post', '/board/like', data, (data)=>{
				if(data.res == 1){
					alert('추천했습니다.');
				}else if(data.res == -1){
					alert('비추천했습니다.')
				}else if(data.res == 0){
					if(li_state == 1){
						alert('추천을 취소했습니다.');
					}
					else{
						alert('비추천을 취소했습니다.')
					}
				}
				// 텍스트 업다운이 갑자기 어디서 나옴?
				// 은 추천/비추천 버튼 옆에(추천수/비추천수 할때 쓴든)
				// 근데 갸가 왜 쟈가 되는데???????????????????????????????????????
				displayLikeBtn(data.res);
				$('.text-up').text(data.board.bo_up);
				$('.text-down').text(data.board.bo_down);
			})
		});
		
		
		function displayLikeBtn(li_state){
			// (추천 + 비추천) like상태에 따라 버튼 색상 달라지게!
			// 화면에서 보이는 초기 상태는 색깔이 (같으면 왔다갔다만 해도되는데) 달라서 각각, 두번씩 작업 해줘야함
			let $upBtn = ${'btn-up'};
			let $downBtn = ${'btn-down'};
			$upBtn.removeClass('btn-primary').addClass('btn-outline-primary');
			$downBtn.removeClass('btn-danger').addClass('btn-outlin-danger');
			
			// 함수로 변경
			if(li_state == 1){
				$upBtn.addClass('btn-primary').removeClass('btn-outline-primary');
			}else if(li_state == -1){
				$downBtn.addClass('btn-danger').removeClass('btn-outlin-danger');
			}
		}
		
		// 이 함수는 다른 페이지에서도 쓰일 수 있으니. 헤더 말고 베이스레이아웃으로!
		// => baseLayout.jsp 로 이동
		//function ajaxJsonToJson(async, type, url, sendObject, successFunc){
		//	$.ajax({
		//		async : async, // 동기화
		//		type : type, //전송방식
		//		url : '<c:url value="/"/>'+url, //데이터를 보낼 url
		//		data : JSON.stringify(sendObject), //보낼 데이터. 보통 객체나 json으로 보냄
		//		contentType : "application/json; charset=UTF-8", //서버로 보낼 데이터의 타입, data의 타입
		//		dataType : "json", //서버에서 화면으로 보낸 데이터의 타입, 서버에서 보낸!!
		//		success : successFunc
		//	});
		//}
	</script>

	<!-- 댓글 기능 자바스크립트 -->
	<script type="text/javascript">
		$('[name=co_contents]').focus(function(){
			if('${user.me_id}' == ''){
				if(confirm('댓글을 작성하려면 로그인이 필요합니다. 로그인을 하겠습니까?')){
					location.href = '<c:url value="/member/login"/>';
				}
				$(this).blur(); // 포커스 - 알림창 - 취소 - 다시 포커스가 활성화되는걸 막아줌(포커스해지)
				return;
			}
		});
		$('.btn-comment-insert').click(() =>{
			if('${user.me_id}' == ''){
				if(confirm('댓글을 작성하려면 로그인이 필요합니다. 로그인을 하겠습니까?')){
					location.href = '<c:url value="/member/login"/>';
				}
				return;
			}
			let co_contents = $('[name=co_contents]').val();
			let comment = {
					co_contents : co_contents,
					co_bo_num : '${board.bo_num}',
					co_me_id : '${user.me_id}'
			}
			if(co_contents == ''){
				alert('내용을 입력하세요.');
				return;
			}
			ajaxJsonToJson(false, 'post', '/comment/insert', comment, (data)=>{
				// console.log(data);
				if(data.res){
					alert('댓글을 등록했습니다.');
					$('[name=co_contents]').val('');
				}else{
					alert('댓글을 등록하지 못했습니다.');
				}
			});
		});
	</script>
</body>
</html>