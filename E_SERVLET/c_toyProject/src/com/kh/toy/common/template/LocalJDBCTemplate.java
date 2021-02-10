package com.kh.toy.common.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocalJDBCTemplate {

	//Singleton 패턴
		//클래스의 인스턴스가 하나만 생성되어야 할 때 사용하는 디자인 패턴
		
		private static LocalJDBCTemplate instance;
		
		//생성자를 private으로 바꿔서 외부에서 JDBCTemplate의 생성을 차단
		private LocalJDBCTemplate() {
			//1. OracleDriver를 jvm에 등록
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//외부에서 JDBCTemplate의 인스턴스를 반환받기 위한 메서드
		public static LocalJDBCTemplate getInstance() {
			if(instance == null) {
				instance = new LocalJDBCTemplate();
			}
			return instance;
		}
		
		public Connection getConnection() {
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "bookmanager";
			String password = "user11";
			
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection(url,user,password);
				//Transaction 관리를 개발자가 하기 위해 AutoCommit 설정 끄기
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		//commit 메서드
		public void commit(Connection conn) {
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//rollback 메서드
		public void rollback(Connection conn) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void close(ResultSet rset, Statement stmt) {
			close(rset);
			close(stmt);
		}
		
		public void close(Statement stmt, Connection conn) {
			close(stmt);
			close(conn);
		}
		
		public void close(ResultSet rset, Statement stmt, Connection conn) {
			close(rset);
			close(stmt);
			close(conn);
		}
}
