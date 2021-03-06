package com.kh.c_collection.silsub2.view;

import java.util.HashMap;
import java.util.Scanner;

import com.kh.c_collection.silsub2.controller.BookManager;
import com.kh.c_collection.silsub2.model.vo.Book;

public class BookMenu {

	
	BookManager bm = new BookManager();
	public BookMenu() {
		
	}
	
	public void mainMenu() {
		
		boolean result = true;
		while(result) {
			Scanner sc = new Scanner(System.in);
//			System.out.println("===도서 관리 프로그램===");
//			System.out.println("1.새 도서 추가  ");
//			System.out.println("2.도서 정보 정렬 후 출력 ");
//			System.out.println("3.도서 삭제 ");
//			System.out.println("4.도서 검색 출력 ");
//			System.out.println("5.전체 출력 ");
//			System.out.println("6.끝내기 ");
//			System.out.println("메뉴 번호 입력 >>");
			System.out.println("===도서 관리 프로그램===");
			System.out.println("1.새 도서 추가  | 2.도서 정보 정렬 후 출력");
			System.out.println("3.도서 삭제      | 4.도서 검색 출력");
			System.out.println("5.전체 출력      | 6.끝내기");
			System.out.println("메뉴 번호 입력 >>");
			int menuNo = sc.nextInt();
			sc.nextLine();
			switch(menuNo) {
			case 1 :
				//1.새 도서 추가  addBook(inputBook()이 리턴한 객체) 실행
				Book book = inputBook();
				bm.addBook(book);
				continue;
			case 2 :
				//2.도서정보 정렬 후 출력  
				//sortedBookList() => Book[] 리턴 받아 printBookList(Book[])실행
				Book[] BookList = bm.sortedBookList();
				bm.printBookList(BookList);
				continue;
			case 3 :
				Book delBook;
				//3.도서 삭제
				// deleteBook (inputBookNo()이 리턴한 도서 번호) 실행
				// => Book 리턴 받아 null이 아닐 경우 “성공적으로 삭제”
				//    null일 경우 “삭제할 글이 존재하지 않음”
				String bNo = inputBookNo();
				delBook = bm.deleteBook(bNo);
				if(delBook == null) {
					System.out.println("삭제할 도서가 존재하지 않음");
				}else {
					System.out.println("성공적으로 삭제");
				}
				continue;
			case 4 :
				//4. 도서 검색 출력
				// searchBook (inputBookTitle()이 리턴한 도서 제목) 실행
				//    => key 리턴 받아 null일 경우 “조회한 글이 존재하지 않음”
				//       null이 아닐 경우 selectBook(key) 출력
				String searchTitle = inputBookTitle();
				String resultKey = bm.searchBook(searchTitle);
				if(resultKey.equals("")) {
					System.out.println("검색한 도서는 없습니다");
				}else {
					System.out.println(bm.selectBook(resultKey));
				}
				continue;
			case 5 :
				//5. 전체 출력
				// selectAll() 실행 
				//     => 결과 map 리턴 받아 비어있을 경우 “없습니다.”
				//        아닐 경우 Iterator, keySet()을 이용하여 전체 출력
				HashMap<String, Book> selectAllMap = bm.selectAll();
				if(selectAllMap.isEmpty()) {
					System.out.println("없습니다");
				}else {
					for(String key : selectAllMap.keySet()) {
						System.out.println(selectAllMap.get(key).toString());
					}
				}
				continue;
			case 6 :
				System.out.println("프로그램을 종료합니다");
				result = false;
			}
		}
	}
	public Book inputBook() {	
		//새로운 책정보를 입력받아 Book객체를 return하는 함수
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 제목 >>");
		String title = sc.nextLine();
		
		System.out.print("도서 장르(1:인문   2:자연과학  3:의료  4:기타) >>");
		int category = sc.nextInt();
		sc.nextLine();
		
		System.out.print("도서 저자  >>");
		String author = sc.nextLine();
		Book book = new Book(category, title, author);				
		return book;
	}
	
	public String inputBookNo() {
		//삭제할 도서번호를 키보드로 입력받아 리턴
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 번호 >>");
		String bNo = sc.nextLine();
		return bNo;
	}
	
	public String inputBookTitle() {
		//검색할 도서제목을 키보드로 입력 받아 리턴
		Scanner sc = new Scanner(System.in);
		System.out.print("도서 제목 >>");
		String title = sc.nextLine();
		return title;
	}
	
}
