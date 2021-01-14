package com.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A_First
 */
@WebServlet("/first")
public class A_First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A_First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 문제 해결
		// 1. request body의 인코딩을 UTF-8로 지정
		request.setCharacterEncoding("UTF-8");
		// 2. response header에 content header를 지정해야함
		response.setHeader("content-type", "text/html; charset=utf-8");
		
		
		// 1. 사용자의 요청을 받아서 파라미터로 넘어온 값을 확인
		String nick = request.getParameter("nick"); //파라미터가 "nick"인 요청을 가져옴
		System.out.println("GET 방식으로 넘어온 값 : "+nick);
		
		// 2. 사용자에게 응답
		// response.getWriter() 메서드를 사용해 response.body를 작성할 수 있는 PrintWriter 객체를 반환받는다.
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Welcome to my Server   "+nick+"</h1>");
		writer.println("<h2>localhost:9090/servlet/first response</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html; charset=utf-8");
		
		String nick = request.getParameter("nick");
		System.out.println("POST 방식으로 넘어온 값 : "+nick);

		PrintWriter writer = response.getWriter();
		writer.println("<h1>Welcome to my Server   "+nick+"</h1>");
		writer.println("<h2>localhost:9090/servlet/first response</h2>");
	}
	
	
}
