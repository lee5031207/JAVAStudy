package com.kh.toy.member.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.member.model.vo.Member;

@Mapper
public interface MemberRepository {
	
	@Select("SELECT * FROM TB_MEMBER WHERE USER_ID = #{userId}")
	Member selectMemberById(String userId);
}
