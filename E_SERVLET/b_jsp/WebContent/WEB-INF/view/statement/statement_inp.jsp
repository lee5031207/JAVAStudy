<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>짝수 홀수 판별</title>
</head>
<body>
	<!-- 
		사용자에게 정수를 하나 입력받아서 
		해당 정수가 홀수 인지 짝수인지 판단하는 서비스
	 -->
	 <h2>짝수 홀수 판별</h2>
	 <form action="/jsp/statement/calc" method="POST">
		<label>입력 : <input type="number" name="num"></label>
		<button>확인</button>
	</form>
</body>
</html>