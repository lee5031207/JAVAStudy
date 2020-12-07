package com.kh.jdbc.rent.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.book.model.vo.Book;
import com.kh.jdbc.book.model.vo.RentBook;
import com.kh.jdbc.common.exception.DataAccessException;
import com.kh.jdbc.common.template.JDBCTemplate;
import com.kh.jdbc.rent.model.dao.RentDao;
import com.kh.jdbc.rent.model.vo.Rent;

public class RentService {

	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	RentDao rentDao = new RentDao();
	
	public RentService() {
		
	}
	
	public List<Rent> selectRentList(String title){
		return null;		
	}
	
	public List<RentBook> selectRentBookList(String title){
		return null;		
	}
	
	//도서 대출 처리
	public boolean insertRentBookInfo(Rent rent, List<Book> bookList) {
		Connection conn = jdt.getConnection();
		//대출건 정보를 tb_rent_master에 입력
		try {
			rentDao.insertRentInfo(conn, rent);	
			for(Book book : bookList) {
				rentDao.inserRentBookInfo(conn, book.getbIdx());
			}
			jdt.commit(conn);
			return true;
		}catch(DataAccessException e) {
			jdt.rollback(conn);
			return false;
		}finally {
			jdt.close(conn);
		}		
	}
	
	public boolean updateReturnRentBook(int rbIdx) {
		Connection conn = jdt.getConnection();
		try {
			rentDao.updateReturnRentBook(conn, rbIdx);
			jdt.commit(conn);
			return true;
		} catch(DataAccessException e) {
			jdt.rollback(conn);
			return false;
		} finally {
			jdt.close(conn);
		}
	}
	public boolean updateExtendRentState(int no) {
		return true;	
	}
	public boolean updateExtendRentBook(int no) {
		return true;	
	}
	
	
	
}
