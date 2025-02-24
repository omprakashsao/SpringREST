package in.ops.om.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorInfo {
	
	private String status;
	private String msg;
	private String date;
}
