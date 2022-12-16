package d1212.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import d1208.test.Member;
import d1208.test.MemberDao;
import jdbc.util.OracleUtil;

// 싱글턴
public class SaleDao {

	private static SaleDao dao = new SaleDao();		
	private SaleDao() { };			
	public static SaleDao getSaleDao() {			// 프로젝트 할때에는 getInstance() 이름으로 하세요
		return dao;
	}
	
	public List<SaleDto> saleTotal() throws SQLException{
		Connection conn = OracleUtil.getConnection();
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
// 조회되는 결과 컬럼 : custno, custname, agrade, sale 4개는 member와 money 한곳에 있는 데이터가 아니므로
// 						 		ㄴ 새로운 DTO를 만듭니다.
		pstmt = conn.prepareStatement(sql); 			
		rs = pstmt.executeQuery();
		List<SaleDto> list = new ArrayList<SaleDto>();
		
		while(rs.next()) {
			SaleDto s = new SaleDto(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4)
					);
			list.add(s);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	
	
	
	
	
}
