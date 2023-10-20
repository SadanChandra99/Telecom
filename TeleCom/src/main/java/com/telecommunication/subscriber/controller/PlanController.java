package com.telecommunication.subscriber.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecommunication.subscriber.entity.Plan;
import com.telecommunication.subscriber.exception.PlanAlreadyExistsException;
import com.telecommunication.subscriber.exception.PlanNotFoundException;
import com.telecommunication.subscriber.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@PostMapping("/")
	public ResponseEntity<Plan> createPlan(@RequestBody Plan plan){
		Plan addPlan = planService.addPlan(plan);
		if(addPlan!=null) {
			return new ResponseEntity<Plan>(addPlan, HttpStatus.OK);
		}
		else {
			throw new PlanAlreadyExistsException("Plan Already Exists with name : "+ plan.getPlanName());
		}
	}
	
	
	@GetMapping("/")
	public ResponseEntity<Plan> getPlanById(@RequestParam("planName") String planName){
		Optional<Plan> plan = planService.getPlanById(planName);
		if(plan.isPresent() && plan.get()!=null) {
			return new ResponseEntity<Plan>(plan.get(), HttpStatus.OK);
		}
		else {
			throw new PlanNotFoundException("Plan Not Found with planName : "+planName);
		}
	}
	
	
	@GetMapping("/{type}")
	public ResponseEntity<List<Plan>> getPlansByType(@PathVariable("type") String type){
		Optional<List<Plan>> plans = planService.getPlanByPlanType(type);
		if(plans.isPresent() && plans.get().size()>0) {
			return new ResponseEntity<List<Plan>>(plans.get(), HttpStatus.OK);
			
		}
		else {
			throw new PlanNotFoundException(" Plan Not Found with type : "+type);
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity<String> deletePlan(@RequestParam("planName") String planName){
		String msg = planService.deletePlan(planName);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
