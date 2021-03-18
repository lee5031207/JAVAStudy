package com.kh.toy.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.toy.member.model.service.MemberService;
import com.kh.toy.member.model.vo.Member;

//@Controller의 역할
//1. 해당 클래스를 applicationContext에 빈으로 등록
//2. Controller와 관련된 어노테이션을 사용할 수 있게 해준다.

//	@RequestMapping : 컨트롤러의 메서드와 매핑시킬 요청 url을 지정, http method 상관없음
//  @GetMapping : 컨트롤러의 메서드와 매핑시킬 요청 url을 지정 get method만 매핑
//	@PostMapping : 컨트롤러의 메서드와 매핑시킬 요청 url을 지정 post method만 매핑
//	@RequestParam : 요청 파라미터를 컨트롤러 메서드의 매개변수에 바인드
//			FormHttpRequestConverter가 동작, Content-type : form-url-encoded
//			속성 >> name : 요청 파라미터명, 컨트롤러 메서드의 매개변수명과 요청 파라미터명이 같으면 생략 가능
//				   required : 필수 여부 default : true
//				   defaultValue : 파라미터가 없거나 , 빈 값이 넘어왔을 때 세팅할 기본 값
// 	    		   value : name alias, ex)@RequestParam("userId")

//  @RequestBody : json포맷으로 넘어온 요청 바디를 읽어서 자바의 객체에 바인드
//				   MappingJacksonMessageConverter가 동작 Content-type : applicaion/json

//  @ModelAttribute : 요청 파라미터를 VO에 바인드 , VO에 바인드함과 동시에 Model에 VO를 담는다.

//  @RequestHeader : 요청 헤더를 컨트롤러의 매개변수에 바인드
//  @SessionAttribute : 원하는 Session 속성을 컨트롤러의 매개변수에 바인드
//  @CookieValue : 원하는 Cookie의 값을 컨트롤러의 매개변수에 바인드
//  @PathVariable : url 템플릿에 담긴 파라미터 값을 컨트롤러의 매개변수에 바인드
//	@ResponseBody : 컨트롤러의 메서드 위에 작성, 메서드가 반환하는 값을 응답 바디에 직접 넣어준다.

//	***Servlet 객체(HttpServletRequest, HttpServletResponse, HttpSession)들을 컨트롤러 메서드의 매개변수로 전달받을 수 있다.
//	   HttpEntity, RequsetEntity, ResponseEntity 

@Controller
public class MemberController {
	
	
	//Logger logger = LoggerFactory.getLogger(this.getClass());
	Logger logger = LoggerFactory.getLogger(this.getClass());
	//view를 지정하는 방법 3가지 -> 상황에 맞게 편한걸로 써라
	//1. ModelAndView 객체를 만들어서 serViewName 메서드에 view 경로를 지정하고 리턴
	//2. view 경로를 반환(IndexController 에서한 방법)
	//3. 아무것도 반환하지 않을 경우, 요청 url을 view경로로 지정(밑에 member()메서드)
	
	
	MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}


	@GetMapping("member/join")
	public void member() {
		
	};
	
	
	@GetMapping("member/idcheck")
	@ResponseBody
	public String idcheck(String userId) {
		if(memberService.selectMemberById(userId) != null) {
			return "fail";
		}else {
			return "success";
		}
	}
	
	@PostMapping("member/mailauth")
	public String authEmail(Member persistInfo, HttpSession session, Model model) {
		
		//session에 persistInfo 저장
		session.setAttribute("persistInfo", persistInfo);
		//logger.info(session.getAttribute("persistInfo").toString());
		
		//memberService의 authEmail호출해서 회원가입 메일 발송 !Spring MailSender가 있단다 대박!
		memberService.authEmail(persistInfo);
		
		//메일발송 안내창 출력 후 index페이지로 페이지 이동
		model.addAttribute("msg", "이메일 발송이 완료되었습니다.");
		model.addAttribute("url", "/index");
		
		return "common/result";
		
	}
	
	
	
}
