package com.kh.c_collection.d_properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	
	//1. Properties
	// XML파일 입출력을 지원하면서 Key Value의 타입이 String으로 고정된 Map : HashMap이라고 생각
	// Hash Table을 상속 받고 있다.
	
	// XML : Extensible MarkUP Language // 확장 가능한 마크업 언어
	// 마크업언어 : 데이터를 저장하고 전달하기 위해 디자인된 언어
	// 원래 마크업언어 : 미리약속된 tag를 사용해 데이터를 저장하고 식별
	// 			      하지만 XML은 확장 가능한 마크업 언어이기 때문에 미리 지정된 Tag가 없다
	// tag : <a>www.naver.com</a>
	
	// set,put 안쓴다 setProperties , putProperties 쓴다
	public void doProperties() {
		
		Properties prop = new Properties(); //Generic지정이 안된다 String밖에 안들가니까 , 데이터를 주고 받을 목적으로 제작된 것?
		prop.setProperty("DATE","202011101750"); //Properties key,value는 무조건 String이다.
		prop.setProperty("DAY","Tuesday"); //Properties key,value는 무조건 String이다.
		prop.setProperty("Time","17:51"); //Properties key,value는 무조건 String이다.
		
		//데이터 출력
		System.out.println("=============데이터출력==============");
		System.out.println(prop.getProperty("DATE"));
		
		//수정
		System.out.println("=============데이터수정==============");
		prop.setProperty("DATE", "202011111111");
		
		//삭제
		System.out.println("=============데이터삭제==============");
		prop.remove("Time");
		
		//for each 출력
		System.out.println("=============데이터출력==============");
		for(Object e : prop.keySet()) {
			System.out.println(prop.getProperty((String)e));
		}
	}
	
	public void storeToXMLTest() {
		
		Properties prop = new Properties(); //Generic지정이 안된다 String밖에 안들가니까 , 데이터를 주고 받을 목적으로 제작된 것?
		
		prop.setProperty("DATE","202011101750"); //Properties key,value는 무조건 String이다.
		prop.setProperty("DAY","Tuesday"); //Properties key,value는 무조건 String이다.
		prop.setProperty("Time","17:51"); //Properties key,value는 무조건 String이다.
		
		try {
			prop.storeToXML(new FileOutputStream("myFirstXML"), "test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadFromXMLTest() {
		
		Properties prop = new Properties(); //Generic지정이 안된다 String밖에 안들가니까 , 데이터를 주고 받을 목적으로 제작된 것?
		
		try {
			prop.loadFromXML(new FileInputStream("myFirstXML"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Object e : prop.keySet()) {
			System.out.println(prop.getProperty((String)e));
		}
		
	}
}
