<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
<style>
	span{
		display: block;
		font-size: 1.5vw;
	}
</style>
</head>
<body>
	<%--
		${} == <%= => //출력하는 코드
		
		el표기법 : 자바 bean 객체의 값들을 편하게 사용하기 위해 제공되는 표기법
		자바 bean규약을 따르는 객체를 자바 bean객체라고 한다.
		자바 bean 규약 : 기본 생성자, 캡슐화, getter/setter
		request.setAttribute()/.getAttribute(), session, servletContext
		
		${} : 객체 프로퍼티에서 값을 꺼낼 때 주로 사용
		#{} : 객체 프로퍼티에 값을 넣을 대 주로 사용(x)
		
		el에서 접근 가능한 객체 
		${requestScope.name} : request 객체의 Attribute에 저장된 값에 접근
		${sessionScope.name} : session 객체의 Attribute에 저장된 값에 접근
		${applicationScope.name} : servletContext 객체의 Attribute에 저장된 값에 접근
		
		scope를 명시하지 않고 속성명만 작성할 경우, 현재 page scope로 부터
		가까운 scope를 탐색하며 해당 속성으 값을 찾는다. (JS의 scope chain)
		
		
		${param.name} : request객체에 저장된 parameter 접근
		${paramValues.name} : 같은 파라미터명으로 저장된 데이터가 여러 개일 경우 배열로 받아온다
		${cookie.name} : 쿠키 값 조회
	 --%>
	 
	 <h2>el 사용하기</h2>
	 <%-- <%= request.getAttribute("name") --%>
	 <span>이름 : ${param.name}</span>
	 
	 <%-- <%= request.getAttribute("sum") --%>
	 <span>총합 : ${requestScope.sum}</span>
	 
	 <%-- <%= request.getAttribute("avg") --%>
	 <!-- scope없이 속성명만 작성하면 가까운 스코프부터 해당 속성명을 가진 값을 탐색 -->
	 <span>평균 : ${avg}</span>
	 
	 <h2>EL에서 객체 데이터 꺼내 쓰기</h2>
	 <!-- 1. vo에서 데이터 꺼내쓰기 -->
	 <h3>vo에서 꺼내쓰기</h3>
	 <pre>
		 vo.속성명 을 사용해 해당 속성 값을 꺼내 쓸 수 있다
	 </pre>
	 <span>이름 : ${requestScope.student.name}</span>
	 <span>국어 : ${requestScope.student.kor}</span>
	 <span>영어 : ${requestScope.student.eng}</span>
	 <span>수학 : ${requestScope.student.math}</span>
	 <span>코딩 : ${requestScope.student.coding}</span>
	 <span>합계 : ${requestScope.student.sum}</span>
	 <span>평균 : ${requestScope.student.avg}</span>
	 
	 <!-- 2. map에서 데이터 꺼내쓰기 -->
	 <h3>map에서 꺼내쓰기</h3>
	 <pre>
		 map.키 형태로 키로 저장된 값을 꺼내 쓸 수 있다.
	 </pre>
	 <span>이름 : ${requestScope.studentMap.name}</span>
	 <span>국어 : ${studentMap.kor}</span>
	 <span>영어 : ${requestScope.studentMap.eng}</span>
	 <span>수학 : ${studentMap.math}</span>
	 <span>코딩 : ${requestScope.studentMap.coding}</span>
	 <span>합계 : ${studentMap.sum}</span>
	 <span>평균 : ${requestScope.studentMap.avg}</span>
	 
	 <!-- 3. list/array 에서 데이터 꺼내쓰기 -->
	 <h3>list/array에서 꺼내쓰기</h3>
	 <pre>
		 
	 </pre>
	 <span>이름 : ${requestScope.studentList[0].name}</span>
	 <span>국어 : ${requestScope.studentList[1].kor}</span>
	 <span>영어 : ${requestScope.studentList[0].eng}</span>
	 <span>수학 : ${studentList[1].math}</span>
	 <span>코딩 : ${studentList[0].coding}</span>
	 <span>합계 : ${studentList[1].sum}</span>
	 <span>평균 : ${studentList[0].avg}</span>
	 
	 <h3>cookie.name</h3>
	 <span>JSESSION : ${cookie.JSESSIONID.value}</span>
	 
	 <h3>session 확인</h3>
	 <span>${sessionScope.name}님 반갑습니다</span>


	 <h3>EL 리터럴 표현식</h3>
	 <span>문자열 : ${"문자열 테스트"}</span>
	 <span>문자열 : ${"문자열 테스트"}</span>
	 <span>정수 : ${20}</span>
	 <span>실수 : ${20.5}</span>
	 <span>boolean : ${true}</span>
	 <!-- null이 담길 경우 공백으로 출력-->
	 <span>null : ${null}</span>

	 <h3>EL 연산자</h3>
	 <pre>산술연산자, 논리연산자, 비교연산자, 삼항연산자, empty 연산자</pre>
	 <h4>산술 연산자(+,-,*,/,%)</h4>
	 <span>1+1 = ${1+1}</span>
	 <span>1-1 = ${1-1}</span>
	 <span>1*3 = ${1*3}</span>
	 <span>3/1 = ${3/1}</span>
	 <span>2%3 = ${2 mod 3}</span> <!-- %, mod  -->
</body>
</html>