<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style type="text/css">
	span{
		display: block;
		font-size: 1.5vw;
	}
</style>
</head>
<body>
	<h2>1. c:set 변수 생성</h2>
	<%-- var: 변수, value : 값 --%>
	<c:set var="num1" value="100"/>
	<c:set var="num2" value="200"/>
	<c:set var="html" value="<a href='https://www.naver.com'>naver로 이동</a>"/>
	<c:set var="js" value="<script>alert('el표현식은 경고창이 뜬다')</script>"/>
	
	<h2>1. c:out 변수 생성</h2>
	<span>num1 : <c:out value="${num1}"/></span>
	<span>num2 : ${num2}</span>
	
	
	<span>c:out html : <c:out value="${html}"/></span>
	<span>el html : ${html}</span>
	
	<span>c:out js : <c:out value="${js}"/></span>
	<span>el js : ${js}</span>
</body>
</html>