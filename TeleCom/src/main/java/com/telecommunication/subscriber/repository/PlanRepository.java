package com.telecommunication.subscriber.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.telecommunication.subscriber.entity.Plan;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String>{

	public Optional<List<Plan>>  findByPlanType(String planType);
}
