package com.kh.jdbc.common.code;

// enum(enumerated type) : 열거형
//						   서로 연관된 상수들의 집합
//  서로 연관된 상수들을 편하게 다루기 위한 enum만의 문법적 형식과
//  메서드를 제공 해준다.

public enum MemberGrade {
	
	//회원 등급 코드, 등급명, 등급별 연장 가능 횟수
	//ex) 회원등급 코드가 ME00이면 등급명은 '일반' 이고, 연장 가능 횟수는 1회이다.
	
	//내부적으로 enum은 class와 다를 바가 없다.
	// public static final MemberGrade Me00 = new MemberGrade("일반",1);
	//어디서든 ME00.메서드명 으로 인스턴스를 생성할 때 매개변수로 넘겼던 값들을 확인할 수 있다.
	
	ME00("일반",1),	
	ME01("성실",2), 
	ME02("우수",3),
	ME03("VIP",4);
	
	//code 등급형
	private String desc;
	//회원 등급별 연장 횟수
	private int extendableCnt;
	
	//접근제한자를 생략한 매개변수가 있는 생성자
	//enum에서 생성자는 default로 private이다
	MemberGrade(String desc, int extendableCnt){
		this.desc = desc;
		this.extendableCnt = extendableCnt;
	}
	
	public String desc() {
		return desc;
	}
	
	public int extendableCnt() {
		return extendableCnt;
	}
	
}
