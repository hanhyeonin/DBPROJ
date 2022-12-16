package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.OracleUtil;

// DAO 클래스 : Date Access Object . SQL 실행하는 메소드를 모아놓은 클래스
//						ㄴ DAO 클래스는 '객체를 1개만 생성되도록 하는 디자인패턴' - 싱글턴으로 만듭니다.
//						ㄴ 1개의 객체로 여러 프로그램에서 사용하도록 합니다. static 안쓰고 싱글턴으로 만듭니다.
//						ㄴ 인스턴스 메소드로 만들어야 인터페이스 적용과 상속에서 메소드 재정의가 가능합니다.
public class MemberDao {
	
	// 싱글턴
	private static MemberDao dao = new MemberDao();		
	// private 멤버변수가 참조하는 것은 자기자신 객체
	
	private MemberDao() { };			// 생성자 private (이 클래스 외에는 사용못함.)
	
	// 생성된 객체를 리턴해주는 public 메소드 - 항상 동일한 객체를 리턴
	public static MemberDao getMemberDao() {		
		return dao;
	}
	
	public void delete(int custno) throws SQLException {
		String sql = "delete * from member_tbl_02 where custno = ?";
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, custno);
		
		pstmt.execute();
		pstmt.close();
		conn.close();
	}
	
	public void update(Member member) throws SQLException {
		String sql = "update member_tbl_02\r\n"
				+ "set phone = ? , address = ? , city = ? \r\n"
				+ "where custno = ?";
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getPhone());
		pstmt.setString(2, member.getAddress());
		pstmt.setString(3, member.getCity());
		pstmt.setInt(4, member.getCustno());
		
		pstmt.execute();
		pstmt.close();		// pstmt에 지정된  sql 실행 종료. (close : 자원해제)
//		conn.commit();		// autocommit이 false(OFF) 일때는 필요합니다
//		conn.rollback();		// 하나의 트랜잭션을 구성하는 여러 SQL 중 일부 오류일때, 이미 실행된 SQL을 취소합니다.
		conn.close();
	}
	
	public List<Member> selectList() throws SQLException{		// Member 객체를 저장한 리스트를 리턴
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02";
		
		pstmt = conn.prepareStatement(sql); 			// Exception 처리는 jvm에게 throw(위임,떠넘기기).
		rs = pstmt.executeQuery();
		List<Member> memberlist = new ArrayList<>();		// select 조회결과를 자바 객체로 저장.
		while(rs.next()) {
			Member m = new Member(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					rs.getString(6),
					rs.getString(7)
					);
			memberlist.add(m);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return memberlist;
	}
	
	
	public Member selectOne(int custno) throws SQLException {
		Member member = null;
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member_tbl_02 where custno = ? ";
		
		pstmt = conn.prepareStatement(sql); 			
		pstmt.setInt(1, custno);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			member  = new Member(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					rs.getString(6),
					rs.getString(7)
					);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return member;
	}
	
	public void insert(Member member) throws SQLException {
		// Member 객체를 인자로 받아서 insert 할 값으로 SQL에 전달.
		Connection conn = OracleUtil.getConnection();
		String sql = "INSERT INTO MEMBER_TBL_02 \r\n"
				+"VALUES (sq_score.nextval, ? , ?, ?, sysdate , ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, member.getCustname());
		pstmt.setString(2, member.getPhone());
		pstmt.setString(3, member.getAddress());
		pstmt.setString(4, member.getGrade());
		pstmt.setString(5, member.getCity());
		
		pstmt.execute();
		pstmt.close();
		conn.close();
		
	}
	
	
}
