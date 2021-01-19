<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/head.jsp" %>
<body>
	 <h1>회원 가입 양식</h1>
     <form action="${context}/member/joinimpl" method="post" id="frm_join">
        <table>
            <tr>
               <td>ID : </td>
               <td>
                  <input type="text" name="id" id="id" size="10" required/>
                  <button type="button" onclick="idCheck()">check</button>
                  <span class="valid_info" id="idCheck"></span>
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
                  <input type="tel" name="tell" required/>
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
</body>
</html>