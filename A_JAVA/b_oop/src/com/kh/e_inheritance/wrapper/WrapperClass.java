package com.kh.e_inheritance.wrapper;

import java.util.Scanner;

public class WrapperClass {

	//wrapper class : primitive 타입을 객체로 다루기 위해 제공되는 클래스
	//byte -> Byte
	//short -> Short
	//int -> Integer
	//float-> Float
	//double -> Double
	//char -> Character
	//bool -> Boolean
	
	public void printVarSize() {
		//타입의 사이즈
		System.out.println("byte의 크기 : "+ Byte.BYTES+" byte");
		System.out.println("short의 크기 : "+ Short.BYTES+" byte");
		System.out.println("int의 크기 : "+ Integer.BYTES+" byte");
		
		System.out.println("float의 max크기 : "+ Float.MAX_VALUE+" byte");
		System.out.println("double의 max크기 : "+ Double.MAX_VALUE+" byte");
		
		System.out.println("char의 min크기 : "+ Character.MIN_VALUE+" byte");
		System.out.println("bool의 False : "+ Boolean.FALSE);

	}
	
	public void parse() {
		//문자열을 기본 타임으로 변환해주는 메서드
		//parse : 데이터를 변환하는 것
		Scanner sc = new Scanner(System.in);		
		String str= sc.next();
		
		//타입별 파싱 메서드
		byte bnum = Byte.parseByte(str);
		short snum = Short.parseShort(str);
		int inum = Integer.parseInt(str);
		float fnum = Float.parseFloat(str);
		double dnum = Double.parseDouble(str);
		long lnum = Long.parseLong(str);
		
		System.out.println("bnum : "+bnum);
		System.out.println("snum : "+snum);		
		System.out.println("inum : "+inum);
		System.out.println("fnum : "+fnum);
		System.out.println("dnum : "+dnum);
		System.out.println("lnum : "+lnum);
		
		//이걸 알아야 하는 이유 웹에서는 브라우저로 String이 넘어오는데 이걸 용도에 맞게 변환 해 주어야 한다.
		
	}
	
	
	
	
	
}
