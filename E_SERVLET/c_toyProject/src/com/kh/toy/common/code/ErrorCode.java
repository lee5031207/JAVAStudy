package com.kh.toy.common.code;

public enum ErrorCode {

	
	SM01("회원정보를 조회하는 도중 에러가 발생하였습니다.", "/member/login"),
	SM02("ID 혹은 PW가 틀렸습니다.", "/member/login"),
	IM01("회원정보를 입력하는 도중 에러가 발생하였습니다.", "/member/join"),
	UM01("회원정보를 수정하는 도중 에러가 발생하였습니다."),
	DM01("회원정보를 삭제하는 도중 에러가 발생하였습니다."),
	IB01("게시판 정보를 입력하는 중 에러가 발생하였습니다.", "/index"),
	SB01("게시판 정보를 조회하는 중 에러가 발생하였습니다."),
	IF01("파일 정보를 입력하는 중 에러가 발생하였습니다.", "/index"),
	SF01("파일 정보를 조회하는 중 에러가 발생하였습니다."),
	AUTH01("접근 권한이 없는 페이지 입니다."),
	AUTH02("인증 기간이 만료 되었습니다"),
	MAIL01("이메일 발송 중 에러가 발생하였습니다"),
	HTTP01("Http 통신 중 에러가 방생하였습니다"),
	CD_404("존재하지 않는 경로 입니다");
	
	
	
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
