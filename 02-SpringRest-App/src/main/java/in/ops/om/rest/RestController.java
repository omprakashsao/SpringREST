package in.ops.om.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("v1/api/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("/get")
	public ResponseEntity<String> getMethodName() {
		
		return new ResponseEntity<String>("GET METHOD", HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> postMethodName() {
		
		return new ResponseEntity<String>("POST METHOD", HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<String> putMethod() {
		
		return new ResponseEntity<String>("PUT METHOD", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMethod() {
		
		return new ResponseEntity<String>("DELETE METHOD", HttpStatus.OK);
	}

	@PatchMapping("/patch")
	public ResponseEntity<String> patchMethod() {
		
		return new ResponseEntity<String>("PATCH METHOD", HttpStatus.OK);
	}
}
