<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>
	<h2>Mypage</h2>
	<ol type="i">
		<li>${sessionScope.user.userId}</li>
		<li>${sessionScope.user.password}</li>
		<li>${sessionScope.user.tell}</li>
		<li>${sessionScope.user.email}</li>
		<li>${sessionScope.user.grade}</li>
	</ol>
	
	<h2><a href="/member/leave">회원 탈퇴</a></h2>

</body>
</html>