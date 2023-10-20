package com.telecommunication.subscriber.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecommunication.subscriber.entity.Subscriber;
import com.telecommunication.subscriber.exception.SubscriberAlreadyExistsException;
import com.telecommunication.subscriber.exception.SubscriberNotFoundException;
import com.telecommunication.subscriber.service.SubscriberService;

@RestController
@RequestMapping("/sub")
public class SubscriberController {
	
	@Autowired
	private SubscriberService subscriberService;

	
	@PostMapping("/")
	public ResponseEntity<Subscriber> createSubscriber(@RequestBody Subscriber subscriber) throws SubscriberAlreadyExistsException{
		Subscriber sub = subscriberService.addSubscriber(subscriber);
		return new ResponseEntity<Subscriber>(sub, HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<Subscriber> getSubscriberByEmail(@RequestParam("email") String email){
		Optional<Subscriber> sub = subscriberService.getSubscriberByEmail(email);
		if(sub.isPresent()) {
			return new ResponseEntity<Subscriber>(sub.get(), HttpStatus.OK);
		}
		else {
			throw new SubscriberNotFoundException("Subscriber Not Found with email : "+email);
//			return new ResponseEntity<Subscriber>(new Subscriber(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/plan")
	public ResponseEntity<List<Subscriber>> getAllSubscribersByPlanType(@RequestParam("plantype") String planType){
		Optional<List<Subscriber>> allSubscribers = subscriberService.getSubscribersByPlanType(planType);
		List<Subscriber> subscribers = new ArrayList<>();
		if(allSubscribers.isPresent() && allSubscribers.get().size()>0) {
			return new ResponseEntity<List<Subscriber>>(allSubscribers.get(), HttpStatus.OK);
		}
		else {
			throw new SubscriberNotFoundException("Subscriber Not found with planType : "+planType);
//			return new ResponseEntity<List<Subscriber>>(subscribers, HttpStatus.NOT_FOUND);
		}
	}
	
	
	// Subscriber Data Fetching Methods company financial analysis purpose
	

	
	@GetMapping("/count")
	public int SubscriberCount(@RequestParam("planType") String planType) {
		int count = subscriberService.SubscriberCount(planType);
		return count;
	}
	
	@GetMapping("/revenue")
	public Double SubscriberRevenue(@RequestParam("planType") String planType) {
		Double revenue = subscriberService.RevenueCount(planType);
		return revenue;
	}
	
}
