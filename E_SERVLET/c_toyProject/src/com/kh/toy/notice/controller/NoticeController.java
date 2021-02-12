package com.kh.toy.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.notice.model.service.NoticeService;
import com.kh.toy.notice.model.vo.Notice;


@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	NoticeService noticeService = new NoticeService();
       
    public NoticeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String[] uriArr = request.getRequestURI().split("/");
		
		switch (uriArr[uriArr.length-1]) {
		case "noticeList" : noticeList(request,response); break;
		default : response.setStatus(404);break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void noticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. 사용자가 클릭한 페이지를 가져온다
		int page = 0;
		if(request.getParameter("page") == "" || request.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int start = 0, end = 0;
		int firstPage = 0, lastPage = 0;
		ArrayList<Integer> pageList = null;
		
		//2. 우리 게시글의 전체 페이지 개수를 구한다. ex. 게시글이 36개이면 총 4개의 페이지를 보여줄 수 있다.
		int allNoticeCnt = noticeService.getnoticeCnt();
		int allPageCnt = 0;
		if(allNoticeCnt%10==0) {
			allPageCnt = allNoticeCnt/10; 
		}else {
			allPageCnt = (allNoticeCnt/10)+1;
		}
		
		//3. 사용자가 접근한 페이지가 전체페이지보다 많거나 1보다 작다면 -> 예외처리
		ArrayList<Notice> noticeList = null;
		if(page>allPageCnt || page<1) {
			System.out.println("잘못된 접근입니다");
		}else {
			// 3-1. 사용자가 클릭한 페이지의 NoticeList를 가져온다 
			//      ex) 1페이지 : 가장최신글 10개 , 2페이지 : 가장최신글 10개를 뺀 10개
			start = 1+(page-1)*10;
			end = page*10;
			noticeList = noticeService.getNoticeList(start, end);
			
			
			// 3-2. 사용자가 만약 2페이지를 클릭하고 있다면 1~5를 보여주고 7페이지를 클릭하고 있다면 6~10을 보여줘여함
			// 3-2-1. 사용자가 볼 수 있는 첫번째 페이지, 마지막 페이지를 지정
			for(int i=page; i<= allPageCnt; i++) {
				if(i%5==0) {
					lastPage = i;
					firstPage = i-4;
					break;
				}else {
					lastPage = allPageCnt;
					firstPage = lastPage - ((lastPage%5)-1); 
				}
			}
			
			//3-2-2. 구한 페이지를 pageList에 넣어줌
			pageList = new ArrayList<Integer>();
			for(int i=firstPage; i<=lastPage; i++) {
				pageList.add(i);
			}
			
		}
		
		
		
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("firstPage", firstPage);
		request.setAttribute("pageList", pageList);
		request.setAttribute("noticeList", noticeList);
		request.getRequestDispatcher("/WEB-INF/view/notice/noticeView.jsp")
		.forward(request, response);
	}

}
