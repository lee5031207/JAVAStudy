package com.kh.toy.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

//Interceptor는 HandlerInterceptor를 구현해야함 ->Ctrl space눌러 preHandle구현
//권한관리를 위한 Servlet에서 필터 역할을 한다고 보면 된다.
public class AuthInterceptor implements HandlerInterceptor{ 

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String[] uriArr = request.getRequestURI().split("/");
		
		if(uriArr.length > 0) {
			switch (uriArr[1]) {
			case "member":
				switch (uriArr[2]) {
				case "mypage":
					if(session.getAttribute("userInfo") == null) {
						throw new ToAlertException(ErrorCode.AUTH01);
					}
					break;
				case "joinimpl":
					if(session.getAttribute("persistInfo") == null) {
						throw new ToAlertException(ErrorCode.AUTH02);
					}
					break;
				}
				break;
			}
		}
		
		
		return true;
	}
}
