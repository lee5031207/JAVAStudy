package com.kh.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cache")
public class E_cache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public E_cache() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ETag : 해당 컨텐츠가 수정된 이력이 있는지 검사할 수 있는 식별자
		// 만약 컨텐츠가 1바이트라도 수정되게 되면 ETag값이 변경
		// 또한 만약 컨텐츠의 내용ㅇ ㅣ수정되지 않더라고, 최종수정일을 변경함녀 ETag값이 변경된다.
		
		//Cache-control 헤더 : 캐시정책을 지정
		// 1. no-store -> 캐시를 저장하지 않는다.
		// 2. no-cache -> 매번 서버에서 해당 자원의 Etag를 확인한다.
		//				  만약 서버자원의 Etag와 캐시 저장소의 Etag가 다르면 자원을 요청하고, 같으면 캐시저장소의 자원을 사용
		// 3. max-age -> 캐시 수명을 지정, 지정한 초가 지나기전에는 서버에 Etag도 확인하지 않는다.
		//				 캐시 수명이 만료되면 no-cache와 동일
		
		response.setHeader("cache-constrol", "no-store");
		response.setHeader("content-disposition", "attachment; filename=Jennie.jpg");
		request.getRequestDispatcher("/resources/img/JENNIE.jpg")
		.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
