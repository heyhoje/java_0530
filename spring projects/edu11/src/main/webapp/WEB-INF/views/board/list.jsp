<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록 조회</title>
</head>
<body>
	<!-- ${list} -->
	
<div class="container">
	<h2 class="pt-5">게시글 조회</h2>
	<p> 전체 연령이 이용하는 공간입니다. 바르고 고운말을 씁시다!</p>
	
	<!-- 검색창 -->
	<form action="<c:url value='/board/list'/>" method="get">
		<div class="input-group mb-3">
			<select class="form-control" name="t">
				<option value="all" <c:if test="${pm.cri.t == 'all'}">selected</c:if>>전체</option>
				<option value="total" <c:if test="${pm.cri.t == 'total'}">selected</c:if>>제목 + 내용</option>
				<option value="writer" <c:if test="${pm.cri.t == 'writer'}">selected</c:if>>작성자</option>
			</select>
			<input type="text" class="form-control" name="s">
			<button class="btn btn-outline-dark">검색</button>
	    </div>
    </form>
	<table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>추천/비추천</th>
	        <th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="board" varStatus="vs">
				<tr>
					<td>${pm.totalCount - vs.index}</td>
					<td><a href="<c:url value='/board/detail/${board.bo_num}'/>">${board.bo_title}</a></td>
					<td>${board.bo_me_id}</td>
					<td>${board.bo_up}/${board.bo_down}</td>
					<td>${board.bo_views}</td>
				</tr>
			</c:forEach>
	    </tbody>
	  </table>
	  
	  <!-- 페이지네이션 -->
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<li class="page-item">
					<a class="page-link" 
						href="<c:url value='/board/list${pm.cri.getUrl -1}'/>">이전</a>
					
				</li>
			</c:if>
			
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
		    	<li class="page-item <c:if test='${pm.cri.page == i}'>active</c:if>">
		    		<a class="page-link" 
		    			href="<c:url value='/board/list${pm.cri.getUrl(i)}'/>">${i}</a>
	    		</li>
		    </c:forEach>
		    
		    <c:if test="${pm.next}">
				<li class="page-item">
		  	  		<a class="page-link" 
		  	  			href="<c:url value='/board/list${pm.cri.getUrl +1}'/>">다음</a>
	  	  		</li>
	    	</c:if>
		</ul>
	</div>
	${pm}
</body>
</html>