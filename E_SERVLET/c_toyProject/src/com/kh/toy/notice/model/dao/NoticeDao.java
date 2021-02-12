package com.kh.toy.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.toy.common.template.JDBCTemplate;
import com.kh.toy.common.template.LocalJDBCTemplate;
import com.kh.toy.notice.model.vo.Notice;

import oracle.jdbc.proxy.annotation.Pre;

public class NoticeDao {

	LocalJDBCTemplate ljdt = LocalJDBCTemplate.getInstance();
	
	
	public ArrayList<Notice> getNoticeList(Connection conn, int start, int end){
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = 
				  "SELECT * FROM ("
				+ "    SELECT ROWNUM NUM, B.*"
				+ "        FROM (SELECT * FROM TB_BOARD WHERE IS_DEL = 0 ORDER BY REG_DATE DESC) B"
				+ ") WHERE NUM BETWEEN ? AND ?";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, start);
			pstm.setInt(2, end);
			rset = pstm.executeQuery();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setBdIdx(rset.getString("BD_IDX"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setRegDate(rset.getDate("REG_DATE"));
				notice.setTitle(rset.getString("TITLE"));
				notice.setContent(rset.getString("CONTENT"));
				notice.setCnt(rset.getInt("CNT"));
				noticeList.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ljdt.close(rset, pstm);
		}
		return noticeList;
	}
	
	
	public int getnoticeCnt(Connection conn) {
		int allNoticeCnt = 0;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) FROM TB_BOARD";
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			if(rset.next()) {
				allNoticeCnt = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allNoticeCnt;
	}
}
