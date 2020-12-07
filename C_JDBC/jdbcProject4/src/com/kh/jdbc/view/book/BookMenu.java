package com.kh.jdbc.view.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.book.controller.BookController;
import com.kh.jdbc.book.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	//컨트롤러 호출은 직접
	BookController bookcontroller = new BookController();
	
	public void bookMenu() {
		do {
			System.out.println("\n *** 도서 관리 ***");
			System.out.println("1. 도서 전체 조회");
			System.out.println("2. 도서 등록");
			System.out.println("3. 도서 소개 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 검색");
			System.out.println("6. 종료");
			System.out.print("입력 >> ");
			
			switch (sc.nextInt()) {
			case 1 : //도서 전체 조회 
				//Controller의 SearchAllBooks()를 호출하고
				List<Book> bookList = bookcontroller.searchAllBooks();
				for (Book book : bookList) {
					System.out.println(book);
				}
				//결과 값을 출력
				break;
			case 2 :
				// registBook 메서드를 호출해 사용자로부터 
				// 추가할 도서 정보를 입력 받고
				Book book = registBook();
				// BookController의 registBook 메서드를 호출해 도서 정보를 추가
				boolean res = bookcontroller.registBook(book);
				if(res) {
					// 도서가 성공적으로 추가되면 "도서 추가 성공 출력"
					System.out.println("도서 추가 성공");
				}else if(!res) {
					// 도서 추가에 실패하면 "도서 추가 실패 "출력
					System.out.println("도서 추가 실패");
				}
				break;
			case 3 :
				//수정할 도서의 도서 번호와 도서 소개(info컬럼)을 사용자로 부터 입력받아
				
				System.out.print("수정할 도서 번호를 입력 :");
				int bIdx = sc.nextInt();
				
				sc.nextLine();
				
				System.out.print("수정할 소개 멘트를 입력 :");
				String info = sc.nextLine();
				
				//bookController의 modifyBook을 호출해 도서 소개를 수정하고
				Book book1 = new Book();
				book1.setbIdx(bIdx);
				book1.setInfo(info);				
				boolean result = bookcontroller.modifyBook(book1);
				if(result) {
					//성공하면 "도서 수정 성공"
					System.out.println("도서 추가 성공");
				}else if(!result) {
					//실패하면 " 도서 수정 실패" 를 출력하시오
					System.out.println("도서 추가 실패");
				} 
				break;
			case 4 :
				System.out.println("삭제할 도서의 번호를 입력하시오");
				int bIdx2 = sc.nextInt();
				boolean delRes = bookcontroller.deleteBook(bIdx2);
				if(delRes) {					
					System.out.println("도서 삭제 성공");
				}else if(!delRes) {
					System.out.println("도서 삭제 실패");
				} 
				//삭제할 도서의 도서번호를 사용자로 부터 입력받아
				//bookController의 deleteBook메서드를 호출하고
				//도서 삭제에 성공하면 "도서 삭제 성공", 실패하면 "도서 삭제 실패"
				break;
			case 5 :
				searchBookMenu();				
				//searchBookMenu 메서드를 호출해 도서 검색 메뉴창 출력
				break;
			case 6: return;
			default : System.out.println("잘못된 번호를 입력하셨습니다."); break;
			}
			
		} while (true);
	}
	
	public void searchBookMenu() {
		do {
			System.out.println("\n *** 도서 검색 메뉴 ***");
			System.out.println("1. 도서명 검색");
			System.out.println("2. 인기 top 5 검색");
			System.out.println("3. 이전 메뉴로 이동");
			System.out.print("입력 >>");
			
			switch(sc.nextInt()) {
			case 1:
				sc.nextLine();
				System.out.println("검색할 도서명 : ");
				String title = sc.next();
				//bookController의  searchBookByTitle 메서드에 사용자가
				Book book = bookcontroller.searchBookByTitle(title);
				System.out.println(book);
				//입력한 도서명을 전달하고 결과를 출력하시오.
				break;
			case 2:
				System.out.println("대출 건수가 많은 상위 5권의 목록 입니다");
				//bookController의 searchBookWithRank() 메서드를 호출해
				//상위 다섯권의 도서 리스트를 반환받아, 리스트 안의 도서들을 출력
				List<Book> bookList = bookcontroller.searchBooksWithRank();
				for (Book book2 : bookList) {
					System.out.println(book2);
				}
				break;
			case 3: return;
			default : System.out.println("잘못 입력 하셨습니다. 다시 입력하세요 ");
			}
			
		}while(true);
	}
	
	public Book registBook() { //책등록 메뉴
		Book book = new Book();
		System.out.println("도서 정보를 입력하세요=========");
		System.out.print("도서제목 :");
		book.setTitle(sc.next());
		
		System.out.print("작가 :");
		book.setAuthor(sc.next());
		
		System.out.print("ISBN :");
		book.setIsbn(sc.next());
		
		System.out.print("카테고리 코드: ");
		book.setCategory(sc.next());		
		return book;
	}
}
