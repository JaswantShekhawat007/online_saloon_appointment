package com.osa.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	
    	List<String> errors  = ex.getBindingResult().getAllErrors()
    			.stream()
    			.map(x -> x.getDefaultMessage())
    			.collect(Collectors.toList());
		return new ResponseEntity<Object>(errors, status);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		return new ResponseEntity<String>(cnfe.getLocalizedMessage(), HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException onfe) {
		return new ResponseEntity<String>(onfe.getLocalizedMessage(),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<String> handleInvalidDataException(InvalidDataException ide){
		return new ResponseEntity<String>(ide.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException unfe){
		return new ResponseEntity<String>(unfe.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchAppointmentException.class)
	public ResponseEntity<String> handleUserNotFoundException(NoSuchAppointmentException nsae){
		return new ResponseEntity<String>(nsae.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
