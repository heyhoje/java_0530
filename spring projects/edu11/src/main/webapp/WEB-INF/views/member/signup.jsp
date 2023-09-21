<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>회원가입</h1>
	${title} 
	<br>
	<form action="<c:url value='member/signup'/>" method="Get">
		<input type="text" name="test">
		<button>전송</button>
	</form>
	${line}
	<form action="<c:url value='/member/signup'/>" method="post">
		<div class="form-group">
			<input type="text" name="me_id" class="form-control" placeholder="아이디">
		</div>
		<button class="btn btn-outline-dark col-12" type="button" id="btn-check">아이디 중복체크</button>
		<br>
		<br>
		<div class="form-group">
			<input type="password" name="me_pw" class="form-control" placeholder="비밀번호">
		</div>
		<div class="form-group">
			<input type="password" name="me_pw2" class="form-control" placeholder="비밀번호 확인">
		</div>
		<div class="form-group">
			<input type="text" name="me_email" class="form-control" placeholder="이메일">
		</div>
		<button class="btn btn-success col-12">회원가입</button>
		
		${line}
		
		<br>
		<ul>
			<li>
				<a name="id">아이디</a>
			</li>
			<button>아이디 중복 확인</button>
			<li>
				<a name="pw">비번</a>
				<a name="pw2">비번확인</a>
				<a name="email">이메일</a>
			</li>
		</ul>
	</form>	
	
	
	<script type="text/javascript">
	
		
		$('#btn-check').click(function(){
			// console.log(1); // 이벤트가 잘 동작하는지 콘솔.로그나 alert로 꼭! 확인하고 넘어가기/근데 난 꼭 안되더라..../너 진짜 배신이야...
			// 서버로 아이디를 전달 => Object로 id만 서버로 전송..?!
			let id = $('[name=me_id]').val();
			if(id.trim() == ''){
				alert('아이디를 입력하세요.');
				return;
			}
			$.ajax({
				async : true,
				url : '<c:url value="/member/id/check"/>', 
				type : 'post', 
				data : {id : id}, // {속성이름, 값(변수명 let id)}
				success : function (data){
					// 서버에서 아이디 사용 가능여부를 알려주면 알림창으로 알려줌 => Object로 사용가능/불가능만 알려주면 됨ㅇ.ㅇ
					console.log(data)
					if(data){
						alert('사용 가능한 아이디 입니다.')
						checkId = true;
					}else {
						alert('이미 사용중인 아이디입니다.')
						checkId = false;
					}
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					console.log(jqXHR)
				}
			});
	})
	
	// 회원가입 폼태그 제출시?
	$('form').submit(function(){
		if(!checkId){
			alert('아이디 중복 검사를 하세요.')
			return false;			
		}
	})
	// 아이디 내용이 바뀌면 다시 검사ㄱ
	$('[name=me_id]').change(function(){
		checkId = false;
	})
	</script>
	
</body>
</html>