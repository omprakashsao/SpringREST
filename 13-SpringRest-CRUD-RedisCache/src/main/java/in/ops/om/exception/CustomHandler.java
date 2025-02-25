package in.ops.om.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ops.om.bean.CustomErrorInfo;
import io.swagger.v3.oas.annotations.Hidden;


@Hidden
@RestControllerAdvice
public class CustomHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<CustomErrorInfo> excepMethod(StudentNotFoundException sexp){
		
		CustomErrorInfo errorInfo = new CustomErrorInfo("500",sexp.getMessage(),new Date().toString());
		
		return new ResponseEntity<CustomErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
