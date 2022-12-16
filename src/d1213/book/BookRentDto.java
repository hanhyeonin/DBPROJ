package d1213.book;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder			// 객체 생성할 때 빌더(디자인 패턴) 사용 - 객체생성하면서 일부 속성 변수값만 초기화.
public class BookRentDto {
	private int rent_no;
	private int mem_idx;
	private String bcode;
	private Date rent_date;
	private Date exp_date;
	private Date return_date;
	private int delay_days;
	
	@Override
	public String toString() {
			return rent_no + "\t" 
					+ mem_idx + "\t" 
					+ bcode + "\t"
					+ rent_date + "\t"  
					+ exp_date + "\t" 
					+ return_date + "\t" 
					+ delay_days;
	}
}
