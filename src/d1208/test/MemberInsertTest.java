package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class MemberInsertTest {
	
	public static void main(String[] args) throws SQLException {
		
//		String sql = "INSERT INTO MEMBER_TBL_02 \r\n"
//				+ "VALUES (sq_score.nextval,'나행복','010-7777-2222','서울시 강남구 역삼동','2022-12-08','A','01')";
		String sql = "INSERT INTO MEMBER_TBL_02 \r\n"
				+"VALUES (sq_score.nextval, ? , ?, ?, sysdate , ?, ?)";
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		// insert/update/delete 는 ResulstSet 사용안함.
		
		pstmt = conn.prepareStatement(sql);
		
		// execute 메소드로 SQL 실행하기 전에 필요한 인자 전달
		pstmt.setString(1, "다행복");
		pstmt.setString(2, "010-7777-2299");
		pstmt.setString(3, "서울시 강남구 서초동");
		pstmt.setString(4, "A");
		pstmt.setString(5, "02");
		
		pstmt.execute();				// select SQL은 executeQuery 메소드, 나머지는 execute 메소드
		conn.close();
		
	}
	
}
