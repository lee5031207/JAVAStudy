package com.kh.toy.notice.controller;

public class tesese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=76; i<=120; i++) {
			System.out.println("INSERT INTO TB_BOARD (BD_IDX, USER_ID, REG_DATE, TITLE, CONTENT) VALUES ('"+i+"','이성욱', SYSDATE+3,'게시판 만들기 테스트"+i+"','게시판 만들기 테스트 내용"+i+"');");
		}
	}

}
