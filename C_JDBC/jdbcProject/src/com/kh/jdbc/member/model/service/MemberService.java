package com.kh.jdbc.member.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.jdbc.member.model.dao.MemberDao;
import com.kh.jdbc.member.model.vo.Member;

//Service
// 웹어플리케이션의 비지니스 로직 작성
// 사용자가 전송한 데이터를 Controller에게 전달 받고
// 비지니스 로직을 위해 추가적으로 필요한 데이터를 Dao에게 요청해
// 핵심로직인 비지니스 로직을 작성한다.
// 비지니스 로직을 Service가 담당하기 때문에 트랜잭션 관리를 Service가 한다 **

public class MemberService {

	MemberDao memberDao = new MemberDao();
	public MemberService() {
		
	}
	
	public Member memberAuthenticate(String userId, String password) {
		//Dao에게 userId와 password로 식별할 수 있는 회원 정보를,DB에서 조회할 것을 요청
		Member member = memberDao.memberAuthenticate(userId, password);
		return member;
	}
	
	public Member selectMemberById(String userId) {
		Member member = memberDao.selectMemberById(userId);
		return member;
	}
	
	public List<Member> selectMemberByRegdate(Date beginDate, Date endDate){
		List<Member> memberList = memberDao.selectMemberByRegdate(beginDate, endDate);
		return memberList;
	}
	
	public ArrayList<Member> selectMemberList(){
		return new ArrayList<Member>();
	}
	
	public int inserMember(Member member) {
		return 0;
	}
	
	public int updateMember(Member member) {
		return 0;
	}
	
	public int deleteMmeber(String userId) {
		return 0;
	}
	
}
