package com.kh.toy.common.code;

public enum Code {

	//DOMAIN("http://sunguk.com");
	DOMAIN("http://localhost:9090"),
	EMAIL("leetest1207@naver.com");
	
	public String desc;
	
	Code(String desc){
		this.desc = desc;
	}
	
	public String toString() {
		return desc;
	}
	
	
	
}
