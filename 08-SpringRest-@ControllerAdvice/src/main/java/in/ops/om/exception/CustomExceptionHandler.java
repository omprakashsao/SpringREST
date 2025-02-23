package in.ops.om.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ops.om.bean.ExceptionBean;

@RestControllerAdvice
public class CustomExceptionHandler {

	
	@ExceptionHandler(value=BookNotFoundException.class)
	public ResponseEntity<?> execptionHandle(
			BookNotFoundException bexp
			){
		 
		ExceptionBean exceptionBean = new ExceptionBean(new Date(), "500", bexp.getMessage());
		return new  ResponseEntity<ExceptionBean>(exceptionBean,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
