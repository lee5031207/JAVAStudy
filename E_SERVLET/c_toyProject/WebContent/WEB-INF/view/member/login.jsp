<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>
	<style type="text/css">
	.valid_info{
		display:block;
		color:red;
		font-size:0.5vw;
	}
	
	.tit{
		display:inline-block;
		width:50px;
	}
</style>
</head>
<body>
	<h1>로그인</h1>
	<hr>
		<span class="tit">ID :</span><input type="text" name="id" id="id"><br>
		<span class="tit">PW :</span><input type="password" name="pw" id="pw">
		<span class="valid_info"></span>
		<button onclick="login()">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=8a92e5d7d3324acd050fd30b648b921b&redirect_uri=http://localhost:9090/Kakao/oauth&response_type=code">
			<img src="../../../resources/image/kakao_login_medium_narrow.png" />
		</a>
		
	<script type="text/javascript">
	let login = () => {
		
		const url = '/member/loginimpl';

		//인코딩하고 파라미터를 객체 형식으러 넘긴다
		let params = {};
		params.id = id.value;
		params.pw = pw.value;

		//post방식으로 진행
		//헤더 설정
		let headerObj = new Headers();
		//form태그의 기본 content 타입인 application/x-www-form-urlencoded 로
		//content-type을 맞춰야 서버에서 편하게 getParameter로 사용 할 수 있다.
		//name=value&name=value
		headerObj.append("content-type","application/x-www-form-urlencoded");
		fetch(url,{
			method:"post",
			headers:headerObj,
			body:"data=" + JSON.stringify(params)
		})
		.then(response => {
			//200번대 응답코드라면
			if(response.ok){
				return response.text();
			}else{
				throw new AsyncResponseError(response.text());
			}
		})
		.then(text => {
			if(text == 'fail'){
				document.querySelector('.valid_info').innerHTML = '아이디나 비밀번호를 확인하세요.';
			}else if(text == 'success'){
				location.href = "/index";
			}
		}).catch((error)=>{
			error.alertMessage();
		})
	}
	</script>	
</body>
</html>