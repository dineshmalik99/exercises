package com.sapient.lloyds.exception;

import java.util.Date;

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
class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exresponse = new ExceptionResponse(new Date(), ex.getMessage(), null);
		
		return new ResponseEntity(exresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CardBaseException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(CardBaseException ex, WebRequest request) throws Exception {
		ExceptionResponse exresponse = new ExceptionResponse(new Date(), ex.getMessage(),ex.getErrorCode());
		if(ex.getErrorCode()==ErrorCodes.USER_NOT_FOUND){
			return new ResponseEntity(exresponse,HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity(exresponse,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exresponse = new ExceptionResponse(new Date(), "Validation Fails, "+ex.getMessage(),null);
		return new ResponseEntity(exresponse,HttpStatus.BAD_REQUEST);
	}
}
