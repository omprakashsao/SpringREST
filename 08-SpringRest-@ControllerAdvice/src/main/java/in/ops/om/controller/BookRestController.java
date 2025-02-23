package in.ops.om.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ops.om.bean.Book;
import in.ops.om.exception.BookNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("v1/api/book")
public class BookRestController {

	@GetMapping("/getbook/{id}")
	public ResponseEntity<Book> getMethodName(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		if(id == 105) {
			headers.add("found", "yes");
			return new ResponseEntity<Book>(new Book(1,"footprints", "shakespere", 200),headers, HttpStatus.OK);
		}
		else {
//			headers.add("found", "no");
//			return new ResponseEntity<String>( , headers, HttpStatus.INTERNAL_SERVER_ERROR);
			
			 throw new BookNotFoundException("book is not exist for given id"+ id);
		}
	}
	
}
