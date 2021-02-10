<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<head>
	<style type="text/css">
		.valid_info{
			display:block; 
			color:red;
			font-size: 0.5vw;
		}
	</style>
</head>
<body>
 <h1>회원 가입 양식</h1>
    <form action="${context}/member/mailauth" method="post" id="frm_join">
     <table>
        <tr>
           <td>ID : </td>
           <td>
           	  <input type="text" name="id" id="id" size="10" required/>
              <button type="button" onclick="idCheck()">check</button>
              <span class="valid_info" id="id_check"></span>
           </td>
        </tr>
        <tr>
           <td>PASSWORD : </td>
           <td>
           	  <input type="password" name="pw" id="pw" required/>
           	  <span id="pw_confirm" class="valid_info"></span>
           </td>
        </tr>
        <tr>
           <td>휴대폰번호 : </td>
           <td>
           	  <input type="tel" name="tell" id="tell" required/>
           	  <button type="button" onclick="getAuthNum()">인증 번호 받기</button>
			  <span class="valid_info" id="phone_check"></span>
           </td>
        </tr>
        <tr>
           <td>인증 번호 : </td>
           <td>
           	  <input type="text" name="authCode" id="authCode" required/>
           	  <button type="button" onclick="confirmAuthNum()">확인</button>
			  <span class="valid_info" id="confirmAuthNum"></span>
           </td>
        </tr>
        <tr>
           <td>email : </td>
           <td>
           	  <input type="email" name="email" required/>
           </td>
        </tr>
        <tr>
           <td>
              <input type="submit" value="가입" />
              <input type="reset" value="취소" />
           </td>
       </tr>
   </table>
   </form>
   
   <script type="text/javascript">
   let idCheckFlg = false;
   let idCheck = () => {
	   //사용자가 입력한 아이디
	   //요소의 아이디속성이 있을 경우 해당 엘리먼트를 가져다가 사용할 수 있다.
	   let userId = id.value;
	   if(userId){
		   fetch("/member/idcheck?userId=" + userId,{
			   method:"GET"
		   })
		   .then(response => response.text())
		   .then(text =>{
			   if(text == 'success'){
				   idCheckFlg = true;
				   id_check.innerHTML = '사용 가능한 아이디 입니다.';
			   }else{
				   idCheckFlg = false;
				   id_check.innerHTML = '사용 불가능한 아이디 입니다.';
				   id.value="";
			   }
		   })
	   }else{
		   alert("아이디를 입력하지 않으셨습니다.");
	   }
   }

   let getAuthNum = () => {
	   let phoneNum = tell.value;
	   let phoneRegExp = /^[0-9]{11,11}$/;

		if(tell){
			if(!(phoneRegExp.test(phoneNum))){
				alert("정확한 휴대전화 번호를 입력해주세요");
			}else{
				fetch("/member/getAuthNum?phoneNum=" + phoneNum,{
			   		method:"GET"
		  		})
				.then(response => response.text())
				.then(text => {
					if(text == 'success'){
						phone_check.innerHTML = '인증 문자를 보냈습니다.';
					}else{
						phone_check.innerHTML = '잘못된 휴대전화 번호입니다.';
						id.value="";
					}
				})
			}
		}else{
			alert("휴대폰 번호를 입력하지 않으셨습니다.");
		}
   }
   
   
   
   
   let confirmAuthNum = () => {
	   let phoneCheck = false;
	   let authCode = document.querySelector("#authCode").value;
	   if(authCode){
		   fetch("/member/confirmAuthNum?authCode=" + authCode,{
			   method:"GET"
		   })
		   .then(response => response.text())
		   .then(text =>{
			   if(text == 'success'){
				    phoneCheck = true;
				    alert("인증이 완료 되었습니다.");
			   }else{
				    phoneCheck = false;
				    alert("잘못된 인증번호를 입력 하였습니다.");
				    document.querySelector("#authCode").value.value="";
			   }
		   })
	   }else{
		   alert("인증번호를 입력하세요");
	   }
   }
   
   document.querySelector('#frm_join').addEventListener('submit',(e)=>{
	   let password = pw.value;
	   let regExp = /^(?!.*[ㄱ-힣])(?=.*\W)(?=.*\d)(?=.*[a-zA-Z])(?=.{8,})/;
	   
	   if(!idCheckFlg){
		   e.preventDefault();
		   alert("아이디 중복검사를 하지 않으셨습니다.");
		   id.focus()
	   }
	   
	   if(!(regExp.test(password))){
		   //form의 데이터 전송을 막음
		   e.preventDefault();
		   pw_confirm.innerHTML = '비밀번호는 숫자,영문자,특수문자 조합의 8글자 이상인 문자열입니다.';
		   pw.value='';
	   }
   });
   
   
   
   
   </script>
   
</body>
</html>