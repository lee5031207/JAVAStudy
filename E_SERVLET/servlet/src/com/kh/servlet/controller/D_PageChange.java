package com.kh.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/page/*")
public class D_PageChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public D_PageChange() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String[] uriArr = uri.split("/");
		
		switch (uriArr[uriArr.length -2]) {
		case "forward" :
			if(uriArr[uriArr.length -1].equals("name")) {
				forwardName(request, response);
			}else if(uriArr[uriArr.length -1].equals("image")) {
				forwardImage(request, response);
			}else {
				sendError(request, response);
			}
			break;
		case "redirect" :
			if(uriArr[uriArr.length -1].equals("name")) {
				redirectName(request, response);
			}else if(uriArr[uriArr.length -1].equals("image")) {
				redirectImage(request, response);
			}else {
				sendError(request, response);
			}
			break;
		default : 
			sendError(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void forwardName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request Scope : 요청이 발생한 시점에 객체가 생성되어 응답이 마무리 되는 시점에 객체가 소멸하는 스코프
		// ex) HttpServletRequest, HttpServletResponse 객체가 Request Scope를 가지고 있음
		
		//RequestDispatcher.forward() : 요청을 재지정 해주는 메서드
		//    /servlet/page/forward/name 으로 넘어온 요청을 재지정 하여 해당 요청을  /servlet/page/impl 로 내부에서 재지정
		
		RequestDispatcher view = request.getRequestDispatcher("/page/impl");  //요청을 재 지정한 것
		view.forward(request, response); // 받은 요청 객체와 응답 객체를 함께 넘겨준다
	}
	
	private void forwardImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//해당 메서드로 들어온 요청을 /resources/img/JENNIE.jpg로 재지정 
		response.setHeader("content-Disposition", "attachment; filename = JEN.jpg");
		request.getRequestDispatcher("/resources/img/JENNIE.jpg").forward(request, response);
	}
	
	private void redirectName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Response.sendRedirect() : 요청을 재 요청
		
		//브라우저가 재요청할 url을 매개변수로 넘겨주기 때문에
		//context path가 반드시 필요, 브라우저는 우리의 웹어플리케이션으로 접근하기 위해
		//context path가 필요하기 때문
		response.sendRedirect("/servlet/page/impl");
	}
	
	private void redirectImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-Disposition", "attachment; filename = JEN.jpg");
		response.sendRedirect("/servlet/resources/img/JENNIE.jpg");
	}
	
	//404에러처리
	private void sendError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(404);
	}

}
