<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>
    <style>
        span{
            display: block;
            position: relative;
            width : 150px;
        }
        button{
            width : 300px;
        }
    </style>
</head>
<body>
    <form action="/member/loginimpl" method="POST">
        <span>ID : </span><input type="text" name="id" id="id"><br>
        <span>PW : </span><input type="password" name="pw" id="pw"><br><br>
        <button>로그인</button>
    </form>
</body>
</html>