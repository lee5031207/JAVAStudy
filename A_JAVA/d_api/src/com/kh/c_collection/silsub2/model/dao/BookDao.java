package com.kh.c_collection.silsub2.model.dao;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import com.kh.c_collection.silsub2.model.vo.Book;

public class BookDao {

	private HashMap<String, Book> bookMap = new HashMap<String, Book>();
	
	public BookDao() {
		//생성자
	}
	
	public BookDao(HashMap<String, Book> map) {
		//매개변수 생성자 다른 map을 전달 받아
		//bookMap의 초기값으로 사용함
	}
	
	public int getLastBookNo() {
		//도서의 마지막 도서 번호 리턴
		String lastkey = "";
		int result = 0;
		if(bookMap.isEmpty()) {
			result = 0;
		}else {
			//Iterator, keySet() 이용하여
			//for문으로 돌면서 key값을 계속 갱신
			for(String key : bookMap.keySet()) {
				lastkey = key;
			}
			result = Integer.parseInt(lastkey);
		}
		//result = Integer.parseInt(lastkey);
		return result;
	}
	
	public void addBook(Book book) {
		//전달받은 도서 객체 bookMap 에 추가
		bookMap.put(book.getbNo(), book);
	}
	
	public Book deleteBook(String key) {
		//keySet()을 이용하여 전달받은 도서 번호와 일치하는
		Book delBook = new Book();
		for(String bNo : bookMap.keySet()) {
			if(bNo.equals(key)) { //삭제할 거 있다면
				//도서 bookMap에서 삭제, 삭제한 객체 리턴
				delBook = bookMap.get(key);
				bookMap.remove(key);
				break; // ConcurrentModificationException 예외처리
			}else {
				delBook = null;
			}
		}
		return delBook;
	} 
	
	public String searchBook(String title) {
		//entrySet()을 이용하여 전달받은 도서 제목을 포함하는 bookMap의 key값 리턴
		String result = "";
		for(java.util.Map.Entry<String, Book> book : bookMap.entrySet()) {
			//if(book.getKey().equals(title)) {
			if(book.getValue().getTitle().equals(title)) {
				result = book.getKey();
				//System.out.println("book :"+book);
				//System.out.println("book.getKey() : " + book.getKey());
				break;
			}else {
				result = "";
			}
		}
		return result;
	}
	
	public Book selectBook(String key) {
		//전달받은 key값을 이용하여 bookMap의 해당 key값의 value인 Book 객체 리턴
		return bookMap.get(key);
	}
	
	public HashMap<String, Book> selectAll(){
		//전체 도서 리턴
		return bookMap;
	}
	
	public ArrayList<Book> sortedBookList(){
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		//entrySet()을 이용하여 ArrayList<Book>을 가져오고
		for(java.util.Map.Entry<String, Book> book : bookMap.entrySet()) {
			bookList.add(book.getValue());
		}
		//Collections.sort()를 이용하여 리스트 정렬 후 리턴
		Collections.sort(bookList);
		return bookList;
	}
	
	
	
	
	
	
	
	
}
