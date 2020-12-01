package com.kh.jdbc.member.view;

import java.util.Scanner;

import com.kh.jdbc.member.controller.MemberController;
import com.kh.jdbc.member.model.vo.Member;

	//MVC2 모델에서 v는 view를 의미한다
	//VIEW는 사용자에게 데이터를 보여주는 형태와 양식을 의미
public class Index {

	Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	MemberMenu memberMenu = new MemberMenu();

	
	public Index() {
		
	}
	
	public void startMenu() {
		System.out.println("로그인 하세요. ");
		System.out.print("아이디 : ");
		String userId = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		//사용자가 입력한 아이디와 암호로 식별되는 회원 정보를
		//MemberController에게 요청
		Member member = memberController.login(userId, password);
		if(member != null) { //반환 받은 회원 정보가 존재하면
			System.out.println(member.getUserId() + "님 환영합니다");
			memberMenu.memberMenu();
		}else { 		//반환 받은 회원 정보가 존재하지 않는다면
			System.out.println("아이디나 암호를 확인하시오");
		}
	}
	
	public void memberMenu() {
		
	}
	
	public void searchMenu() {
		
	}
	
	public Member join() {
		return new Member();
	}
	
	
}
