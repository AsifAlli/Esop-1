package com.java.esop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.esop.entity.Grant;
import com.java.esop.entity.Plan;

/**
 * @author MURALI SANKAR
 * Interface Name : GrantRepository
 */
@Repository
public interface GrantRepository extends JpaRepository<Grant, Long>{
	
	@Query
	public Grant findBygrantId(String grantId);
	
	@Query("from Grant where grantStatus=:grantStatus and allocatinStatus=:allocatinStatus")
	public List<Grant> findBygrantStatusAndallocatinStatus(String grantStatus,boolean allocatinStatus);
	
	@Query("from Grant where plan=:plan")
    public List<Grant> findByGrantsUsingPlanId(Plan plan);

}
