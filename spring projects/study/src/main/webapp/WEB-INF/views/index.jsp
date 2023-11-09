<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>공공데이터 요청해서 화면에 뿌려주기</title>
</head>
<body>
	<h2>실시간 대기오염 정보</h2>
	<div>
		지역
		<select id = "location">
			<option value="서울">서울</option>
			<option value="부산">부산</option>
			<option value="대전">대전</option>
		</select>
		
		<button id="btn1">해당 지역 대기오염 정보</button>
	</div>
	<br> <br>
	
	<table id = "result1" border = "1">
		<tr>
			<thead>
				<th>측정소명</th>
				<th>측정일시</th>
				<th>통합대기환경수치</th>
				<th>미세먼지농도</th>
				<th>일산화탄소농도</th>
				<th>이산화질소농도</th>
				<th>아황산가스농도</th>
				<th>오존농도</th>
			</thead>
			<tbody>
				
			</tbody>	
		</tr>
	</table>
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>	
	<script>
		$('#btn1').click(function(){
			console.log(1); // 이벤트 확인
			let location = $('#location').val();
			
			
			$.ajax({
				url : "<c:url value='/api/request2'/>",
				data : {location : $('#location').val()},
				success : function(data){
					console.log(data);
					let obj = JSON.parse(data)
					console.log(obj)
					
					const itemArr = data.response.body.items;
					let value = "";
					for(let i in itemArr){
						// for문 안에 있는 내용을 코딩하시오
						let item = itemArr[i];
						value += `
							<tr>
								<td>\${item.stationName}</td>
								<td>\${item.dataTime}</td>
								<td>\${item.khaiValue}</td>
								<td>\${item.pm25Grade}</td>
								<td>\${item.coGrade}</td>
								<td>\${item.no2Flag}</td>
								<td>\${item.so2Value}</td>
								<td>\${item.o3Value}</td>
							</tr>	
						`;
					}
					$('#result1 tbody').html(value);
				},
				error : function(a,b,c){
				console.log(a)
				}
			})
		});
	</script>
	
</body>
</html>