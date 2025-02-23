package in.ops.om.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ops.om.bean.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("v1/api/employee")
public class MyRestController {
	
	@PostMapping("/save")
	public ResponseEntity<Employee> postMethodName(@RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(employee , HttpStatus.CREATED);
	}
	

}
