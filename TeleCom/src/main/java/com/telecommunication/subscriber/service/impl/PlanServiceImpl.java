package com.telecommunication.subscriber.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecommunication.subscriber.entity.Plan;
import com.telecommunication.subscriber.exception.PlanAlreadyExistsException;
import com.telecommunication.subscriber.exception.PlanNotFoundException;
import com.telecommunication.subscriber.repository.PlanRepository;
import com.telecommunication.subscriber.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepository planRepository;

	@Override
	public Plan addPlan(Plan plan) {
		// TODO Auto-generated method stub
		Optional<Plan> planInDb = planRepository.findById(plan.getPlanName());
		if(planInDb.isPresent()) {
			throw new PlanAlreadyExistsException("Plan Already Exists with "+ plan.getPlanName());
		}
		else {
			Plan addPlan = planRepository.save(plan);
			return addPlan;
		}
		
	}

	@Override
	public Optional<Plan> getPlanById(String planName) {
		// TODO Auto-generated method stub
		Optional<Plan> plan = planRepository.findById(planName);
		if(plan.isPresent() && plan!=null) {
			return plan;
		}
		throw new PlanNotFoundException("Plan Not Found with planName : "+ planName);
	}

	@Override
	public Optional<List<Plan>> getPlanByPlanType(String planType) {
		// TODO Auto-generated method stub
		Optional<List<Plan>> plans = planRepository.findByPlanType(planType);
		if(plans.isPresent() && plans.get().size()>0) {
			return plans;
		}
		throw new PlanNotFoundException( "Plan Not Found with planType : "+planType);
	}

	@Override
	public String deletePlan(String planName) {
		// TODO Auto-generated method stub
		planRepository.deleteById(planName);
		return "Plan Deleted Successfully..";
	}

}
