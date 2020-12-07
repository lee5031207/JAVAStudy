package com.kh.jdbc.book.model.vo;

import java.sql.Date;

public class RentBook {

	private int rbIdx;
	private int rmIdx;
	private int bidx;
	private Date regDate;
	private String state;
	private Date returnDate;
	private int extentionCnt;
	
	
	public RentBook() {
		
	}
	
	public int getRbIdx() {
		return rbIdx;
	}
	public void setRbIdx(int rbIdx) {
		this.rbIdx = rbIdx;
	}
	public int getRmIdx() {
		return rmIdx;
	}
	public void setRmIdx(int rmIdx) {
		this.rmIdx = rmIdx;
	}
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getExtentionCnt() {
		return extentionCnt;
	}
	public void setExtentionCnt(int extentionCnt) {
		this.extentionCnt = extentionCnt;
	}
	@Override
	public String toString() {
		return "RentBook [rbIdx=" + rbIdx + ", rmIdx=" + rmIdx + ", bidx=" + bidx + ", regDate=" + regDate + ", state="
				+ state + ", returnDate=" + returnDate + ", extentionCnt=" + extentionCnt + "]";
	}
	
	
}
