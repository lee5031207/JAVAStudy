<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>짝수 홀수 판별</title>
</head>
<body>
	<h2>if문</h2>
	<% 
		int num = (int)request.getAttribute("num");
		if(num%2 == 0){
			out.print("<h3>짝수 입니다</h3>");
		}else{
			out.print("<h3>홀수 입니다</h3>");
		}
	%>
	<h2>for문</h2>
	<h3>1부터 사용자가 입력한 값까지의 숫자 출력</h3>
	<h3>결과 :
	<!-- 결과 : 1/2/3/4/5 -->
	<%
		for(int i=1; i<=num; i++){
			if(i==num){
				out.print(i);	
			}else{
				out.print(i+"/");	
			}
		}
	%>
	</h3>
</body>
</html>