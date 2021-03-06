package com.varsha.company.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CompanyExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleCompanyNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage().toString(),request.getDescription(false).toString());
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(exceptionResponse);
	}
	
	@ExceptionHandler(IpoNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleIpoNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage().toString(),request.getDescription(false).toString());
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(exceptionResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage().toString(),request.getDescription(false).toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
