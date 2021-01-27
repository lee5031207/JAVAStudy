package com.kh.toy.common.util.file;

import java.sql.Date;

public class FileVo {

	private int fIdx;
	private String typeIdx;
	private String originFileName;
	private String renameFileName;
	private String savePath;
	private Date regDate;
	private int  isDel;
	
	public int getfIdx() {
		return fIdx;
	}
	public void setfIdx(int fIdx) {
		this.fIdx = fIdx;
	}
	public String getTypeIdx() {
		return typeIdx;
	}
	public void setTypeIdx(String typeIdx) {
		this.typeIdx = typeIdx;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originalFileName) {
		this.originFileName = originalFileName;
	}
	public String getRenameFileName() {
		return renameFileName;
	}
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
	@Override
	public String toString() {
		return "FileVo [fIdx=" + fIdx + ", typeIdx=" + typeIdx + ", originalFileName=" + originFileName
				+ ", renameFileName=" + renameFileName + ", savePath=" + savePath + ", regDate=" + regDate + ", isDel="
				+ isDel + "]";
	}
	
	
	
	
	
}
