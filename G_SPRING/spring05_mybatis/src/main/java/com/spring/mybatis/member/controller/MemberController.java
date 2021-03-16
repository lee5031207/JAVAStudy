package com.spring.mybatis.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller의 역할
//1. 해당 클래스를 applicationContext에 빈으로 등록
//2. Controller와 관련된 어노테이션을 사용할 수 있게 해준다.

@Controller
public class MemberController {
	
	
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	Logger logger = LoggerFactory.getLogger(this.getClass());
	//view를 지정하는 방법 3가지 -> 상황에 맞게 편한걸로 써라
	//1. ModelAndView 객체를 만들어서 serViewName 메서드에 view 경로를 지정하고 리턴
	//2. view 경로를 반환(IndexController 에서한 방법)
	//3. 아무것도 반환하지 않을 경우, 요청 url을 view경로로 지정(밑에 member()메서드)
	
	@GetMapping("member/join")
	public void member() {
		logger.debug("member 메서드 호출");
		logger.warn("나는경고한다");
	};
	
	
	@PostMapping("member/idcheck")
	public void idcheck(String userId) {
		System.out.println("사용자가 파라미터로 넘긴 아이디값 : " + userId);
		logger.info("사용자가 파라미터로 넘긴 아이디값 : " + userId);
	}
	
	
	
}
