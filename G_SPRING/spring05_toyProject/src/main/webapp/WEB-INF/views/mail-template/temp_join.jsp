<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.kh.toy.common.code.Code" 
    %>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<body>
	<h1>회원가입을 완료해주세요!</h1>
	<h2>환영합니다!  ${userId}님!</h2>
	<h2>아래의 링크를 클릭해 회원가입을 완료해 주세요</h2>
	<!-- Code 클래스 임포트 해주어야함 3번째 줄  -->
	<h3><a href="<%=Code.DOMAIN%>/member/joinimpl/${authPath}">회원가입 완료</a></h3> 
	<img src ="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fi.pinimg.com%2F736x%2F31%2F22%2Fd8%2F3122d859838c84a2f45ea8338aff486c.jpg&type=sc960_832">
</body>
</html>