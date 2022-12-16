package d1212.login;

import java.sql.SQLException;
import java.util.Scanner;

public class BookMemberDaoTest {
	
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		BookMemberDao dao = new BookMemberDao();
		
//		login 메소드 테스트
		System.out.print("아이디입력(이메일) : ");
		String id = sc.nextLine();
		System.out.print("패스워드 입력 : ");
		String pw = sc.nextLine();
		
		dao.login(id, pw);
//		dao.updatePassword(id, pw);
//		System.out.println(pw);
		
//		update 메소드 테스트
//		System.out.print("아이디입력(5자리) : ");
//		String id = sc.nextLine();
//		System.out.print("패스워드 입력(4자리) : ");
//		String pw = sc.nextLine();
//		dao.updatePassword(id, pw);
		
//		insert메소드 테스트
//		System.out.print("아이디코드 5자리 : ");
//		int idx = Integer.parseInt(sc.nextLine());
//		System.out.print("이름 입력 : ");
//		String name = sc.nextLine();
//		System.out.print("이메일 입력 : ");
//		String email = sc.nextLine();
//		System.out.print("비밀번호 입력 : ");
//		String pw = sc.nextLine();
//		
//		dao.insert(idx, name , email , pw);
	}
}
