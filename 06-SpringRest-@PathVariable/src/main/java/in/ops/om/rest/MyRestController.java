package in.ops.om.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import in.ops.om.bean.Employee;
import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpHeaders;
import java.util.Enumeration;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("v1/api/rest")
public class MyRestController {
	
	@GetMapping("/get/{id}/{name}")
	public ResponseEntity<String> getMethodName(@PathVariable Integer id, @PathVariable String name ) {
			
		return new ResponseEntity<String>("Id : "+id + " name : "+ name, HttpStatus.OK) ;
	}
	
	@GetMapping("/request")
	public ResponseEntity<String> getMethod(@RequestParam Integer id, @RequestParam String name ) {
			
		return new ResponseEntity<String>("Id : "+id + " name : "+ name, HttpStatus.OK) ;
	}
	
	@GetMapping("/header")
	public ResponseEntity<String> getHearders(@RequestHeader Map<String, String> headers ) {
		
		
		headers.forEach((key, value)-> {
			System.out.println("key : "+key+" value : "+ value);
			
		});
			
		org.springframework.http.HttpHeaders resHeader = new org.springframework.http.HttpHeaders();
		
		resHeader.add("AppOne", "activated");
		return new ResponseEntity<String>("total headers : "+ headers.size(),resHeader, HttpStatus.OK) ;
	}
	
	@GetMapping("/h1")
	public ResponseEntity<String> getHearders(HttpServletRequest request ) {
		
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			System.out.println("Header name : "+ name + " value : "+ value);
		}
		
		
			
		return new ResponseEntity<String>( "Headers ", HttpStatus.OK) ;
	}
	
	
	
	
	

}
