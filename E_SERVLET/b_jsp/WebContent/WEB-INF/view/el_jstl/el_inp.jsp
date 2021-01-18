<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL_INP</title>
</head>
<body>
    <h1>성적 입력</h1>
    <form action="/jsp/el/elimpl" method="POST">
        <label>이름 : <input type="text" name="name"></label><br>
        <label>국어 : <input type="text" name="kor"></label><br>
        <label>영어 : <input type="text" name="eng"></label><br>
        <label>수학 : <input type="text" name="math"></label><br>
        <label>코딩 : <input type="text" name="coding"></label>
        <button>전송</button>
    </form>
    
</body>
</html>