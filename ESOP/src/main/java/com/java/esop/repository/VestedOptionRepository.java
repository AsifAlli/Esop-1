package com.java.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.esop.entity.VestedOption;

public interface VestedOptionRepository extends JpaRepository<VestedOption, Long>{
	
	
	@Query("from VestedOption where grantId=:grantId")
	public VestedOption findBygrantId(String grantId);

}
