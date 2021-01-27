package com.kh.toy.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;

public class AuthFilter implements Filter {

    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//비로그인 사용자 권한 관리
		//Session의 user 프로퍼티 유무
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		String[] uriArr = httpRequest.getRequestURI().split("/");
		if(uriArr.length > 0) { //분기를 한번 잡아주자
			switch(uriArr[1]) {
			case "member" :
				switch(uriArr[2]) {
				case "mypage" :
					//비로그인 사용자 권한 관리
					//우리가 정의한 예외 이므로 ToAlertException(동작과정중 진짜 예외X)
					if(session.getAttribute("user") == null) {
						throw new ToAlertException(ErrorCode.AUTH01);
					}
					break;
				case "joinimpl" :
					//회원가입 인증 만료
					if(session.getAttribute("persistUser") == null) {
						throw new ToAlertException(ErrorCode.AUTH02);
					}
					break;
				}
			case "board" :
				switch(uriArr[2]) {
				case "form" :
					if(session.getAttribute("user") == null) {
						throw new ToAlertException(ErrorCode.AUTH01);
					}
				case "upload" :
					if(session.getAttribute("user") == null) {
						throw new ToAlertException(ErrorCode.AUTH01);
					}
				}
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
