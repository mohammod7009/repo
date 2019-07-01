package com.my.restapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class MyExceptionResponse extends RuntimeException {

	private static final long serialVersionUID = 3671193709551673379L;
	
	String message;
	
}
