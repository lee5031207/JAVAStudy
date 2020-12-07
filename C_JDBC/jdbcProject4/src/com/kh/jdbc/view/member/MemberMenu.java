package com.kh.jdbc.view.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.member.controller.MemberController;
import com.kh.jdbc.member.model.vo.Member;

public class MemberMenu {

	Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	
	public MemberMenu() {
		
	}
	
	public void memberMenu() {
		do {
			System.out.println("\n*** 회원 관리 프로그램 ***");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 새 회원 등록");
			System.out.println("3. 회원 암호 수정");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 회원 검색");
			System.out.println("6. 종료");
			System.out.print("번호 입력==> ");
			
			switch(sc.nextInt()) {
			case 1:
				ArrayList<Member> memberList = memberController.searchAllMember();
				for (Member result : memberList) {
					System.out.println(result);
				}
				break;
			case 2: 
				if(memberController.join(join()) > 0) {
					System.out.println("회원 추가 성공");
				}else {
					System.out.println("회원 추가 실패");
				}
				break;
			case 3:
				Member member = new Member();
				System.out.print("암호를 수정할 아이디를 입력하세요 : ");
				String userId = sc.next();
				System.out.print("수정할 비밀 번호를 입력하세요  : ");
				String password = sc.next();
				member.setUserId(userId);
				member.setPassword(password);
				if(memberController.modify(member) > 0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
				
				break;
			case 4:
				//TB_MEMBER 테이블의 IS_LEAVE 컬럼의 값을 1로 변경하여 탈퇴처리
				//로그인 할 때 IS_LEAVE컬럼의 값이 1이라면 조회되지 않도록 조건절 변경
				//DAO : updateMemberToLeave();
				System.out.print("삭제할 회원의 아이디를 입력하세요 : ");
				String deleteId = sc.next();
				if(memberController.delete(deleteId) > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}				
				break;
			case 5: searchMenu();break;
			case 6: break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요"); 
			}
		}while(true);

	}
	
	public void searchMenu() {
		
		do {
			System.out.println("\n*** 회원 검색 메뉴 ***");
			System.out.println("1.아이디로 검색");
			System.out.println("2.가입 날짜별 검색");
			System.out.println("3.이전 메뉴로 이동");
			System.out.print("번호 입력==> ");
			switch(sc.nextInt()) {
			case 1:
				System.out.print("검색할 아이디 : ");
				String userId = sc.next();
				//MemberController의 searchById 메서드에 사용자가 입력한 userId 전달
				Member member = memberController.searchById(userId);
				if(member != null) {
					//아이디가 존재하면 MemberController가 반환하는 회원 정보 출력
					System.out.println("ID : "+member.getUserId()+" 등급 : "+member.getGrade()+" 이메일  : "+member.getEmail());
				}else {
					//입력한 아이디가 존재하지 않으면 
					// "검색하신 아이디의 회원은 존재하지 않습니다 " 출력
					System.out.println("검색하신 아이디의 회원은 존재하지 않습니다");
				}
				break;
			case 2:
				System.out.print("검색할 가입 시작 날짜 [yyyy-mm-dd] : ");
				String begin = sc.next();
				System.out.print("검색할 가입    끝 날짜 [yyyy-mm-dd] : ");
				String end = sc.next();
				//MemberController의 searchByRegDate 메서드에 입력한
				//시작 날짜와 끝날짜를 전달
				List<Member> memberList = memberController.selectMemberByRegdate(begin, end);			
				//MemverController가 반환하는 member 출력
//				System.out.println(Integer.parseInt(begin.substring(0, 4)));
//				System.out.println(Integer.parseInt(begin.substring(5, 7)));
//				System.out.println(Integer.parseInt(begin.substring(8)));
				if(memberList.isEmpty()) {
					System.out.println("검색한 날짜의 가입한 회원은 없습니다.");
				}else {
					for (Member result : memberList) {
						System.out.println(result);
					}
				}
				break;
			case 3: return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요");				
			}
			
			
		}while(true);
	}
	
	public Member join() {
		Member member = new Member();
		System.out.println("===회원 정보를 입력하세요===");
		System.out.print("아이디 :");
		member.setUserId(sc.next());
		
		System.out.print("비밀번호 :");
		member.setPassword(sc.next());
		
		System.out.print("E-mail :");
		member.setEmail(sc.next());
		
		System.out.print("전화 번호 :");
		member.setTell(sc.next());
		return member;
	}
}
