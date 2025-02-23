package com.ops.om.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ops.om.beans.Student;

public class MainApp {

	public static void main(String[] args) throws IOException {
	
		System.out.println("*****************************");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		
		Student student = mapper.readValue(new File("output.json"), Student.class);
		
		System.out.println(student);

	}

}
