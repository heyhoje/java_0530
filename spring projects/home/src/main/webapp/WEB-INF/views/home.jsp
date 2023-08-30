<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>메인</h1>
	<c:if test="${user == null}">
		<a href="<c:url value='/member/signup'/>">회원가입</a>
		<a href="<c:url value='/member/login'/>">로그인</a>
	</c:if>
	<C:if test="${user != null}">
		<a href="<c:url value='/member/logout'>"
	</C:if>
</body>
</html>
