package com.telecommunication.subscriber.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecommunication.subscriber.entity.CallHistory;
import com.telecommunication.subscriber.entity.Plan;
import com.telecommunication.subscriber.entity.Subscriber;
import com.telecommunication.subscriber.exception.SubscriberNotFoundException;
import com.telecommunication.subscriber.repository.PlanRepository;
import com.telecommunication.subscriber.repository.SubscriberRepository;
import com.telecommunication.subscriber.service.SubscriberService;


@Service
public class SubscriberServiceImpl implements SubscriberService{
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Autowired
	private PlanRepository planRepository;
	
	

	 private LocalTime calculateDuration(LocalTime start, LocalTime end) {
	        // Calculate duration
	        int hours = end.getHour() - start.getHour();
	        int minutes = end.getMinute() - start.getMinute();
	        int seconds = end.getSecond() - start.getSecond();

	        // Handle negative duration
	        if (seconds < 0) {
	            seconds += 60;
	            minutes--;
	        }
	        if (minutes < 0) {
	            minutes += 60;
	            hours--;
	        }
	        if (hours < 0) {
	            hours += 24;
	        }

	        return LocalTime.of(hours, minutes, seconds);
	    }
	

	@Override
	public Subscriber addSubscriber(Subscriber subscriber) {
		
		
		String planName = subscriber.getPlanName();
		Optional<Plan> plan = planRepository.findById(planName);
		if(plan.isPresent() && plan.get()!= null) {
			subscriber.setPlan(plan.get());
		}

		List<CallHistory> callhistory = subscriber.getCallHistory();

		
		for(CallHistory c: callhistory) {
			LocalTime duration = calculateDuration(c.getCallStartTime(), c.getCallEndTime());
			c.setCallDuration(duration);  
			
		}
//		subscriber.setCallHistory(callhistory);
		
		Subscriber addsubscriber = subscriberRepository.save(subscriber);
		return addsubscriber;
	}

	@Override
	public Optional<Subscriber> getSubscriberById(String subscriberId) {
		// TODO Auto-generated method stub
		Optional<Subscriber> getSubscriber = subscriberRepository.findById(subscriberId);

		return getSubscriber;
	}

	@Override
	public Optional<Subscriber> getSubscriberByEmail(String subscriberEmail) {
		// TODO Auto-generated method stub
		Optional<Subscriber> getSubscriber = subscriberRepository.findByEmail(subscriberEmail);
		return getSubscriber;
	}


	@Override
	public Optional<List<Subscriber>> getSubscribersByPlanType(String planType) {
		// TODO Auto-generated method stub
		Optional<List<Subscriber>> subscribersByPlan = subscriberRepository.findByPlanType(planType);
		return subscribersByPlan;
	}


	@Override
	public Optional<List<Subscriber>> getSubscribersByPlanName(String planName) {
		// TODO Auto-generated method stub
		Optional<List<Subscriber>> subscribers = subscriberRepository.findByPlanName(planName);
		if(subscribers.isPresent() && subscribers.get().size()>0) {
			return subscribers;
		}
		else {
			throw new SubscriberNotFoundException("Subsciber not found by planName: "+ planName);
		}
	}





	@Override
	public int SubscriberCount(String planType) {
		// TODO Auto-generated method stub
		if(planType == null) {
			List<Subscriber> allSubscribers = subscriberRepository.findAll();
			return allSubscribers.size();
		}
		else {
		}
		List<Subscriber> subscribersCount = subscriberRepository.findByPlanType(planType).get();
		
		return subscribersCount.size();
		
	}


	@Override
	public Double RevenueCount(String planType) {
		
		
		// TODO Auto-generated method stub
		Double revenue = 0.0;
		
		if(planType == null) {
			List<Subscriber> allSubscribers = subscriberRepository.findAll();
			for(Subscriber s: allSubscribers) {
				revenue = revenue + s.getPlan().getPrice();
			}
			return revenue;
		}
		else {
			List<Subscriber> subscribers = subscriberRepository.findByPlanType(planType).get();
			for(Subscriber s: subscribers) {
				revenue = revenue + s.getPlan().getPrice();
			}
			return revenue;
		}
		
	}
	
	// -----------------------------------------------------------------------------------
	

}
