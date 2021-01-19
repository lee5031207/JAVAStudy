package com.kh.toy.common.code;

public enum RentState {

	RE00("대출"),
	RE01("연장"),
	RE02("연체"),
	RE03("반납");
	
	private String state;
	
	RentState(String state){
		this.state = state;
	}
	
	public String state() {
		return state;
	}
}
