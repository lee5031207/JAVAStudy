package com.kh.toy.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.toy.board.model.vo.Board;
import com.kh.toy.common.util.file.FileVo;
import com.kh.toy.common.util.paging.Paging;

@Mapper
public interface BoardRepository {
	
	List<Board> selectBoardList(Paging paging);
	
	@Select("SELECT COUNT(*) FROM TB_BOARD")
	int selectContentCnt();
	
	@Insert("INSERT INTO TB_BOARD(BD_IDX, TITLE, USER_ID, CONTENT) "
			+ "VALUES ('B'||SC_BOARD_IDX.NEXTVAL, #{title}, #{userId}, #{content})")
	int insertBoard(Board board);
	
	int insertFile(FileVo fileVo);
	
}
