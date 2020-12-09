package com.kh.jdbc.rent.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	public List<Rent> selectRentList(Connection conn, String userId){
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<Rent> rentList = new ArrayList<Rent>();
		Rent rent = null;
		String query ="SELECT * FROM TB_RENT_MASTER WHERE USER_ID = ? AND IS_RETURN = 0";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			while(rset.next()) {
				rent = new Rent();
				rent.setRmIdx(rset.getInt("RM_IDX"));
				rent.setUserId(rset.getString("USER_ID"));
				rent.setRegDate(rset.getDate("REG_DATE"));
				rent.setIsReturn(rset.getInt("IS_RETURN"));
				rent.setTitle(rset.getString("TITLE"));
				rent.setRentbookCnt(rset.getInt("RENT_BOOK_CNT"));
				rentList.add(rent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(), ErrorCode.SR01.errMsg());
		} finally {
			jdt.close(rset, pstm);
		}
		
		return rentList;		
	}
	
	public List<RentBook> selectRentBookList(Connection conn, int rmIdx){
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<RentBook> rentBookList = new ArrayList<RentBook>();
		RentBook rentBook = null;
		String query = "SELECT * FROM TB_RENT_BOOK WHERE RM_IDX = ? AND STATE IN ('RE00','RE01','RE02')";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, rmIdx);
			rset = pstm.executeQuery();
			while(rset.next()) {
				rentBook = new RentBook();
				rentBook.setRbIdx(rset.getInt("RB_IDX"));
				rentBook.setRmIdx(rset.getInt("RM_IDX"));
				rentBook.setBidx(rset.getInt("B_IDX"));
				rentBook.setRegDate(rset.getDate("REG_DATE"));
				rentBook.setState(rset.getString("STATE"));
				rentBook.setReturnDate(rset.getDate("RETURN_DATE"));
				rentBook.setExtentionCnt(rset.getInt("EXTENTION_CNT"));
				rentBookList.add(rentBook);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(), ErrorCode.SR01.errMsg());
		} finally {
			jdt.close(rset, pstm);
		}
		return rentBookList;		
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
	
	public void updateExtendRentState(Connection conn, int rbIdx) throws DataAccessException{
		CallableStatement cstm = null;
		String query = "{call SP_RENT_EXTEND(?)}";
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
	
//	public int updateExtendRentBook(Connection conn, int no) {
//		return 0;		
//	}
	
//	public int insertUpdateHistory(Connection conn, int no) {
//		return 0;
//	}
	
	
	
}
