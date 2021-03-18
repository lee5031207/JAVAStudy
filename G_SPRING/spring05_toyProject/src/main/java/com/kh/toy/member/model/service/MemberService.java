package com.kh.toy.member.model.service;

import com.kh.toy.member.model.vo.Member;

public interface MemberService {
	
	Member selectMemberById(String userId);
	void authEmail(Member persistUser);
	
}
