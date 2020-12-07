package com.kh.jdbc.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.book.model.vo.Book;
import com.kh.jdbc.common.exception.DataAccessException;
import com.kh.jdbc.common.template.JDBCTemplate;

public class BookDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public BookDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Book> selecctAllBooks(Connection conn){
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<Book> bookList = new ArrayList<Book>();
		String query = "SELECT * FROM TB_BOOK";
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();			
			while(rset.next()) {
				Book book = new Book();
				book.setbIdx(rset.getInt("B_IDX"));
				book.setIsbn(rset.getString("ISBN"));
				book.setCategory(rset.getString("CATEGORY"));
				book.setTitle(rset.getString("TITLE"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setInfo(rset.getString("INFO"));
				book.setBookAmt(rset.getInt("BOOK_AMT"));
				book.setRegDate(rset.getDate("REG_DATE"));
				book.setRentCnt(rset.getInt("RENT_CNT"));
				bookList.add(book);								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			jdt.close(rset, pstm);
		}
		
		
		return  bookList;
	}
	
	public List<Book> selectBookOrderByRank(Connection conn){
		List<Book> bookList = new ArrayList<Book>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "SELECT * FROM \r\n" + 
				"(SELECT * FROM TB_BOOK ORDER BY RENT_CNT DESC)\r\n" + 
				"WHERE ROWNUM <= 5";
		try {
			pstm = conn.prepareStatement(query);
			rset= pstm.executeQuery();
			while(rset.next()) {
				Book book = new Book();
				book.setbIdx(rset.getInt("B_IDX"));
				book.setIsbn(rset.getString("ISBN"));
				book.setCategory(rset.getString("CATEGORY"));
				book.setTitle(rset.getString("TITLE"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setInfo(rset.getString("INFO"));
				book.setBookAmt(rset.getInt("BOOK_AMT"));
				book.setRegDate(rset.getDate("REG_DATE"));
				book.setRentCnt(rset.getInt("RENT_CNT"));
				bookList.add(book);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			jdt.close(rset, pstm);
		}		
		return  bookList;
	}
	
	public Book selectBookByTitle(Connection conn, String title) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Book book = new Book();
		String query = "SELECT * FROM TB_BOOK WHERE TITLE = ?";
		try {
			pstm  = conn.prepareStatement(query);
			pstm.setString(1, title);
			rset = pstm.executeQuery();
			if(rset.next()) {
				book.setbIdx(rset.getInt("B_IDX"));
				book.setIsbn(rset.getString("ISBN"));
				book.setCategory(rset.getString("CATEGORY"));
				book.setTitle(rset.getString("TITLE"));
				book.setAuthor(rset.getString("AUTHOR"));
				book.setInfo(rset.getString("INFO"));
				book.setBookAmt(rset.getInt("BOOK_AMT"));
				book.setRegDate(rset.getDate("REG_DATE"));
				book.setRentCnt(rset.getInt("RENT_CNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			jdt.close(rset, pstm);
		}
		return book;		
	}
	
	public int insertBook(Connection conn, Book book) {
		PreparedStatement pstm = null;
		int res = 0;
		String query = "INSERT INTO TB_BOOK "
				+ "(B_IDX, ISBN, CATEGORY, TITLE, AUTHOR, INFO, BOOK_AMT, REG_DATE, RENT_CNT)"
				+ "VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, book.getbIdx());
			pstm.setString(2, book.getIsbn());
			pstm.setString(3, book.getCategory());
			pstm.setString(4, book.getTitle());
			pstm.setString(5, book.getAuthor());
			pstm.setString(6, book.getInfo());
			pstm.setInt(7, book.getBookAmt());
			pstm.setDate(8, book.getRegDate());
			pstm.setInt(9, book.getRentCnt());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			jdt.close(pstm);
		}
		return res;
	}
	
	public int updateBook(Connection conn, Book book) {
		PreparedStatement pstm = null;
		int res = 0;
		try {
			String query = "UPDATE TB_BOOK SET INFO = ? WHERE B_IDX = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, book.getInfo());
			pstm.setInt(2, book.getbIdx());
			System.out.println("excute전"+res);
			System.out.println(pstm);
			res = pstm.executeUpdate();
			System.out.println("excute후"+res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			jdt.close(pstm);
		}
		return res;
	}
	
	public int deleteBookByBIdx(Connection conn, Book book) {
		PreparedStatement pstm = null;
		int res = 0;
		try {
			String query = "DELETE FROM TB_BOOK WHERE B_IDX = ?";
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, book.getbIdx());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			jdt.close(pstm);
		}
		return res;
	}
	
	
	
	
}
