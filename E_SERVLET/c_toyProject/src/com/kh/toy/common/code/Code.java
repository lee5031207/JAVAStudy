package com.kh.toy.common.code;

public enum Code {

	//DOMAIN("http://sunguk.com");
	DOMAIN("http://localhost:9090"),
	EMAIL("leetest1207@naver.com"),
	UPLOAD("C:\\Users\\20151\\git\\JAVAStudy\\E_SERVLET\\resources\\upload\\");
	
	public String desc;
	
	Code(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}
	
	
	
}
