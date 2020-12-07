package com.kh.jdbc.rent.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kh.jdbc.book.model.vo.RentBook;
import com.kh.jdbc.common.code.ErrorCode;
import com.kh.jdbc.common.exception.DataAccessException;
import com.kh.jdbc.common.template.JDBCTemplate;
import com.kh.jdbc.rent.model.vo.Rent;

public class RentDao {

	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public RentDao() {
		
	}
	
	public List<Rent> selectRentList(Connection conn, String title){
		return null;		
	}
	
	public List<RentBook> selectRentBookList(Connection conn, String title){
		return null;		
	}
	
	//TB_RENT_MASTER테이블에 주문건 정보 입력
	public int insertRentInfo(Connection conn, Rent rent) throws DataAccessException {
		PreparedStatement pstm = null;
		int res = 0;
		String query = "INSERT INTO TB_RENT_MASTER (RM_IDX, USER_ID, TITLE, RENT_BOOK_CNT)"
				+ " VALUES"
				+ "(SC_RM_IDX.NEXTVAL, ?, ?, ?)";		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, rent.getUserId());
			pstm.setString(2, rent.getTitle());
			pstm.setInt(3, rent.getRentbookCnt());
			res = pstm.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(), ErrorCode.IM01.errMsg());			
		}finally {
			jdt.close(pstm);
		}
		
		return res;
	}
	
	//대출 도서 정보 입력
	//SP_RENT_INSERT 프로시저 호출
	//프로시저 실행용 객체 : CallableStatement 
	public void inserRentBookInfo(Connection conn, int bIdx) throws DataAccessException{
		CallableStatement cstm = null;
		String query = "{call SP_RENT_INSERT(?)}";		
		try {
			cstm = conn.prepareCall(query);
			cstm.setInt(1, bIdx);
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			throw new DataAccessException(e.getMessage());
		}finally {
			jdt.close(cstm);
		}
		
	}
	
	//도서 반납 정보 입력
	//SP_RENT_RETURN 프로시저 호출
	public void updateReturnRentBook(Connection conn, int rbIdx) throws DataAccessException{
		CallableStatement cstm = null; 
		String query = "{call SP_RENT_RETURN(?)}";		
		try {
			cstm = conn.prepareCall(query);
			cstm.setInt(1, rbIdx);
			cstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}finally {
			jdt.close(cstm);
		}
	}
	
	public void updateExtendRentState(Connection conn, int no) throws DataAccessException{
				
	}
	
//	public int updateExtendRentBook(Connection conn, int no) {
//		return 0;		
//	}
	
//	public int insertUpdateHistory(Connection conn, int no) {
//		return 0;
//	}
	
	
	
}
