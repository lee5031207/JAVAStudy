package com.kh.jdbc.member.controller;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.kh.jdbc.member.model.service.MemberService;
import com.kh.jdbc.member.model.vo.Member;

//Controller
//사용자의 요청을 받아 해당 요청을 수행할 Service의 메서드를 호출
//사용자가 보낸 데이터를 Application 내부에서 사용하기 적합하게 가공
//  따라서, 사용자가 보내는 데이터릐 형식이 바뀌더라도 Model의 코드가 변경될 일은 없어야 한다.
//  적합하지 않은 요청에 대해서는 허가/불가 처리를 하는 외벽 역할(권한관리)
//Service에서 사용자의 요청을 처리해 결과를 반환하면 ,
//  Controller는 사용자에게 어떤 view를 보여줄 지를 선택

public class MemberController {

	private MemberService memberService = new MemberService();
	public MemberController() {
		
	}
	
	public Member login(String userId, String password) {
		Member member = memberService.memberAuthenticate(userId, password);
		
		return member;
	}
	
	public Member searchById(String userId) {
		Member member = memberService.selectMemberById(userId);
		return member;
	}
	
	public ArrayList<Member> searchAllMember(){
		return new ArrayList<Member>();
	}
	
	public int join(Member member) {
		return 0;
	}
	
	public int modify(Member member) {
		return 0;
	}
	
	public int delete(String text) {
		return 0;
	}
	
	public List<Member> selectMemberByRegdate(String begin, String end){ //yyyy-mm-dd
		//begin.substring(0, 4), begin.substring(5, 7), begin.substring(8)
		//Date beginDate = new Date(Integer.parseInt(begin.substring(0, 4)), Integer.parseInt(begin.substring(5, 7)), Integer.parseInt(begin.substring(8)));
		//Date endDate = new Date(Integer.parseInt(end.substring(0, 4)), Integer.parseInt(end.substring(5, 7)), Integer.parseInt(end.substring(8)));
		Date beginDate = Date.valueOf(begin);
		Date endDate = Date.valueOf(end);
		List<Member> memberList = memberService.selectMemberByRegdate(beginDate, endDate);
		return memberList;
	}
	
	
	
}
