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
	
	<h2>3. jstl을 사용한 배열 생성</h2>
	<c:set var="jstlArr">
		red,blue,yellow,pink,green
	</c:set>
	<span>jstlArr : <c:out value="${jstlArr}"/></span>


	<h2>4. jstl 조건문</h2>
	<h3>c:if</h3>
	<c:if test="${num1 < num2}">
		<span>조건문의 조건식 결과가 true 입니다</span>
	</c:if>

	<c:if test="${true and false}">
		<span>조건문의 조건식 결과가 false 입니다</span>
	</c:if>

	<h3>c:choose when otherwise</h3>
	<c:set var="score" value="30" />
	<c:choose>
		<c:when test = "${score ge 90}">
			<span>당신의 학점은 A</span>
		</c:when>
		<c:when test = "${score ge 80}">
			<span>당신의 학점은 B</span>
		</c:when>
		<c:when test = "${score ge 70}">
			<span>당신의 학점은 C</span>
		</c:when>
		<c:otherwise>
			<span>당신의 학점은 F입니다.</span>
		</c:otherwise>
	</c:choose>


	<h2>5. jstl 반복문</h2>

	<h3>c:forEach</h3>
	<h4>for문처럼 사용하기</h4>
	<pre>
		var: 배열 또는 리스트의 요소를 받으 변수
		items : forEach에서 탐색할 배열 또는 리스트
		varStatus : index, count 속성을 가진 객체
			index : 현재 탐색 중인 요소의 인덱스(시작 0)
			count : 현재 탐색 중인 요소의 차례(시작 1)
	</pre>
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>value</th>
		</tr>
		<c:forEach var="color" items="${jstlArr}" varStatus="status">
			<tr>
				<td><span>${status.index}</span></td>
				<td><span>${status.count}</span></td>
				<td><span>${color}</span></td>
			</tr>
		</c:forEach>
	</table>

	<h3>c:forTokens : StringTokenizer와 유사한 기능</h3>
	<pre>
		var : 잘라진 문자열을 받을 변수
		items : 자를 문자열
		delims : 구분자
	</pre>
	<ul>
		<c:forTokens var="lang" items="java html css js oracle servlet" delims=" ">
			<li>
				${lang}
			</li>
		</c:forTokens>
	</ul>
	
	
</body>
</html>