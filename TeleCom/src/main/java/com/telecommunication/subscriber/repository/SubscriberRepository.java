package com.telecommunication.subscriber.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.telecommunication.subscriber.entity.Subscriber;

public interface SubscriberRepository extends MongoRepository<Subscriber, String>{
	
	public Optional<Subscriber>  findByEmail(String email);
	
	public Optional<List<Subscriber>> findByPlanType(String planType);
	
	public Optional<List<Subscriber>> findByPlanName(String planName);

}
