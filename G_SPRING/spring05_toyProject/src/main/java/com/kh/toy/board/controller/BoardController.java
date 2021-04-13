package com.kh.toy.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.toy.board.model.service.BoardService;
import com.kh.toy.board.model.vo.Board;
import com.kh.toy.common.code.Code;
import com.kh.toy.member.model.vo.Member;

@Controller
@RequestMapping("board")
public class BoardController {

	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("list")
	public String boardList(@RequestParam(defaultValue = "1") int page, Model model) {
		model.addAllAttributes(boardService.selectBoardList(page));
		return "board/boardList";
	}
	
	@GetMapping("form")
	public String boardForm() {
		return "board/boardForm";
	}
	
	@PostMapping("upload")
	public String uploadBoard(@RequestParam List<MultipartFile> files 
			,@SessionAttribute(name="userInfo", required = false) Member member //required = false -> 필수값아니다
			,Board board) {
		
		// System.out.println(files); : [MultipartFile[field="files", filename=개발자 로드맵.jpg, contentType=image/jpeg, size=3058019]]
		// System.out.println(board); : Borad [bdIdx=null, userId=null, regDate=null, title=sd, content=sds, isDel=0]
		
		String userId = member == null ? "guest":member.getUserId();
		board.setUserId(userId);
		boardService.insertBoard(board, files);
		
		return "redirect:/board/list";
	}

}
