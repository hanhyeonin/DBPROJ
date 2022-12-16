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
public class BookDto {

	private String bcode;
	private String title;
	private String writer;
	private String publisher;
	private Date pdate;
}
