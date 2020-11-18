package skillup.day03.library.view;

import java.util.Scanner;

import skillup.day03.library.controller.LibraryManager;
import skillup.day03.library.model.vo.Book;
import skillup.day03.library.model.vo.Member;

public class LibraryMenu {

	private LibraryManager lm = new LibraryManager();
	Scanner sc = new Scanner(System.in);
	
	public LibraryMenu() {
			
	}
	public void mainMenu() {
		//회원 이름, 나이, 성별을	입력 받아 Member 객체를 생성하 고 lm의 insertMember() 메소드로
		//생성된 회원 객체의 주소 값 전달, 무한 반복 메뉴 출력하여 각 메뉴버튼 클릭 시 해당하는 메소드 호출
		Member mem = new Member();
		
		System.out.print("이름을 입력하시오 : " );
		mem.setName(sc.next());
		System.out.print("나이을 입력하시오 : " );
		mem.setAge(sc.nextInt());
		System.out.print("성별(F/M)을 입력하시오 : " );
		mem.setGender(sc.next().charAt(0));
		
		lm.insertMember(mem);
		
		boolean roop = true;
		while(roop) {
			System.out.println("===메뉴===");
			System.out.println("1.마이페이지");
			System.out.println("2.도서 전체 조회");
			System.out.println("3.도서 검색");
			System.out.println("4.도서 대여하기");
			System.out.println("5.프로그램 종료하기");
			
			int inputNum = sc.nextInt();
			switch(inputNum) {
			case 1:	lm.myPage(); break;
			case 2: selectAll();  break;
			case 3: searchBook(); break;
			case 4: rentBook(); break;
			case 5: roop=false;
			}
		}
	}
	
	public void selectAll() {
		//lm의 selectAll() 메소드 호출 결과 값을 Book[] 자료형으로
		//받아준 뒤 for문을 이용하여 도서 전체 목록 출력
		Book[] bList = lm.selectAll();
		
		for(int i=0; i<bList.length; i++) {
			System.out.println(i+"번 도서 " + bList[i].toString());
		}
		
	}
	
	public void searchBook() {
		//검색할 키워드 값을 입력 받고 그입력 받은 키워드를 lm의 searchBook() 메소드로 전달
		//결과 값을 Book[] 자료형으로 받아 for문을 이용하여 출력
		System.out.print("검색한 제목의 키워드 입력: ");
		String keyword = sc.next();
		
		Book[] searchList = lm.searchBook(keyword);
		if(searchList.length == 0) {
			System.out.println("찾으시는 키워드가 없습니다");
		}
		for(int i=0; i<searchList.length; i++) {
			System.out.println(searchList[i].toString());
		}
		
	}
	
	public void rentBook() {
		//대여할 도서 인덱스를 입력 받아 lm의 rentBook() 메소드로 전달 
		//결과 값을 result로 받아 result가 0일 경우, 1일 경우, 2일 경우 각각에 해당하는 출력문 출력
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		boolean roop = true;
		
		while(roop) {
			if(index>4 || index<0) {
				System.out.println("잘못된 인덱스를 선택하셨습니다.");
				System.out.print("다시 입력해주세요 : ");
				index = sc.nextInt();	
			}else if(index<=4) {
				roop = false;
			}
		}
		
		int result = lm.rentBook(index);
		switch(result) {
		case 0 : System.out.println("성공적으로 대여되었습니다"); break;
		case 1 : System.out.println("나이 제한으로 대여 불가능입니다"); break;
		case 2 : System.out.println("성공적으로 대여되었습니다, 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요"); break;
		
		}
		
	}
	
	
}
