package com.kh.test;

import java.util.HashSet;

public class CompanyController {

	public static void main(String[] args) {
		
		HashSet<Company> set = new HashSet<>();
		
		set.add(new Company("KH정보교육원", 100));
		set.add(new Company("삼성전자", 200));
		
		System.out.println("값 삽입1 : "+ set);
		
		set.add(new Company("KH정보교육원", 100));
		
		System.out.println("값 삽입2 : "+ set);
		
	}
}
