package com.kh.jdbc.book.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.book.model.service.BookService;
import com.kh.jdbc.book.model.vo.Book;

public class BookController {

	BookService bookservice = new BookService();
	public BookController() {
		
	}
	
	public List<Book> searchAllBooks(){
		List<Book> bookList = bookservice.selectAllBooks();
		return bookList;		
	}
	
	public List<Book> searchBooksWithRank(){
		List<Book> bookList = bookservice.selectBookOrderByRank();		
		return bookList;		
	}
	
	public Book searchBookByTitle(String title) {
		Book book = bookservice.selectBookByTitle(title);
		return book;
	}
	
	public boolean registBook(Book book) {
		int res = bookservice.insertBook(book);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean modifyBook(Book book) {
		int res = bookservice.updateBook(book);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteBook(int bIdx) {
		Book book = new Book();
		book.setbIdx(bIdx);
		int res = bookservice.deleteBookByBIdx(book);
		if(res == 1) {
			return true;
		}else {
			return false;
		}		
	}
	
}
