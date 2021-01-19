package com.kh.toy.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		int res = memberService.insertMember(member);
		if(res > 0) {
			//성공
			request.getRequestDispatcher("/WEB-INF/view/member/join_complete.jsp")
			.forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/view/member/join_fail.jsp")
			.forward(request, response);
			//실패
		}		
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp")
		.forward(request, response);
	}
	
	private void loginImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String password = request.getParameter("pw");
		
		Member member = memberService.memberAuthenticate(userId, password);
		if(member != null) {
			//session에 회원 정보를 저장
			request.getSession().setAttribute("user", member);
			response.sendRedirect("/index");
		}else {
			request.getRequestDispatcher("/WEB-INF/view/member/login_fail.jsp")
			.forward(request, response);
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
}
