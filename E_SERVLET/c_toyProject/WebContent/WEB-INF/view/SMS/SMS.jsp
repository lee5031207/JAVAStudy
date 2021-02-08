<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>
    <h1>문자 메세지(SMS) 보내기</h1>
    <form action="${context}/sms/send" method="post" id="frm_join">
        <label for="">전화번호 : </label><input type="text" id="to" name="to" placeholder="01012345678">
        <label for="">메시지 : </label><input type="text" id="content" name="content" placeholder="메시지를 입력하시오">
        <input type="submit" value="전송">
    </form>
</body>
</html>