package com.kh.jdbc.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.book.model.dao.BookDao;
import com.kh.jdbc.book.model.vo.Book;
import com.kh.jdbc.common.exception.DataAccessException;
import com.kh.jdbc.common.template.JDBCTemplate;

public class BookService {

	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	BookDao bookDao = new BookDao();
	
	public BookService() {
		
	}
	
	public List<Book> selectAllBooks(){
		Connection conn = jdt.getConnection();		
		List<Book> bookList = bookDao.selecctAllBooks(conn);
		jdt.close(conn);
		return bookList;		
	}
	
	public List<Book> selectBookOrderByRank(){
		Connection conn = jdt.getConnection();
		List<Book> bookList = bookDao.selectBookOrderByRank(conn);
		jdt.close(conn);		
		return bookList;		
	}
	
	public Book selectBookByTitle(String title) {
		Connection conn = jdt.getConnection();
		Book book = bookDao.selectBookByTitle(conn, title);
		jdt.close(conn);
		return book;		
	}
	
	public int insertBook(Book book) {
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			res = bookDao.insertBook(conn, book);
			jdt.commit(conn);
		} catch(DataAccessException e) {
			jdt.rollback(conn);
			System.out.println("SQLException 발생!!");
		}finally {
			jdt.close(conn);
		}
		return res;
	}
	
	public int updateBook(Book book) {
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			res = bookDao.updateBook(conn, book);
			jdt.commit(conn);
		} catch(DataAccessException e) {
			jdt.rollback(conn);
			System.out.println("SQLException 발생!!");
		}finally {
			jdt.close(conn);
		}
		return res;
	}
	
	public int deleteBookByBIdx(Book book) {
		Connection conn = jdt.getConnection();
		int res = 0;
		try {
			res = bookDao.deleteBookByBIdx(conn, book);
			jdt.commit(conn);
		} catch(DataAccessException e) {
			jdt.rollback(conn);
			System.out.println("SQLException 발생!!");
		}finally {
			jdt.close(conn);
		}
		return res;
	}
}
