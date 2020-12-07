package com.kh.jdbc.view;

import java.util.Scanner;

import com.kh.jdbc.member.controller.MemberController;
import com.kh.jdbc.member.model.vo.Member;
import com.kh.jdbc.view.book.BookMenu;
import com.kh.jdbc.view.member.MemberMenu;

	//MVC2 모델에서 v는 view를 의미한다
	//VIEW는 사용자에게 데이터를 보여주는 형태와 양식을 의미
public class Index {

	Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	MemberMenu memberMenu = new MemberMenu();
	BookMenu bookMenu = new BookMenu();

	
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
			
			while(true) {
				System.out.println("관리할 메뉴를 선택하세요");
				System.out.println("1. 회원관리");
				System.out.println("2. 도서관리");
				System.out.println("3. 종료");
				System.out.println("입력 : ");
				
				switch (sc.nextInt()) {
				case 1: memberMenu.memberMenu();break;
				case 2: bookMenu.bookMenu();break;
				case 3: return;	
				default: System.out.println("잘못 입력하셨습니다");break;
				}
			}
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
