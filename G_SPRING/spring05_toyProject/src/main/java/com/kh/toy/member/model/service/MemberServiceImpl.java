package com.kh.toy.member.model.service;

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
import com.kh.toy.member.model.repository.MemberRepository;
import com.kh.toy.member.model.vo.Member;

@Service //비지니스로직?
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;
	
	@Autowired //servelt-context.xml에 bean 지정
	private RestTemplate http;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}


	@Override
	public Member selectMemberById(String userId) {
		return memberRepository.selectMemberById(userId);
	}
	
	public void authEmail(Member persistUser, String authPath) {
		
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
		body.add("userId", persistUser.getUserId());
		body.add("mail-template", "temp_join");
		body.add("authPath", authPath);
		
		RequestEntity<Map> request = RequestEntity
				.post(Code.DOMAIN+"/mail")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.body(body);
				
		ResponseEntity<String> response =
				http.exchange(request, String.class);
		
		mailSender.send(persistUser.getEmail(), persistUser.getUserId()+"님 회원가입을 완료해주세요!", response.getBody());
		//System.out.println("mailSender아래에 작성한 출력문");
	}


	@Override
	public int insertMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepository.insertMember(member);
	}


	@Override
	public Member authenticateUser(Member member) {
		Member userInfo = memberRepository.selecMemberForAuth(member.getUserId());
		if(userInfo == null || !passwordEncoder.matches(member.getPassword(), userInfo.getPassword())) {
			return null;
		}
		return userInfo;
	}


	@Override
	public int leaveMember(Member member) {
		return memberRepository.updateIsLeave(member);
	}


}
