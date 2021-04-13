package com.kh.toy.user.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.toy.user.model.service.UserService;
import com.kh.toy.user.model.vo.User;
import com.kh.toy.user.validator.UserValidator;

@Controller //데이터 가공, 검증, 권한
@RequestMapping("user")
public class UserController {

	UserService userService;
	UserValidator userValidator;
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userValidator); //컨트롤러 메서드의 파라미터에 데이터를 bind해주는 역할 수행
	}

	@GetMapping("login")
	public void login() {
		// 아무것도 반환하지 않은다 그럼 user/login 으로 요청이 올 경우
		// user/login.jsp 로 이동 시키는 것
	};
	
	@PostMapping("loginimpl")
	@ResponseBody //컨트롤러의 메서드 위에 작성, 메서드가 반환하는 값을 응답 바디에 직접 넣어줌
	public String loginImpl(@RequestBody User user, HttpSession session) { //@RequestBody : JSON 포맷으로 넘어온 요청 바디를 읽어서 자바의 객체에 바인드  
		User userInfo = userService.authenticateUser(user);
		if(userInfo==null) {
			return "fail";
		}
		session.setAttribute("userInfo", userInfo);
		return "success";
	}
	
	@GetMapping("join")
	public void join() {
		
	}
	
	@PostMapping("mailauth")
	public String authEmail(@Valid User persistInfo, Errors error, HttpSession session ) {
		
		if(error.hasErrors()) {
			return "user/join";
		}
		String authPath = UUID.randomUUID().toString();
		
		//session에 persistInfo 저장
		session.setAttribute("persistInfo", persistInfo);
		session.setAttribute("authPath", authPath);
		
		userService.authEmail(persistInfo, authPath);
		
		return null;
		
	}
	
	
}
