package com.kh.toy.member.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.vo.Member;

import common.code.Code;
import common.mail.MailSender;

@Service
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	
	@Autowired
	private RestTemplate http;
	@Autowired
	private MailSender mailSender;
	
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	@Override
	public Member selectMemberById(String userId) {
		return memberRepository.selectMemberById(userId);
	}
	
	public void authEmail(Member persistUser) {
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
		body.add("userId", persistUser.getUserId());
		body.add("mail-template", "temp_join");
		
		RequestEntity<Map> request = RequestEntity
				.post(Code.DOMAIN+"/mail")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.body(body);
				
		ResponseEntity<String> response =
				http.exchange(request, String.class);
		
		mailSender.send(persistUser.getEmail(), persistUser.getUserId()+"님 회원가입을 완료해주세요!", response.getBody());
		System.out.println("mailSender아래에 작성한 출력문");
	}

}
