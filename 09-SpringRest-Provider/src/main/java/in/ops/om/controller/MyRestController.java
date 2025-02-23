package in.ops.om.controller;

import org.springframework.web.bind.annotation.RestController;

import in.ops.om.bean.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("v1/api/book")
public class MyRestController {
	
	@GetMapping("/get")
	public ResponseEntity<String> getMethodName() {
		
		Book book = new Book(1,"Poker1M","robenZang",200);
		return new ResponseEntity<>("Details "+book,HttpStatus.OK);
	}
	
	@GetMapping("/test/{id}/{name}")
	public ResponseEntity<String> getPara(@PathVariable Integer id, @PathVariable String name ) {
		return new ResponseEntity<>("id : "+id +" name : "+name,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getMethod(@PathVariable Integer id) {
		
		Book book = new Book(id,"Poker1M","robenZang",200);
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> postMethodName(@RequestBody Book book) {
		
		
		return new ResponseEntity<String>("object : "+ book, HttpStatus.OK);
	}
	
	@PutMapping("put/{id}")
	public ResponseEntity<String> putMethodName(@PathVariable String id, @RequestBody Book book) {
		
		
		return ResponseEntity.ok("object is updated for id "+ id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletemethod(@RequestBody Book book){
		
		return new  ResponseEntity<>("object is deleted for id "+ book.getBid() , HttpStatus.OK);
	}
	
	
	
}
