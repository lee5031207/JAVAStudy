package com.kh.toy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kh.toy.common.code.ErrorCode;
import com.kh.toy.common.exception.DataAccessException;
import com.kh.toy.common.template.JDBCTemplate;
import com.kh.toy.member.model.vo.Member;

//DAO :DBMS에 접근해 데이터 조회, 수정, 삽입 ,삭제 요청을 보내는 클래스
//DAO의 메서드는 가능하다면 하나의 메서드에 하나의 쿼리만 처리하도록 작성s


public class MemberDao {

	
	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	public MemberDao() {}
	
	public Member memberAuthenticate(Connection conn, String userId, String password) {
		
		Member member = null;
		//Connection객체  : DBMS와의 연결을 관리 
		//transaction(Commit,Rollback) 관리
		
		
		//PreparedStatement객체 : 쿼리 실행용 객체 
		PreparedStatement pstm = null;
		
		//Select 쿼리의 결과로 반환된 데이터를 저장하는 객체
		ResultSet rset = null;
		
		try {
			//JDBC코딩 순서
			//1. 오라클 JDBC Driver를 JVM에 등록
			//   java reflection 찾아보면 이해 쉬움
			//  -forName메서드의 전달인자로 넣어준 문자열은 OracleDriver 클래스의 fullname
			//   Class.forName메서드는 매개변수로 받은 클래스명의 클래스객체를 반환
			//   Class.forName메서드로 반환받은 Class객체를 통해 해당 Class의 메서드를 사용하거나
			//   새로운 인스턴스를 반환받는 등으로 활용할 수 있다.
			
			
			//2. 데이터베이스와 연결 처리
			
			
			//3. 쿼리 실행용 객체 생성
			String query = "select * from tb_member where user_id = ? and password = ?";
			pstm = conn.prepareStatement(query);
			
			//4. 쿼리 작성
			
			
			pstm.setString(1, userId);
			pstm.setString(2, password);
			
			//5. 쿼리 실행하고 resultSet 받기
			rset = pstm.executeQuery();
			
			//6. resultSet에 저장된 데이터를 VO객체로 옮겨 닮기
			//next() : 현재 위치에서 다음 row에 데이터가 있는지 확인하고
			//		    있다면 true, 없다면 false를 반환하는 메서드 
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setPassword(rset.getString("PASSWORD"));
				member.setGrade(rset.getString("GRADE"));
				//enum ValueOF()메서드를 사용해 원하는 문자열을 매개변수로 입력하면
				//그 문자열과 같은 변수명을 가진 Enum인스턴스를 반환
				//member.setGrade(MemberGrade.valueOf(rset.getString("GRADE")).desc());
				
				
				member.setTell(rset.getString("TELL"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setRentableDate(rset.getDate("RENTABLE_DATE"));
				member.setIsLeave(rset.getInt("IS_LEAVE"));
			}
			
			System.out.println("DB로부터 받아온 데이터 확인 : " +member);
		} catch (SQLException e) {
			// SQLException : DB와 통신중에 발생하는 모든 예외를 담당하는 exception
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(), ErrorCode.SM01.errMsg());
		} finally {
			jdt.close(rset, pstm);
		}
		return member;
	}
	
	public Member selectMemberById(Connection conn, String userId) {
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			
			
			String query = "select * from TB_MEMBER where USER_ID = ? ";
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성
			pstm.setString(1, userId);
			
			rset = pstm.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setPassword(rset.getString("PASSWORD"));
				member.setGrade(rset.getString("GRADE"));
				member.setTell(rset.getString("TELL"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setRentableDate(rset.getDate("RENTABLE_DATE"));
				member.setIsLeave(rset.getInt("IS_LEAVE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.SM01.errMsg());
		} finally {
			jdt.close(rset, pstm);
		}		
		return member;
	}
	
	public ArrayList<Member> selectMemberList(Connection conn){
		ArrayList<Member> memberList = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {			
			String query = "select * from TB_MEMBER";
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성			
			rset = pstm.executeQuery();
			memberList = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setPassword(rset.getString("PASSWORD"));
				member.setGrade(rset.getString("GRADE"));
				member.setTell(rset.getString("TELL"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setRentableDate(rset.getDate("RENTABLE_DATE"));		
				member.setIsLeave(rset.getInt("IS_LEAVE"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.SM01.errMsg());
		} finally {
			jdt.close(rset, pstm);
		}		
		return memberList;
	}
	
	public int insertMember(Connection conn, Member member) {
		int res = 0;
		
		PreparedStatement pstm = null;
		try {			
			String query = "INSERT INTO TB_MEMBER (USER_ID, PASSWORD, EMAIL, TELL) VALUES (?,?,?,?) ";
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성
			pstm.setString(1, member.getUserId());
			pstm.setString(2, member.getPassword());
			pstm.setString(3, member.getEmail());
			pstm.setString(4, member.getTell());			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.IM01.errMsg());
		} finally {
			jdt.close(pstm);
		}	
		return res;
	}
	
	public int updateMember(Connection conn, Member member) {
		int res = 0;		
		PreparedStatement pstm = null;
		try {
			String query = "UPDATE TB_MEMBER SET PASSWORD = ? WHERE USER_ID =?";
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성
			pstm.setString(1, member.getPassword());
			pstm.setString(2, member.getUserId());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.UM01.errMsg());
		} finally {
			jdt.close(pstm);
		}	
		return res;
	}
	
	public int deleteMember(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		try {
			String query = "DELETE FROM TB_MEMBER WHERE USER_ID = ? ";
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.DM01.errMsg());
		} finally {
			jdt.close(pstm);
		}	
		return res;
	}
	
	public List<Member> selectMemberByRegdate(Connection conn, Date beginDate, Date endDate){
		List<Member> memberList = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			String query = "select * from TB_MEMBER where REG_DATE between ? AND ? ";			
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성
			pstm.setDate(1, (java.sql.Date) beginDate);
			pstm.setDate(2, (java.sql.Date) endDate);
						
			rset = pstm.executeQuery();
			memberList = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setPassword(rset.getString("PASSWORD"));
				member.setGrade(rset.getString("GRADE"));
				member.setTell(rset.getString("TELL"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setRentableDate(rset.getDate("RENTABLE_DATE"));
				member.setIsLeave(rset.getInt("IS_LEAVE"));
				memberList.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.SM01.errMsg());
		} finally {
			jdt.close(rset, pstm);
		}
		
		return memberList;
	}
	
	public int UpdateMemberToLeave(Connection conn, String userId) {
		int res = 0;
		
		PreparedStatement pstm = null;
		try {
			String query = "UPDATE TB_MEMBER SET IS_LEAVE = 1 WHERE USER_ID = ?";
			pstm = conn.prepareStatement(query); //쿼리용  Statement 생성
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException(e.getMessage(),ErrorCode.UM01.errMsg());
		} finally {
			jdt.close(pstm);
		}	
		return res;
	}
}
