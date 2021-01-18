package com.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class C_Response extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public C_Response() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Content-Disposition 헤더 : 응답이 브라우저 화면에 출력되어야 하는지, 사용자의 컴퓨터에 다운로드 되어야 하는지
		//Content-Disposition = inline: 기본 값, 브라우저 화면에 응답바디의 데이터를 출력
		//						attachment;  [filename=파일명]: 응답 바디의 데이터를 다운로드 받는다
		response.setHeader("content-Disposition", "attachment; filename = responseStudy.html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>getWriter :response body에 문자 데이터 작성</h1>");
		pw.println("<h1>getOutpustStream : response body에 데이터 작성하는 Stream</h1>");
		pw.println("<h1>sendRedirect : 응답코드 302와 브라우저가 재요철할 URL응답</h1>");
									
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
