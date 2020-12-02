package com.kh.jdbc.member.model.dao;

import com.kh.jdbc.member.model.vo.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//DAO :DBMS에 접근해 데이터 조회, 수정, 삽입 ,삭제 요청을 보내는 클래스
//DAO의 메서드는 가능하다면 하나의 메서드에 하나의 쿼리만 처리하도록 작성


public class MemberDao {

	public MemberDao() {}
	
	public Member memberAuthenticate(String userId, String password) {
		
		Member member = null;
		//Connection객체  : DBMS와의 연결을 관리 
		//transaction(Commit,Rollback) 관리
		Connection conn = null;
		
		//Statement객체 : 쿼리 실행용 객체
		Statement stmt = null;
		
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 데이터베이스와 연결 처리
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"bookmanager",
					"user11");
			
			//3. 쿼리 실행용 객체 생성
			stmt = conn.createStatement();
			
			//4. 쿼리 작성
			String query = "select * from tb_member where user_id = '"
			+userId+"' and password ='" + password + "'";
			System.out.println(query);
			
			//5. 쿼리 실행하고 resultSet 받기
			rset = stmt.executeQuery(query);
			
			//6. resultSet에 저장된 데이터를 VO객체로 옮겨 닮기
			//next() : 현재 위치에서 다음 row에 데이터가 있는지 확인하고
			//		    있다면 true, 없다면 false를 반환하는 메서드 
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setPassword(rset.getString("PASSWORD"));
				member.setGrade(rset.getString("GRADE"));
				member.setTell(rset.getString("TELL"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setRentableDate(rset.getDate("RENTABLE_DATE"));
			}
			
			System.out.println("DB로부터 받아온 데이터 확인 : " +member);
		} catch (ClassNotFoundException | SQLException e) {
			// SQLException : DB와 통신중에 발생하는 모든 예외를 담당하는 exception
			e.printStackTrace();
		} finally {
			try {
				//닫아주어야 한다.			
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public Member selectMemberById(String userId) {
		Member member = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bookmanager", "user11");
			stmt = conn.createStatement(); //쿼리용  Statement 생성
			String query = "select * from TB_MEMBER where USER_ID = '"+userId+"'";
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setPassword(rset.getString("PASSWORD"));
				member.setGrade(rset.getString("GRADE"));
				member.setTell(rset.getString("TELL"));
				member.setRegDate(rset.getDate("REG_DATE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setRentableDate(rset.getDate("RENTABLE_DATE"));				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member;
	}
	
	public ArrayList<Member> selectMemberList(){
		return new ArrayList<Member>();
	}
	
	public int inserMember(Member member) {
		return 0;
	}
	
	public int updateMember(Member member) {
		return 0;
	}
	
	public int deleteMmeber(String userId) {
		return 0;
	}
	
	public List<Member> selectMemberByRegdate(Date beginDate, Date endDate){
		List<Member> memberList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bookmanager", "user11");
			stmt = conn.createStatement(); //쿼리용  Statement 생성
			String query = "select * from TB_MEMBER where REG_DATE between '"+beginDate+"' and '"+endDate+"'";
			rset = stmt.executeQuery(query);
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
				memberList.add(member);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return memberList;
	}
	
	
}
