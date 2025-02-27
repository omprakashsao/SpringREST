package in.ops.om.request;

import java.time.LocalDate;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ops.om.bean.Student;

@Component
public class RequestRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		//syncMethod();
		
		//syncPostMethod();
		
		asyncMethod();
		
		
		
	}

	private void asyncMethod() {
WebClient webClient = WebClient.create();
		
		String body = "http://localhost:8080/v1/api/student/one/{id}";
		
		webClient
		 		.get()
		 		.uri(body, 20)
		 		.retrieve()
		 		.bodyToMono(Student.class)
		 		.subscribe(System.out::println);
		
	}
	
	private void syncPostMethod() {
		
		WebClient webClient = WebClient.create();
		
		Student student = new Student();
		student.setDob(LocalDate.of(2023, 12, 23));
		student.setStdAge("34");
		student.setStdName("Om Prakash");
		
		
		String response = webClient
				.post()
				.uri("http://localhost:8080/v1/api/student/create")
				.body(BodyInserters.fromValue(student))
				.retrieve()
				.bodyToMono(String.class)
				.block();
				 
		System.out.println(response);
		
	}

	private void syncMethod() {
		
		WebClient webClient = WebClient.create();
		
		String body = "http://localhost:8080/v1/api/student/one/{id}";
		
		 Student student = webClient
		 		.get()
		 		.uri(body, 20)
		 		.retrieve()
		 		.bodyToMono(Student.class)
		 		.block();
		 System.out.println(student);
		
	}

}
