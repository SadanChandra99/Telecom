package com.telecommunication.subscriber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(PlanAlreadyExistsException.class)
	public ResponseEntity<String> PlanAlreadyExists(PlanAlreadyExistsException ex){
		return new ResponseEntity<String>("Plan Already Exists ..", HttpStatus.ALREADY_REPORTED);
	}
	
	
	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<String> PlanNotFound(PlanNotFoundException ex){
		return new ResponseEntity<String>("Plan Not Found Exception", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SubscriberNotFoundException.class)
	public ResponseEntity<String> SubscriberNotFound(SubscriberNotFoundException ex){
		return new ResponseEntity<String>("Subscriber Not Found....", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SubscriberAlreadyExistsException.class)
	public ResponseEntity<String> subscriberAlreadyExists(SubscriberAlreadyExistsException ex){
		return new ResponseEntity<String>("Subscriber Already Exists..", HttpStatus.ALREADY_REPORTED);
	}

}
