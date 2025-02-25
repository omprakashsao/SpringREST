package in.ops.om.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ops.om.bean.Student;
import in.ops.om.exception.StudentNotFoundException;
import in.ops.om.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;

	@Operation(description = "Student Object is inserted")
	@ApiResponses(value= {
			@ApiResponse( responseCode = "201", description = "STUDENT OBJECT IS CREATED",
						  content = {
								  @Content(mediaType = "applicatoin/text")
									}
						),
			@ApiResponse( responseCode = "400" , description = "Bad-Request", content = { @Content(mediaType = "application/text")})
						}
			)
			
	@PostMapping("/create")
	public ResponseEntity<String> saveStudent(@RequestBody @Valid Student student) {
		
		service.saveStudent(student);
		return new ResponseEntity<String>("Student is save sucessfully for given id"+ student.getStdId(), HttpStatus.CREATED);
	}
	
	//SELECT
	@GetMapping("/one/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
		
		ResponseEntity<Student> response;
		try {
			
			Student student = service.getStudentById(id);
			response = new ResponseEntity<Student>(student, HttpStatus.OK);
		}catch (StudentNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() {
		ResponseEntity<List<Student>> response;
		try {
			
			List<Student> allStudent = service.getAllStudents();
			response = new ResponseEntity<List<Student>>(allStudent, HttpStatus.OK);
		}catch (StudentNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return response;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent( @RequestBody @Valid Student student) {
		
		ResponseEntity<String> response;
		
	    try {
			service.updateStudent(student);
			response = new ResponseEntity<String>("Stduent record sucessfully updated for id"+ student.getStdId() , HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		ResponseEntity<String> response;
		
		try {
			service.deleteStudent(id);
			response = new ResponseEntity<String>("student is sucessfully deleted for id "+ id, HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		return response;
	}
	
	
}
