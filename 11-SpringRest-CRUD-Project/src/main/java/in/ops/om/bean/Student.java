package in.ops.om.bean;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "student_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name= "sid")
	private Integer stdId;
	
	
	@Column(name= "sname")
//	@NotNull(message = "sname is null, please give another value")
//	@NotEmpty(message = "sname must not be eighter empty nor null")
	@NotBlank(message = "not be empty, null or space")
//	@Size(max = 20, min= 5)
//	@Pattern(regexp = "[A-Za-z]{5-20}")
	private String stdName;

	@Column(name= "sage")
	private String stdAge;
	
	@Column(name= "dob")
	private LocalDate dob;
}
