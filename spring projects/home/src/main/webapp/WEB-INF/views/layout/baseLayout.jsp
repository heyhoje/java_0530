<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
	function ajaxJsonToJson(async, type, url, sendObject, successFunc){
		$.ajax({
			async : async, // 동기화
			type : type, //전송방식
			url : '<c:url value="/"/>'+url, //데이터를 보낼 url
			data : JSON.stringify(sendObject), //보낼 데이터. 보통 객체나 json으로 보냄
			contentType : "application/json; charset=UTF-8", //서버로 보낼 데이터의 타입, data의 타입
			dataType : "json", //서버에서 화면으로 보낸 데이터의 타입, 서버에서 보낸!!
			success : successFunc
		});
	}
	</script>
	
	<title>스프링</title>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <div class="container" style="min-height: calc(100vh - 66px - 184px)">        
    	<tiles:insertAttribute name="body" />
    </div>                                                  
    <tiles:insertAttribute name="footer" />
</body>
</html>