package d1213.book;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookMemberDto {

	private String mem_idx;
	private String name;
	private String email;
	private String tel;
	private String password;
	private String password64;
}
