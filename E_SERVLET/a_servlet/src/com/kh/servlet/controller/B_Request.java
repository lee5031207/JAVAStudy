package com.kh.servlet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 1) * : ALL(모든)
// 		  ex ) /request/*

// 2) *.확장자 : 확장자 매칭
//        ex ) /request/*.com : .com으로 URI가 씉나는 모든 요청을 해당 서블릿으로 받겠다

// 3) / : default 서블릿, 서블릿에 지정되지 않은 모든 요청을 처리

@WebServlet("/request/*")
public class B_Request extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
    public B_Request() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String[] uriArr = uri.split("/");
		
		//URI의 마지막 요소를 비교해 
		switch(uriArr[uriArr.length -1]) {
		case "get" :
			testGet(request, response); break;
		case "post" :
			testPost(request, response); break;
		case "multi" :
			testMulti(request, response);break;
		default : sendError(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); //POST로 들어온 요청은 doGet()메서드로 실행
	}
	
	private void testGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//이름, 나이를 전달 받아 사용자의 10년뒤 나이를 구해주자
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter pw = response.getWriter();
		
		// ==========SessionTest========== //
		HttpSession session = request.getSession();
		pw.println("<h1>"+session.getAttribute("nick")+"님</h1>");
		pw.println("<a href='/servlet/session/logout'>logout</a>");
		// ==========SessionTest========== //


		
		pw.println("<h2>이름 : "+name+" /  나이 :"+age+"</h2>");
		pw.println("<h2>10년뒤 나이는 "+(age+10)+"세 입니다.</h2>");
		
		
	}
	
	private void testPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//이름, 나이를 전달 받아 사용자의 10년뒤 나이를 구해주자
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		PrintWriter pw = response.getWriter();
		pw.write("<h2>이름 : "+name+" /  나이 :"+age+"</h2>");
		pw.write("<h2>10년뒤 나이는 "+(age+10)+"세 입니다.</h2>");
	}
	
	private void testMulti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// enctype = "multipart/form-data" 이면 getParameter로 받을 수 없다
		// String name = request.getParameter("name");
		// String file = request.getParameter("file");
		// -> 직접 request body에 있는 값을 읽어온다
		InputStream is = null;
		OutputStream os = null;
		String root = getServletContext().getRealPath("/");
		try {
			is = request.getInputStream();
			os = new FileOutputStream(new File(root + "multipart.txt"));
			int check = 0 ;
			while((check=is.read()) != -1) {
				os.write(check);
			}
		}finally {
			os.close();
			is.close();
		}	
	}
	
	private void sendError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//response 응답코드 지정
		response.setStatus(404);
	}
	
}

