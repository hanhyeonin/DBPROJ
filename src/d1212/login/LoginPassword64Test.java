package d1212.login;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.common.hash.Hashing;

import jdbc.util.OracleUtil;

public class LoginPassword64Test {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection conn = OracleUtil.getConnection();
		String sql = "select * from book_member\r\n"
				+ "where email = ? and password64 = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		System.out.print("ID(email) 입력하세요 : ");
		String id = sc.nextLine();
		
		System.out.print("PassWord 입력하세요 : ");
		String password = sc.nextLine();
		
		pstmt.setString(1, id);
		pstmt.setString(2, Hashing.sha256()
				.hashString(password, StandardCharsets.UTF_8).toString());		// 첫번째 인자값의 인코딩형식
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) System.out.println("사용자 인증 - 로그인 성공했습니다.");
		else System.out.println("사용자 인증 - 아이디 또는 패스워드가 잘못된 값입니다.");
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	
}
