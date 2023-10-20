package com.telecommunication.subscriber.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.telecommunication.subscriber.entity.Subscriber;


@Service
public interface SubscriberService {

	public Subscriber addSubscriber(Subscriber subscriber);
	public Optional<Subscriber> getSubscriberById(String subscriberId);
	public Optional<Subscriber> getSubscriberByEmail(String subscriberEmail); 
	public Optional<List<Subscriber>> getSubscribersByPlanType(String planType);
	public Optional<List<Subscriber>> getSubscribersByPlanName(String planName);
	
	

	
	
	public int SubscriberCount(String planType);
	public Double RevenueCount(String planType);
}
