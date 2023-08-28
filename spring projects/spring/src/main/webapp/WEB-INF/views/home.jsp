<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="uft-8 %>
<!doctype html>
<html lang="ko">
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<title>스프링</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="c:url value='/resources/img/logo.jpg'/>" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value='signup'/>">회원가입</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>
</nav>

<h1>
	Hello world!  
</h1>

<P>  My name is ${name}. </P>
<form action="<c:url value='test1'/>">
	<input type="text" name="id"> <br>
	<input type="text" name="age"> <br>
	<button>전송</button>
</form>
</body>
</html>
