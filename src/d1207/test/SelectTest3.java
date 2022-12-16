package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {
	
	public static void main(String[] args) {
		Connection conn = OracleUtil.getConnection();
		System.out.print("연결확인 : ");
		System.out.println(conn);
		
		PreparedStatement pstmt = null;			
		ResultSet rs = null;
		String sql = "SELECT to_char(mem.custno) 회원번호, custname 회원명, "
				+ "decode(grade,'A','VIP','B','일반','C','직원') 고객등급, s\r\n"
				+ "FROM member_tbl_02 mem\r\n"
				+ "JOIN \r\n"
				+ "( \r\n"
				+ " SELECT CUSTNO , SUM(price) s		"
				+ " FROM MONEY_TBL_02 \r\n"
				+ " group BY CUSTNO"
				+ " ) sale\n"
				+ "ON mem.custno = sale.custno\r\n"
				+ "ORDER BY s DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t\t");
				System.out.print(rs.getString(2)+"\t\t");
				System.out.print(rs.getString(3)+"\t\t");
				System.out.print(rs.getInt(4)+"\t\t");
				System.out.println();
			}
		}catch (SQLException e) {
				e.printStackTrace();			
			}
	}
}
