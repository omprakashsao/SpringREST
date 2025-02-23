package com.ops.om.beans;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDataSerialize extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		String formatedDate = format.format(date);
		gen.writeString(formatedDate);
		
	}

}
