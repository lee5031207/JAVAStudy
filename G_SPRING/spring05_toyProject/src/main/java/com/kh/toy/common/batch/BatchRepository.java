package com.kh.toy.common.batch;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchRepository {

	@Insert("INSERT INTO TB_BASEBALL (RANK, TEAM_NAME, MATCH, WIN, LOOSE, TIE, RATE) VALUES "
			+ "(#{rank}, #{teamName}, #{match}, #{win}, #{loose}, #{tie}, #{rate})")
	int insertBaseBall(Map<String, String> commandMap);
}
