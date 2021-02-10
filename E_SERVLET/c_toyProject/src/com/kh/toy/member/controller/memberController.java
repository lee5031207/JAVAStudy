package com.kh.toy.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.URLEncoder;

import com.google.gson.Gson;
import com.kh.toy.common.code.Code;
import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.common.mail.MailSender;
import com.kh.toy.common.util.http.HttpUtil;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;
import com.kh.toy.test.controller.SMS;

@WebServlet("/member/*")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberService();
    
    public memberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "join":
			join(request, response);
			break;
		case "idcheck" :
			confirmId(request,response);
			break;
		case "mailauth" :
			authenticateEmail(request,response);
			break;
		case "joinimpl":
			joinImpl(request, response);
			break;
		case "login":
			login(request, response);
			break;
		case "loginimpl":
			loginImpl(request, response);
			break;
		case "logout" :
			logout(request, response);
			break;
		case "mypage" :
			mypage(request, response);
			break;
		case "getAuthNum" :
			getAuthNum(request, response);
			break;
		case "confirmAuthNum" :
			confirmAuthNum(request, response);
			break;
		default:
			response.setStatus(404);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/join.jsp")
		.forward(request, response);
	}
	
	private void confirmId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		Member member = memberService.selectMemberById(userId);
		
		if(member != null) {
			//아이디가 있다 -> 응답 바디에 fail작성
			response.getWriter().print("fail");
		}else if(member == null){
			//아이디가 없다 -> 응답 바디에 success작성
			response.getWriter().print("success");
		}
	}
	
	private void authenticateEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String password = request.getParameter("pw");
		String tell = request.getParameter("tell");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		member.setTell(tell);
		member.setEmail(email);
		
		memberService.authenticateEmail(member);
		
		//사용자가 이메일을 확인할 동안 Session에 저장해주어야 한다, 사용자가 입력한 값을
		request.getSession().setAttribute("persistUser", member);
		
		request.setAttribute("msg", "회원가입 완료를 위한 이메일이 발송되었습니다");
		request.setAttribute("url", "/index");
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
		
	}
	
	private void joinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member member = (Member) request.getSession().getAttribute("persistUser");
		memberService.insertMember(member);
		
		//Session에서 삭제
		request.getSession().removeAttribute("persistUser");
		
		request.setAttribute("msg", "회원 가입을 축하드립니다");
		request.setAttribute("url", "/member/login");
		request.getRequestDispatcher("/WEB-INF/view/common/result.jsp")
		.forward(request, response);
		
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp")
		.forward(request, response);
	}
	
	private void loginImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonData = request.getParameter("data"); 
		
		Gson gson = new Gson();
		//Map형식으로 받음 
		Map<String,Object> jsonMap = gson.fromJson(jsonData, Map.class);
		String userId = (String)jsonMap.get("id");
		String password = (String)jsonMap.get("pw");
		
		Member member = memberService.memberAuthenticate(userId, password);
		
		if(member != null) {
			request.getSession().setAttribute("user", member);
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
			//throw new ToAlertException(ErrorCode.SM02);
		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect("/index");
	}
	
	private void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp")
		.forward(request, response);
	}
	
	protected void getAuthNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:263561292248:lets_share/messages";
		String phoneNum = request.getParameter("phoneNum");
		int authNum= (int) Math.round(Math.random()*1000000);
		String authCode = Integer.toString(authNum);
		
		
		String content = "Let's share입니다.\n인증 번호["+authCode+"]";
		
		HttpUtil httpUtil = new HttpUtil();
		SMS sms = new SMS();

		
		try {
			// 1. 문자 보내주자
			Map<String, String> headers = sms.getSMSHeaders();
			String body = sms.getSMSBody(phoneNum, content);
			//httpUtil.post(url, headers, body);
			
			// 2. 세션에 인증코드 넣어주자
			request.getSession().setAttribute("authCode", authCode);
			System.out.println("세션에 넣어준 값 : "+authCode);
			response.getWriter().print("success");
			
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
			response.getWriter().print("fail");
			e.printStackTrace();
		}
		
	}
	
	protected void confirmAuthNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiveCode = request.getParameter("authCode");
		String sessionCode = (String) request.getSession().getAttribute("authCode");
		
		if(receiveCode.equals(sessionCode)) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
	}

}
