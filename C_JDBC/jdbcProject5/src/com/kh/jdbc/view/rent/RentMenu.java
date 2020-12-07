package com.kh.jdbc.view.rent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.book.controller.BookController;
import com.kh.jdbc.book.model.vo.Book;
import com.kh.jdbc.rent.controller.RentController;

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
				int rbIdx = sc.nextInt();
				//해당 rbIdx의 대출도서를 반납처리 (프로시저 사용)
				if(rentController.returnBook(rbIdx)) {
					System.out.println("정상적으로 반납 되었습니다.");
				}else {
					System.out.println("반납 오류");
				}
				break;
			case 3: 
				// 연장할 대출 도서번호(rbIdx)를 입력받아
				// 해당 rbIdx의 대출도서를 연장 처리(프로시저 사용)
				break;
			case 4: 
				// 대출건을 조회할 사용자의 아이디를 입력받아
				// rentController 의 searchRentList메서드 호출
				// 반환 받은 rentList를 출력
				// 대출건 목록을 출력한 다음 
				// 사용자에게 대출건 상세 조회 여부를 물어 상세 조회를 원할 경우
				// 상세 조회할 대출건 번호를 입력받고
				// 해당 대출건의 대출 도서 목록을 출력, 출력 내용: rmidx, rbIdx, 도서명, 반납일자, 여부				
				break;
			case 5: return;			
			default : System.out.println("잘못 입력하셨습니다");			
			}
		}while(true);
	}
}
