package com.kh.toy.user.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.common.code.Code;
import com.kh.toy.common.mail.MailSender;
import com.kh.toy.user.model.Repository.UserRespository;
import com.kh.toy.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService{

	private final UserRespository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired //servelt-context.xml에 bean 지정
	private RestTemplate http;
	
	@Autowired
	private MailSender mailSender;
	
	
	public UserServiceImpl(UserRespository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User authenticateUser(User user) {
		User userInfo = userRepository.selectUserforAuth(user);
		if(userInfo == null || !passwordEncoder.matches(user.getUserPw(), userInfo.getUserPw())) {
			return null;
		}
		return userInfo;
	}

	@Override
	public void authEmail(User persistInfo, String authPath) {
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
		body.add("userId", persistInfo.getUserId());
		body.add("mail-template", "temp_join");
		body.add("authPath", authPath);
		
		RequestEntity<Map> request = RequestEntity
				.post(Code.DOMAIN+"/mail")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.body(body);
		
		ResponseEntity<String> response =
				http.exchange(request, String.class);
		
		
		mailSender.send(persistInfo.getUserEmail(), persistInfo.getUserId()+"님 회원가입을 완료해주세요!", response.getBody());
		
	}

}
