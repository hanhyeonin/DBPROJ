package d1208.test;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok 사용해보기 . lombok라이브러리로 자주 사용되는 getter setter toString 등등 코딩을 직접 안해도 된다.
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
	
	
}
