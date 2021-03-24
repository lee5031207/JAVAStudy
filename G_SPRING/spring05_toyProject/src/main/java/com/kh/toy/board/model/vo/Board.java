package com.kh.toy.board.model.vo;

import java.sql.Date;

public class Board {

	private String bdIdx;
	private String userId;
	private Date regDate;
	private String title;
	private String content;
	private int isDel;
	
	public Board() {
		
	}
	
	public Board(String bdIdx, String userId, Date regDate, String title, String content, int isDel) {
		super();
		this.bdIdx = bdIdx;
		this.userId = userId;
		this.regDate = regDate;
		this.title = title;
		this.content = content;
		this.isDel = isDel;
	}

	public String getBdIdx() {
		return bdIdx;
	}
	public void setBdIdx(String bdIdx) {
		this.bdIdx = bdIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
	@Override
	public String toString() {
		return "Borad [bdIdx=" + bdIdx + ", userId=" + userId + ", regDate=" + regDate + ", title=" + title
				+ ", content=" + content + ", isDel=" + isDel + "]";
	}
}
