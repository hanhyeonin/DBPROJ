package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleUtil {
	public static Connection getConnection() {
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.1.36:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "iclass10";
		String password = "1234";
		
		try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		
		}catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 드라이버 로드에 문제가 생겼습니다. : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 및 사용에 문제가 생겼습니다. : " + e.getMessage());
		}
		return conn;
	}
	
	
	public static void close(Connection conn) {
			// db 접속 후 모든 db작업을 종료하면 접속도 종료.
			try {
				if(conn != null) {
				conn.close();		// conn이 null 객체라면 close에서 오류 -> 조건식 추가
				System.out.println("연결 종료!");
				}else {
					System.out.println("Connection  이 null 입니다.");
				}
			}catch (SQLException e) {  
				System.out.println("데이터베이스 연결 종료 오류 : " + e.getMessage());
			}
	}
	
	// rs, pstmt, conn 모두 close 해야할때를 위해 메소드 오버로딩.
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// db 접속 후 모든 db작업을 종료하면 접속도 종료.
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) {
			conn.close();		// conn이 null 객체라면 close에서 오류 -> 조건식 추가
			System.out.println("연결 종료!");
			}else {
				System.out.println("Connection  이 null 입니다.");
			}
		}catch (SQLException e) {  
			System.out.println("데이터베이스 연결 종료 오류 : " + e.getMessage());
		}
}
	public static void main(String[] args) {
		Connection conn = OracleUtil.getConnection();
		System.out.println(conn);
	}
}
