package com.kh.c_collection.silsub2.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.c_collection.silsub2.model.dao.BookDao;
import com.kh.c_collection.silsub2.model.vo.Book;

public class BookManager {

	BookDao bd = new BookDao();
	public BookManager() {
		
	}
	
	public void addBook(Book book) {
		// BookDao의 getLastBookNo() 메소드를 통해 도서의 마지막 도서 번호를 알아옴
		// 첫 글일 경우 0으로 받아오게끔 BookDao의 getLastBookNo() 내용 구현 할 것!
		int lastNo = bd.getLastBookNo();
		
		// setter를 이용하여 도서 번호를 마지막 도서 번호 +1 처리
		book.setbNo(Integer.toString(lastNo+1));
		
		// BookDao의 addBook()메소드에 해당 Book 객체 전달
		bd.addBook(book);

	}
	
	public Book deleteBook(String key) {
		// BookDao의 deleteBook() 메소드에 전달받은 도서 번호 전달		
		// 그 결과 값을 받아 리턴
		Book delBook = bd.deleteBook(key);
		return delBook;
	}
	
	public String searchBook(String title) {
		// BookDao의 searchBook() 메소드에 전달받은 도서 제목 전달
		String key = bd.searchBook(title);
		// 그 결과 값(map의 key값)을 받아 리턴
		return key;		
	}
	
	public Book selectBook(String key) {
		// BookDao의 selectBook() 메소드에 전달받은 key값 전달
		Book resultBook = bd.selectBook(key);
		// 그 결과 값(해당 Book객체)을 받아 리턴
		return resultBook;
	}
	
	public HashMap<String, Book> selectAll(){
		// BookDao의 selectAll() 메소드를 통해 도서 전체를 전달 받아 리턴
		HashMap<String, Book> selectAllMap = bd.selectAll();
		return selectAllMap;
	}
	
	public Book[] sortedBookList() {	
		//BookDao의 sortedBookList() 메소드를 통해 전달 받은 정렬된
		// 도서 전체를 for문을 통해 Book[] 배열에 넣고 리턴
		ArrayList<Book> bookList = bd.sortedBookList();
		Book[] BookList = new Book[bookList.size()];
		for(int i=0; i<bookList.size(); i++) {
			BookList[i] = bookList.get(i);			
		}
		return BookList;
	}
	
	public void printBookList(Book[] br) {
		//전달 받은 Book[] 배열을 for each문을 이용하여 출력
		for (Book book : br) {
			System.out.println(book.toString());
		}
	}
	
	
	
	
	
	
	
}
