package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class BookMemberDao {
	
	public boolean login(String id, String password) throws SQLException {
		boolean chack = false;
		Connection conn = OracleUtil.getConnection();
		String sql = "select count(mem_idx) from book_member\r\n"
				+ "where email = ? and password64 = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, id);
			pstmt.setString(2, Hashing.sha256()
					.hashString(password, StandardCharsets.UTF_8).toString());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();	
			
			if(rs.getInt(1)==1) {
				System.out.println("로그인 성공했습니다.");
				chack = true;
			}else System.out.println("로그인 실패했습니다.");
			
		rs.close();
		pstmt.close();
		conn.close();
		return chack;
	}
	
	public void updatePassword(String id, String pw) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		String sql = "update book_member set password64 = ? \r\n"
				+ "where mem_idx = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(2, id);
		String hval = Hashing.sha256()
				.hashString(pw, StandardCharsets.UTF_8).toString();
		pstmt.setString(1, hval);
		
		pstmt.execute();
		pstmt.close();
		conn.close();
	}
	
	public void insert(int idx, String name, String email, String password) throws SQLException {
		Connection conn = OracleUtil.getConnection();
		String sql = "INSERT INTO book_member (mem_idx, name, email, password) \r\n"
				+"VALUES (? , ? , ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		pstmt.setString(4, password);
		
		pstmt.execute();
		pstmt.close();
		conn.close();
	}
	
}
