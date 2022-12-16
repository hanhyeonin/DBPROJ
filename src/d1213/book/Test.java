package d1213.book;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		BookRentDao dao = BookRentDao.getInstance();
//		System.out.println(dao.selectRentBook());
		// 대여책 반납
//		dao.returnBook("10002");
		
		// 대여하기시스템
		int mem_idx = 10002;
		String bcode = "C1102";
		try {
			if(!dao.isAvailableMember(mem_idx))
				System.out.println("회원님은 대여중인 도서가 있어 추가 대여 불가!!");
			else if(!dao.isAvailableBook(bcode)) {
				System.out.println("이 책은 대여중입니다!!");
			}else {
				// dto클래스의 일부 속성 변수만 초기화 할 때 아래와 같은 방법은 불편함(가독성, 효율성..).
//				dao.rentBook(new BookRentDto(0, mem_idx, bcode, null, null, null, 0));
				dao.rentBook(BookRentDto.builder()
						.mem_idx(mem_idx)		// 빌더 객체에서 메소드 실행 순서는 무관.
						.bcode(bcode)				// 					메소드 이름은 필드(속성변수)와 동일
						.build());						// build()메소드 실행으로 dto 객체 생성 완료
				System.out.println(mem_idx + " 회원 " + bcode + " 도서 대여처리 완료!!");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
			
		
	}
	}

