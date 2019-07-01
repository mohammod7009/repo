package com.my.restapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class MyResponseEntiryExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler (Exception.class)
	public final ResponseEntity<MyExceptionResponse> handleAllExceptionsForMe(Exception ex, WebRequest request) throws Exception {
		MyExceptionResponse er = new MyExceptionResponse("my exception response - "
				+ "rootcause: " + ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler (UserNotFoundException.class)
	public final ResponseEntity<MyExceptionResponse> handleAllExceptionsForMe(UserNotFoundException ex, WebRequest request) throws Exception {
		MyExceptionResponse er = new MyExceptionResponse("my user not found - exception response - "
				+ "rootcause: " + ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		MyExceptionResponse er = new MyExceptionResponse("my method arg invalid - exception response - "
				+ "rootcause: " + ex.getBindingResult());
		
		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}
}
