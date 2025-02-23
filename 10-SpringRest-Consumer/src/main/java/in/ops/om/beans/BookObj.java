package in.ops.om.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookObj {
	
	private Integer bid;
	private String bname;
	private String bauthor;
	private Integer bcost;

}
