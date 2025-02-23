package in.ops.om.runner;

import java.lang.invoke.MethodType;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.ops.om.beans.BookObj;

@Component
public class ConsumerRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		RestTemplate template = new RestTemplate();
		String url = "http://localhost:9999/v1/api/book/get";
		ResponseEntity<String> bookObj = template.getForEntity(url, String.class);
		System.out.println(bookObj);
		System.out.println(bookObj.getBody());
		System.out.println(bookObj.getHeaders().values());
		System.out.println(bookObj.getStatusCode());
		
		
		String url1 = "http://localhost:9999/v1/api/book/book/12";
		ResponseEntity<BookObj> book = template.getForEntity(url1, BookObj.class);
		System.out.println(book.getBody());
		
		String url2 = "http://localhost:9999/v1/api/book/test/10/Rohan yadav";
		
		ResponseEntity<String> entity = template.getForEntity(url2, String.class);
		System.out.println("************************************");
		
		System.out.println(entity.getBody());
		
		System.out.println("*********************************");
		
		String url3 = "http://localhost:9999/v1/api/book/save";
				
		          HttpHeaders headers = new  HttpHeaders();
		          headers.setContentType(MediaType.APPLICATION_JSON);
		          
		          String body = "{\r\n"
		          		+ "    \"bid\": 1,\r\n"
		          		+ "    \"bname\": \"abc\",\r\n"
		          		+ "    \"bauthor\": \"alex\",\r\n"
		          		+ "    \"bcost\": 223\r\n"
		          		+ "}";
		          HttpEntity<String> entity4 = new HttpEntity<>(body, headers);
		       ResponseEntity<String> postObj = template.postForEntity(url3, entity4, String.class);
		       System.out.println(postObj.getBody());
		       
		       String url4 = "http://localhost:9999/v1/api/book/delete";
		       String url5 = "http://localhost:9999/v1/api/book/put/{id}";
		       
		       
		       
		       
		       ResponseEntity<String> delete = template.exchange(url4, HttpMethod.DELETE, entity4, String.class);
		       System.out.println(delete);
		       
		       ResponseEntity<String> put = template.exchange(url5, HttpMethod.PUT, entity4,String.class, 2);
		       System.out.println(put);

	}

}
