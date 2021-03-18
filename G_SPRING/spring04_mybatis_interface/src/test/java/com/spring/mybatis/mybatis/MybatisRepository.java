package com.spring.mybatis.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.mybatis.member.model.vo.Member;

@Mapper
public interface MybatisRepository {

	//동적쿼리가 있으면 mapper에 하자
	//동적쿼리가 없으면 어노테이션으로 하자
	
	
	
	//쿼리가 짧으면 어노테이션으로 해 버리자
	@Select("select * from tb_member where user_id = #{userId}")
	Member selectOne(String userId);
	
	List<Map<String, Object>> selectListReturnedAsMap(String userId);
	
	@Select("select * from tb_member")
	List<Member> selectList();
	
	@Insert("insert into tb_member(user_id,password,tell,email)"
			+ "		values(#{userId},#{password},#{tell},#{email})")
	int insertWithVo(Member member);
	
	@Insert("insert into tb_rent_master(rm_idx,user_id,title,rent_book_cnt)"
			+ " values(sc_rm_idx.nextval,#{member.userId},#{title},#{rentBookCnt})")
	int insertWithMap(Map<String, Object> commandMap);
	
	@Update("update tb_member\r\n"
			+ "		set password = #{password}\r\n"
			+ "		where user_id = #{userId}")
	int update(Member member);
	
	
	void procedure(String bIdx);
	
	
	
	//쿼리가 길다 하면 xml 파일에 만들어 버리자
	Map<String, Object> resultMap(String userId);
	
	Map<String, Object> dynamicQueryIF(Map<String, Object> commandMap);
	Map<String, Object> dynamicQueryChoose(Map<String, Object> commanMap);
	Map<String, Object> dynamicQuerySetTag(Member member);
	Map<String, Object> dynamicQueryWhereAndForeachTag(Map<String, Object> commandMap);
	
}
