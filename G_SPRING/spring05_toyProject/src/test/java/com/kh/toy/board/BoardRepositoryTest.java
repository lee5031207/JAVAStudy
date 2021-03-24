package com.kh.toy.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.toy.board.model.repository.BoardRepository;
import com.kh.toy.board.model.vo.Board;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"}) 
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repo;
	
	@Test
	public void insertBoardTest() {
		Board board = new Board();
		board.setTitle("더미 데이터");
		board.setContent("내용입니다");
		board.setUserId("lee5031207");
		
		repo.insertBoard(board);
	}
}
