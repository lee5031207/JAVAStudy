package com.kh.toy.user.model.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.user.model.vo.User;

@Mapper
public interface UserRespository {

	@Select("SELECT * FROM TB_USER WHERE USER_ID = #{userId} AND USER_LEAVE_DATE IS NULL")
	User selectUserforAuth(User user);
	
	@Select("SELECT count(*) FROM TB_USER WHERE USER_EMAIL = #{userEmail}")
	int selectUserByEmail(String userEmail);
	
	@Select("SELECT count(*) FROM TB_USER WHERE USER_PHONE = #{userPhone}")
	int selectUserByTell(String userPhone);
}
