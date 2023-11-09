<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공공데이터 요청해서 화면에 뿌려주기</title>
</head>
<body>
	<div>
		<input id="pageNo" placeholder="페이지번호" value="1"> <br>
		<input id="numOfRows" placeholder="시설 개수" value="5"> <br>
		<button id="btn">조회</button>
	</div>
	<table>
		<tr>
			<thead>
				<th>시도명</th>
				<th>시군구명</th>
				<th>대피지구명</th>
				<th>대피장소명</th>
				<th>주소</th>
			</thead>
			<tbody>
				
			</tbody>	
		</tr>
	</table>
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>	
	<script >
		$('#btn').click(function(){
			console.log(1); // 이벤트 확인
			let pageNo = $('pageNo').val();
			let numOfRows = $('numOfRows').val();
			
			$.ajax({
				url : '<c:url value="/api/request"/>',
				data : {
					pageNO : pageNO,
					numOfRows : numOfRows
				},
				success : function(data){
					console.log(data);
					let obj = JSON.parse(data) // json으로 보낸 문자열?을 객체object로 바꿔줌
					console.log(obj)
					// console.log(obj.보라색 영어 이름 복사[몇 번지에 있는 값].row)
					let list = console.log(obj.보라색 영어 이름 복사[몇 번지에 있는 값].row);
					console.log(list)
					let str = '';
					for(item of list){
						str += `
							<tr>
								<td>\${item.시도명}</td>
								<td>\${item.시군구명}</td>
								<td>\${item.시설명}</td>
							</tr>		
						`;
					}
					$('tbody').html(str);
				},
				error : function(a,b,c){
				console.log(a)
				}
			})

		});
	</script>
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>	
	<script type="text/javascript>">
		$('#btn').click(function(){
			console.log(1); // 이벤트 확인
			let pageNO = $('#pageNo').val();
			let numOfRows = $('#numOfRows').val();
			$.ajax({
				url : '<c:url value="/api/request"/>',
				data : {
					pageNO : pageNO,
					numOfRows : numOfRows
				},
				success : function(data){
					console.log(data);
					let obj = JSON.parse(data) // json으로 보낸 문자열?을 객체object로 바꿔줌
					console.log(obj)
					// console.log(obj.보라색 영어 이름 복사[몇 번지에 있는 값].row)
					let list = console.log(obj.보라색 영어 이름 복사[몇 번지에 있는 값].row);
					console.log(list)
					let str = '';
					for(item of list){
						str += `
							<tr>
								<td>\${item.시도명}</td>
								<td>\${item.시군구명}</td>
								<td>\${item.시설명}</td>
							</tr>		
						`;
					}
					$('tbody').html(str);
				},
				error : function(a,b,c){
				console.log(a)
				}
			})
		});
	</script>
</body>
</html>