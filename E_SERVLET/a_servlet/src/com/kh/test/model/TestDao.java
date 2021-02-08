package com.kh.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestDao {

	public List<Test> selectList() throws SQLException{
		List<Test> list = null;
		PreparedStatement pstm = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@192.168.10.3:1521:xe";
		String user = "kh";
		String password = "kh";
		String query = "SELECT * FROM  TEST";
	
		try {
			conn = DriverManager.getConnection(url,user,password);
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Test test = new Test();
				test.setSeq(rs.getInt(1));
				test.setWriter(rs.getString(2));
				test.setTitle(rs.getString(3));
				test.setContent(rs.getString(4));
				test.setRegDate(rs.getDate(5));
				list.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstm.close();
			conn.close();
			rs.close();
		}
		return list;
	}
}
