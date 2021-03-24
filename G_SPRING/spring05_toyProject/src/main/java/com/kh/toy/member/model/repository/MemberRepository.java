package com.kh.toy.member.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.toy.member.model.vo.Member;

@Mapper
public interface MemberRepository {
	
	@Select("SELECT * FROM TB_MEMBER WHERE USER_ID = #{userId}")
	Member selectMemberById(String userId);
	
	@Select("SELECT * FROM TB_MEMBER WHERE USER_ID = #{userId} AND IS_LEAVE = 0")
	Member selecMemberForAuth(String userId);
	
	@Select("SELECT count(*) FROM TB_MEMBER WHERE EMAIL = #{email}")
	int selectMemberByEmail(String email);
	
	@Select("SELECT count(*) FROM TB_MEMBER WHERE TELL = #{tell}")
	int selectMemberByTell(String tell);
	
	@Insert("INSERT INTO TB_MEMBER(USER_ID, PASSWORD, EMAIL, TELL)"
			+ "VALUES (#{userId}, #{password}, #{email}, #{tell})")
	int insertMember(Member member);
	
	@Update("UPDATE TB_MEMBER SET IS_LEAVE = 1 WHERE USER_ID = #{userId}")
	int updateIsLeave(Member member);
}
