package com.java.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.esop.entity.Plan;

/**
 * @author MURALI SANKAR
 * Interface Name:GrantRepository
 */
@Repository
public interface PlanRepository extends JpaRepository<Plan,Long>{

	@Query("from Plan where year=:year")
	public Plan findByPlanByPlanYear(String year);
	
}
