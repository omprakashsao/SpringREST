package in.ops.om;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


//dummy request and response body
@AutoConfigureMockMvc
// get data from property file
@TestPropertySource("classpath:application.properties")
//intialize server and container
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
class ApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	String body = "{\n"
			+ "    \n"
			+ "    \"stdName\" : \"rahul\",\n"
			+ "    \"stdAge\" : 26,\n"
			+ "    \"dob\" : \"2002-05-24\"\n"
			+ "\n"
			+ "}";

	@Test
	void createStudentTest() {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
		.post("http://localhost:8080/v1/api/student/create")
		.contentType(MediaType.APPLICATION_JSON)
		.content(body);
		
		MvcResult result = null;
		try {
			result = mockMvc.perform(request).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response);
	}

}
