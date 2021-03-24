<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<h2>Mypage</h2>
	<ol type="i">
		<li>아이디 : ${sessionScope.userInfo.userId}</li>
		<li>비밀번호 : </li>
		<li>전화번호 : ${sessionScope.userInfo.tell}</li>
		<li>이메일 : ${sessionScope.userInfo.email}</li>
		<li>회원 등급 : ${sessionScope.userInfo.grade}</li>
	</ol>
	
	<h2><a href="/member/leave">회원 탈퇴</a></h2>

</body>
</html>