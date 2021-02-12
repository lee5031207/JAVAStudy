<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/board.css" />
<link rel="stylesheet" href="/resources/css/reset.css"/>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<body>
		<div class="content">   
			  <table border="1">
				  <tr>
					  <td>글 번호</td>
					  <td>제목</td>
					  <td>작성자</td>
					  <td>작성일</td>
					  <td>조회수</td>
				  </tr>
				  <c:forEach var="notice" items="${noticeList}">
				  <tr>
					  <td>${notice.bdIdx}</td>
					  <td>${notice.title}</td>
					  <td>${notice.userId}</td>
					  <td>${notice.regDate}</td>
					  <td>${notice.cnt}</td>
				  </tr>
				  </c:forEach>
				  <span><a href="/notice/noticeList?page=${firstPage-1}"><i class="fas fa-arrow-left"></i></a></span>
				  <c:forEach var="page" items="${pageList}">
				  <span><a href="/notice/noticeList?page=${page}">${page}</a>  </span>
				  </c:forEach>
				  <span><a href="/notice/noticeList?page=${lastPage+1}"><i class="fas fa-arrow-right"></i></a></span>
			  </table>
		</div>
		<footer class="bottom"></footer>
	</body>
</html>