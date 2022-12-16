package d1208.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MemberApp {
	
	public static void main(String[] args) throws SQLException {
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		// SQL 실행할 Dao 객체 생성
		MemberDao dao = MemberDao.getMemberDao();
		while (run) {
			System.out.println("[i] insert  [s]select 전체  [p]select PK  [e]종료");
			System.out.print("메뉴 선택 >> ");
			String sel = sc.nextLine();
			switch (sel) {
			case "i":
				System.out.print("이름 입력 >> ");
				String name = sc.nextLine();
				System.out.print("주소 입력 >> ");
				String addr = sc.nextLine();
				Member member = new Member(0, name, null, addr, null, null, null);
				dao.insert(member);
				break;
			case "s":
				List<Member> list = dao.selectList();
				for(Member m : list)
//					System.out.println(m);
					System.out.println(m.getCustno()+"\t"
				+m.getCustname()+"\t\t"
				+m.getAddress()+"\t"
				+m.getPhone()+"\t"
				+m.getJoindate()+"\t"
				+m.getGrade()+"\t"
				+m.getCity());
				break;
			case "p":
				System.out.print("찾을 custno를 입력하세요 >> ");
				int a = Integer.parseInt(sc.nextLine());
				System.out.println(dao.selectOne(a));
				break;
			case "e":
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;

			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				break;
			}
		}
		
	}
	
}
