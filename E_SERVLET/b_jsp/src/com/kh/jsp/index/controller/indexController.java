package com.kh.jsp.index.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public indexController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request에 jsp태그들을 담아서 index.jsp로 요청을 재지정
		request.setAttribute("지시자태그", "<%@ %>");
		request.setAttribute("선언태그", "<%! %>");
		request.setAttribute("스크립틀릿태그", "<% %>");
		request.setAttribute("표현식태그", "<%= %>");
		
		//요청 재지정
		request.getRequestDispatcher("/WEB-INF/view/index.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
