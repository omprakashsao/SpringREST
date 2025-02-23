package in.ops.om.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private Integer bid;
	private String bname;
	private String bauthor;
	private Integer bcost;
}
