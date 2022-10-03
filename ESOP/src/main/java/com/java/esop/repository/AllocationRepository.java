package com.java.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.esop.entity.Allocation;
import com.java.esop.entity.Grant;

/**
 * @author MURALI SANKAR
 * Interface Name : AllocationRepository
 */
@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>{
	
	
    @Query("from Allocation where grant=:grant")
	public Allocation findAllocationByGrantId(Grant grant);
		

}
