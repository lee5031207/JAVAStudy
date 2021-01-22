package com.kh.toy.common.code;

public enum ErrorCode {

	
	SM01("회원정보를 조회하는 도중 에러가 발생하였습니다.", "/member/login"),
	SM02("ID 혹은 PW가 틀렸습니다.", "/member/login"),
	IM01("회원정보를 입력하는 도중 에러가 발생하였습니다.", "/member/join"),
	UM01("회원정보를 수정하는 도중 에러가 발생하였습니다."),
	DM01("회원정보를 삭제하는 도중 에러가 발생하였습니다.");
	
	public String errMsg;
	public String url = "/index";
	
	//에러 발생시 index로 이동
	ErrorCode(String errMsg){
		this.errMsg = errMsg;
	}
	
	//에러 발생시 지정한 url페이지로 이동
	ErrorCode(String errMsg,String url){
		this.errMsg = errMsg;
		this.url = url;
	}
}
