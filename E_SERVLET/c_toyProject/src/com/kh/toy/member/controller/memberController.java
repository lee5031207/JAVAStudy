package com.kh.toy.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;

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
	private void joinImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String password = request.getParameter("pw");
		String tell = request.getParameter("tell");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		member.setTell(tell);
		member.setEmail(email);
		
		
		memberService.insertMember(member);
		
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
		
		String userId = request.getParameter("id");
		String password = request.getParameter("pw");
		String jsonData = request.getParameter("data"); 
		
		System.out.println(userId);
		System.out.println(password);
		System.out.println("json형식으로 넘어온 데이터 : " + jsonData);
		
		
//		Member member = memberService.memberAuthenticate(userId, password);
//		
//		if(member != null) {
//			//request.getSession().setAttribute("user", member);
//			response.getWriter().print("success");
//		}else {
//			//throw new ToAlertException(ErrorCode.SM02);
//			response.getWriter().print("fail");
//		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect("/index");
	}
	
	private void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp")
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
}
