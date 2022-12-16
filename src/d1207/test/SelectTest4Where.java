package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.util.OracleUtil;
// 하드코딩 : driver, user, password, 중요한 정보 들을 소스에서 직접 설정. (값을 변경하려면 소스코드를 변경)
// -> 프로퍼티 파일 사용으로 변경할 예정
public class SelectTest4Where {		// 조건식 추가
	
	public static void main(String[] args) {
	  
		Connection conn = OracleUtil.getConnection();
		System.out.print("연결확인 : ");
		System.out.println(conn);		
		

		PreparedStatement pstmt = null;		
		ResultSet rs = null;								
//		String sql = "select * from member_tbl_02 where custno = 100001 ";
		String sql = "select * from member_tbl_02 where custno = ? ";
																					//  ? 는 조건식 값, 인자
		
		try {
			pstmt = conn.prepareStatement(sql);		
			// sql 인자를 전달하는 방법
//			pstmt.setInt(1, 100003);		// 1번째 ? 기호 인자에 전달될 값은 100001
			System.out.print("검색할 회원 번호 입력 >> ");
			Scanner sc = new Scanner(System.in);
			int custno = Integer.parseInt(sc.nextLine());
			pstmt.setInt(1, custno);
			
			rs = pstmt.executeQuery();					
			
			System.out.println(custno + " : 검색 결과 ");
			System.out.println("::::::::::::::::::::::::::::::::");
			int cnt = 0;
			if(rs.next()) {		// 조건식의 컬럼 custno는 Pk -> 조회 결과가 0 또는 1개
				System.out.println(rs.getInt(1)+"\t"+rs.getNString(2)+"\t\t"
				+rs.getNString(3)+"\t" 
				+rs.getNString(4)+"\t"
				+rs.getDate(5)+"\t"
				+rs.getNString(6)+"\t"
				+rs.getNString(7));
				cnt++;
			}
			if(cnt==0)
			System.out.println("조회한 회원번호가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		
		
		
		OracleUtil.close(conn);
	}
}
