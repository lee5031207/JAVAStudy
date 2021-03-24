package com.kh.toy.member.model.service;

import org.apache.ibatis.annotations.Select;

import com.kh.toy.member.model.vo.Member;

public interface MemberService {
	
	Member selectMemberById(String userId);

	Member authenticateUser(Member member);
	
	void authEmail(Member persistUser, String authPath);
	
	int insertMember(Member member);
	
	int leaveMember(Member member);
	
	
}
