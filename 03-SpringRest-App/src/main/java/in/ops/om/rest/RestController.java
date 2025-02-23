package in.ops.om.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ops.om.bean.User;


@RequestMapping("v1/api/rest")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("/get")
	public ResponseEntity<User> getUser() {
		
		User body = new User(1, "om prakash", "bhiali");
		
		return new ResponseEntity<User>(body, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> getUserList() {
		
		List<User> list = List.of(new User(101, "ayush", "korba"), new User(102, "ankit", "chapa"), new User(103, "ankush", "gujrat"));
		
		
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/map")
	public ResponseEntity<Map<String, User>> getUserMapformat() {
		
		Map<String, User> map = Map.of("user1", new User(112, "loki", "season1"), "user2", new User(113, "black panther","vkanda"));
		
		
		
		
		return new ResponseEntity<Map<String, User>>(map, HttpStatus.OK);
	}
	
}