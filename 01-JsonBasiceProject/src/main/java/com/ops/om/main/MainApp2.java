package com.ops.om.main;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ops.om.beans.Address;
import com.ops.om.beans.Student;

public class MainApp2 {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		Student student = new Student(1, "Om Prakash", 23, true,new Date(17122002121312L), new Address("bhilai","India"));
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		mapper.writeValue(new File("output.json"), student);
	}

}
