package com.kh.toy.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.toy.common.exception.DataAccessException;
import com.kh.toy.common.exception.ToAlertException;
import com.kh.toy.common.template.JDBCTemplate;
import com.kh.toy.common.template.LocalJDBCTemplate;
import com.kh.toy.notice.model.dao.NoticeDao;
import com.kh.toy.notice.model.vo.Notice;

public class NoticeService {

	LocalJDBCTemplate ljdt = LocalJDBCTemplate.getInstance();
	NoticeDao noticeDao = new NoticeDao();
	
	public ArrayList<Notice> getNoticeList(int start, int end){
		
		Connection conn = ljdt.getConnection();
		ArrayList<Notice> noticeList = null;
		
		try {
			noticeList = noticeDao.getNoticeList(conn, start, end);
			ljdt.commit(conn);
		} catch (DataAccessException e){
			ljdt.rollback(conn);
			throw new ToAlertException(e.error, e);
		}finally {
			ljdt.close(conn);
		}
		return noticeList;
	}
	
	public int getnoticeCnt() {
		Connection conn = ljdt.getConnection();
		int allNoticeCnt = 0;
		try {
			allNoticeCnt = noticeDao.getnoticeCnt(conn);
			ljdt.commit(conn);
		} catch (DataAccessException e){
			ljdt.rollback(conn);
			throw new ToAlertException(e.error, e);
		}finally {
			ljdt.close(conn);
		}
		return allNoticeCnt;
	}
	
}
