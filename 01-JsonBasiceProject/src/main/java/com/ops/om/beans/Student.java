package com.ops.om.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value="student")
public class Student {
	
	@JsonIgnore
	private Integer sid;
	
	@JsonProperty("last_name")
	private String sname;
	
	private Integer sage;
	private boolean status;
	
	@JsonSerialize(using = CustomDataSerialize.class)
	@JsonDeserialize(using = CustomDateDeSerialize.class)
	private Date date;
	
	private Address address;

}
