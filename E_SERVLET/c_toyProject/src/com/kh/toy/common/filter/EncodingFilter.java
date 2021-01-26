package com.kh.toy.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("EncodingFilter 실행");
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse res = (HttpServletResponse) response;
		
		//모든 요청에 대한 응답헤더가 적용이되기 때문에 정적 리소스인 html이나 css, JS도
		//text/html로 컨텐츠 타입을 가지게 된다. css를 브라우저가 html파일로 인식하기 때문에 css 코드가 정상적으로 동작하지 않게 된다.
		res.setHeader("content-type", "text/html; charset=UTF-8");
		
		// pass the request along the filter chain
		// 다음 filter chain에게 request, response 객체를 전달
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
