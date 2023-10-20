package com.telecommunication.subscriber.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.telecommunication.subscriber.entity.Plan;

@Service
public interface PlanService {
	
	public Plan addPlan(Plan plan);
	
	public Optional<Plan> getPlanById(String planName);
	
	public Optional<List<Plan>> getPlanByPlanType(String planType);
	
	public String deletePlan(String planName);

}
