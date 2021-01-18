package com.kh.servlet.filter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//
public class ViewWrapper extends HttpServletRequestWrapper{
	
	HttpServletRequest request;
	
	public ViewWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	//1. method overriding
	public RequestDispatcher getRequestDispatcher(String path) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/"+path+".html");
		return rd;
	}
	
	//2. 원하는 새로운 메서드를 추가
	public void testPclassWrapper() {
		System.out.println("wrapper에서 추가한 메서드를 서블릿에서 호출");
	}
}
