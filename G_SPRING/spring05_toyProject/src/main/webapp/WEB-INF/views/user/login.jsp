<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴팜</title>
</head>
<body>
	ID :<input type="text" name="userId" id="id"><br>
	PW :<input type="password" name="password" id="pw">
	<button onclick="login()">로그인</button>
</body>
<script type="text/javascript">
	let login = () => {
		
		const url = '/user/loginimpl';
		
		let params = {};
		params.userId = id.value;
		params.userPw = pw.value;
		
		let headerObj = new Headers();
		headerObj.append("content-type","application/json");
		fetch(url,{
			method:"post",
			headers:headerObj,
			body:JSON.stringify(params)
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
</html>