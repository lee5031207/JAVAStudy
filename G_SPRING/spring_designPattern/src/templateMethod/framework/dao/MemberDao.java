package templateMethod.framework.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import templateMethod.framework.jdbc.JDBCTemplate;

public class MemberDao {
	
	private JDBCTemplate jdt;
	
	public MemberDao(JDBCTemplate jdt) {
		this.jdt = jdt;
	}
	
	public String selectPassword(String userId) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String res = null;
		String query = "SELECT PASSWORD FROM TB_MEMBER WHERE USER_ID = ?";
		try {
			pstm = jdt.getConnection().prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			if(rset.next()) {
				res = rset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdt.close(rset, pstm);
		}
		return res;
	}
}
