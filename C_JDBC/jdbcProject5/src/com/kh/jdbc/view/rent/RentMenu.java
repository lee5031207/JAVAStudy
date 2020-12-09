package com.kh.jdbc.view.rent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.book.controller.BookController;
import com.kh.jdbc.book.model.vo.Book;
import com.kh.jdbc.book.model.vo.RentBook;
import com.kh.jdbc.common.code.MemberGrade;
import com.kh.jdbc.common.code.RentState;
import com.kh.jdbc.rent.controller.RentController;
import com.kh.jdbc.rent.model.vo.Rent;

public class RentMenu {

	Scanner sc = new Scanner(System.in);
	BookController bookController = new BookController();
	RentController rentController = new RentController();
	
	
	public void rentMenu() {
		do {
			
			System.out.println("\n*** 대출관리 ***");
			System.out.println("1. 도서 대출");
			System.out.println("2. 도서 반납");
			System.out.println("3. 도서 연장");
			System.out.println("4. 대출중인 도서 대출건 조회");
			System.out.println("5. 끝내기");			
			System.out.print("선택 >>");
			switch(sc.nextInt()) {
			case 1: 
				sc.nextLine();
				System.out.print("대출자의 ID를 입력하세요 >>");
				String userId = sc.nextLine();
				List<Book> bookList = new ArrayList<Book>();
				Book rBook = null;
				while(true) {
					System.out.print("대출할 도서명을 입력하시오 >>");
					rBook = bookController.searchBookByTitle(sc.nextLine());
					bookList.add(rBook);
					System.out.println("대출할 도서가 더 존재하나요(y/n) :");
					if(sc.nextLine().toUpperCase().equals("N")) {
						break;
					}
				}
				System.out.println(rentController.registRent(bookList, userId)+" 이 정상적으로 대출되었습니다.");
				break;
			case 2:
				// 반납할 도서의 대출도서번호(rbIdx)를 입력받아
				sc.nextLine();
				System.out.println("반납할 도서의 대출 도서 번호(rbIdx)를 입력하시오 >>");	
				int returnRbIdx = sc.nextInt();
				//해당 rbIdx의 대출도서를 반납처리 (프로시저 사용)
				if(rentController.returnBook(returnRbIdx)) {
					System.out.println("정상적으로 반납 되었습니다.");
				}else {
					System.out.println("반납 오류");
				}
				break;
			case 3:
				// 연장할 대출 도서번호(rbIdx)를 입력받아
				sc.nextLine();
				System.out.print("연장할 도서의 대출 도서 번호(rbIdx)를 입력하시오 >>");
				int extendRbIdx = sc.nextInt();
				// 해당 rbIdx의 대출도서를 연장 처리(프로시저 사용)
				if(rentController.extendBook(extendRbIdx)) {
					System.out.println("도서 대출이 연장되었습니다");
				}else {
					System.out.println("연장 오류");
				}
				
				break;
			case 4: 
				// 대출건을 조회할 사용자의 아이디를 입력받아
				sc.nextLine();
				System.out.print("대출건을 조회할 회원의 아이디를 입력하시오  >>");
				String userId2 = sc.nextLine();
				// rentController 의 searchRentList메서드 호출
				List<Rent> rentList = rentController.searchRentList(userId2);
				for (Rent rent : rentList) {
					// 반환 받은 rentList를 출력
					System.out.println(rent);
				}
				// 대출건 목록을 출력한 다음 
				// 사용자에게 대출건 상세 조회 여부를 물어 
				System.out.print("대출건을 상세 조회하시겠습니까 ?(y / Any key) >>");
				if(sc.nextLine().toUpperCase().equals("Y")) {
					// 상세 조회를 원할 경우, 상세 조회할 대출건 번호를 입력받고
					System.out.print("상세 조회할 대출건의 대출 건 번호를 입력하시오 >>");
					int rmIdx = sc.nextInt();
					List<RentBook> rentBookList = rentController.searchRentBookList(rmIdx);
					// 해당 대출건의 대출 도서 목록을 출력, 출력 내용: rmidx, rbIdx, 도서명(해도댐, Object써서), 반납일자, 여부		
					//member.setGrade(MemberGrade.valueOf(member.getGrade()).desc());
					
					for (RentBook rentBook : rentBookList) {
						rentBook.setState(RentState.valueOf(rentBook.getState()).state());
						System.out.println("[ rmIdx:" + rentBook.getRmIdx() + " rbIdx"
								+ ":" + rentBook.getRbIdx() + " 반납일자:" + rentBook.getReturnDate() + " 반납 여부:" + rentBook.getState() +" ]");
					}
				}
				break;
			case 5: return;			
			default : System.out.println("잘못 입력하셨습니다");			
			}
		}while(true);
	}
}
