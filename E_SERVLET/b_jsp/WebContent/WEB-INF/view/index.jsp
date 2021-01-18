<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
    <h1>JSP기초</h1>
    <pre>
        JSP는 기존에 서버용 언어인 Servlet에서
        화면 구현에 관련된 소스 부분을 별도로 분리하는 기술을 말한다.
    </pre>
    <h2>지시자 태그</h2>
    <h3><%=request.getAttribute("지시자태그")%></h3>
    <pre>
        지시자 태그란, 페이지 전체에서 사용할 속성을 지정하는 jsp태그
        1. page 지시자 태그 : 해당 페이지에서 사용할 속성을 지정
            1-1. language : 사용할 프로그래밍 언어
            1-2. import : 페이지에서 필요한 자바 클래스를 import 할 때 사용

        2. include : 다른 위치의 html,jsp를 현재 페이지에 삽입할 때 사용

        3. taglib : 다른 라이브러리에서 제공하는 커스텀 태그를 사용할 때 사용(EL/JSTL)
    </pre>
    <h2>선언 태그</h2>
    <h3><%=request.getAttribute("선언태그")%></h3>
    <pre>
        선언 태그는 메서드, 필드 변수를 선언할 때 사용, 필드에 변수는 메서드가 선언 되기 때문에
        조심해서 사용할 필요가 있다.
    </pre>
    <%!
    	//index_jsp.java의 필드 영역
    	String name = "sunguk";
    	public void jspTest(String name){
    		System.out.println("Hello "+name+"!!");
    	}
    %>
    <h2>스크립틀릿 태그</h2>
    <h3><%=request.getAttribute("스크립틀릿태그")%></h3>
    <pre>
        페이지 내부에서 JAVA소스코드를 작성하는 영역을 나타내는 코드
        스크립틀릿 태그에 작성하는 코드는 _jspService() 메서드 내부에 작성된다.
        따라서 연산을 위한 코드를 작성할 수 있다.
    </pre>
    <%
    	jspTest(name);
    	for(int i=0; i<10; i++){
    		jspTest(name);
    	}
    %>
    <h2>표현식 태그</h2>
    <h3><%=request.getAttribute("표현식태그")%></h3>
    <pre>
        표현식 태그란 특정 객체나 변수의 값을 출력하는 용도로 사용.
        out.print 메서드를 쉽게 사용할 수 있다.
    </pre>
    <p><%=name+"/ 2021년 1월 18일"%></p>
</body>
</html>