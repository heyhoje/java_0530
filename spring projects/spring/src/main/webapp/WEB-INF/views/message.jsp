<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="uft-8 %>
<!doctype html>
<html lang="ko">
<head>
	<title>스프링</title>
</head>
<body>
	<script type="text/javascript">
	let msg = '${msg}'; // toString 호출, 클래스에 문자열이 객체처럼 들어갈 수 있다는 것을 보여주기 위해?  
	if(msg != null | msg.msg != null){
		alert(msg.msg);
	}
	location.href = '<c:url value="${url}"/>'
	</script>
</body>
</html>
