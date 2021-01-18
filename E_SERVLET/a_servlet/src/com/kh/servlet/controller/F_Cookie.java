package com.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cookie")
public class F_Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public F_Cookie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자가 검색한 내용을 찾아옴
		String search = request.getParameter("search");
		//이전 검색어를 미리 초기화
		String prevSearch = "최근 검색어가 없습니다";
		
		//사용자가 검색한 프로그래밍 언어를 쿠키에 저장
		//set-cookie : 헤더에 쿠키를 추가하기 위한 header, 키=값 형태
		//같은 키에 값을 담으면 덮어써진다
		
		// Max-Age : 쿠키의 수명을 초단위 지정
		// Path : 어떤 경로로 요청을 할 때 클라이언트가 해당 쿠키를 헤더에 담어서 보내야 할지 지정
		
		// path = /servlet/cache : 브라우저가 /servlet/cache로 요청할때 헤더에 cookie를 담아서 보낸다.
		// max-age = 20 : 20초동안 쿠키 유지, 기본값 : session 브라우저가 종료되면 쿠키도 같이 삭제
		
		response.setHeader("set-cookie", "prevSearch="+search);
		
		//클라이언트의 요청헤더에 담겨온 pervSearch 쿠키를 확인
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("쿠키 값 :"+cookie.getValue());
				if(cookie.getName().equals("prevSearch")) { 
					prevSearch = cookie.getValue();
				}
			}
		}

		
		
		PrintWriter pw = response.getWriter();
		
		// ==========SessionTest========== //
		HttpSession session = request.getSession();
		pw.println("<h1>"+session.getAttribute("nick")+"님</h1>");
		pw.println("<a href='/servlet/session/logout'>logout</a>");
		// ==========SessionTest========== //
		
		
		pw.println("<h1>검색결과</h1>");
		pw.println("<h2>이전 검색어 : "+prevSearch+"</h2>");
		
		switch(search) {
		case "java" :
			pw.println("<h2>자바는 객체지향 프로그래밍 언어입니다</h2>");
			break;
		case "oracle" :
			pw.println("<h2>오라클은 DBMS입니다. SQL을 사용해 질의합니다</h2>");
			break;
		case "html" :
			pw.println("<h2>HTML은 웹페이지 제작을 위한 마크업 언어 입니다</h2>");
			break;
		case "css" :
			pw.println("<h2>CSS는 스타일 시트입니다</h2>");
			break;
		case "javascript" :
			pw.println("<h2>자바스크립트는 동적 웹페이지 제작을 위해 사용합니다</h2>");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
