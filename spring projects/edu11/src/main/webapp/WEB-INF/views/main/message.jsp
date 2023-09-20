<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>

<script type="text/javascript">
	//여긴 다시봐도 모르겠어...
	let msg = '${msg}';
	let url = '${url}';
	msg = msg == '' ? '잘못된 접근입니다.' : msg;
	
	alert(msg);
	location.href = '<c:url value="/"/>' + url;
	
	
</script>
</body>
</html>