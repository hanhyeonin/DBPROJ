package d1208.test;

import java.sql.Date;

// VO클래스 : Value Object . 객체가 값으로 쓰인다. 모든 필드값이 같으면 동일한 Value.
//																		ㄴ hashcode, equals 메소드 재정의.

// DTO클래스 : Date Transfer Object . 데이터를 전달하는 목적으로 정의
public class Member {			// 불변객체 (setter 없으므로 값을 변경못함.)
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
	
	public Member(int custno, String custname, String phone, String address, Date joindate, String grade, String city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	
	// toString 재정의
	@Override
	public String toString() {
		return "Member [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
	}
	
	
	// getter 정의
	public int getCustno() {
		return custno;
	}


	public String getCustname() {
		return custname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public String getGrade() {
		return grade;
	}

	public String getCity() {
		return city;
	}
	
	
	
	
	
}
