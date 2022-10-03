package com.java.esop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.esop.dto.Optiondto;
import com.java.esop.dto.Vestingdto;
import com.java.esop.entity.Allocation;
import com.java.esop.entity.Grant;
import com.java.esop.entity.Plan;
import com.java.esop.entity.VestedOption;
import com.java.esop.repository.AllocationRepository;
import com.java.esop.repository.VestedOptionRepository;

@Service
public class MonetizationService {
	
	
	@Autowired
	AllocationService allocationService;
	
	
	@Autowired
	VestedOptionRepository VestedOptionRepository;
	
	
	@Autowired
	CommonServicePlanAndEmployee commonServicePlanAndEmployee;
	
	
	@Autowired
	GrantService grantService;
	
	
	@Autowired
	AllocationRepository allocationRepository;
	
	
	
	
	
	public void prepareVestedOption(Vestingdto vestingdto )
	{
		
		List<Optiondto> optiondto= allocationService.findAllocatedAllocationSumByPlan(vestingdto.getYear());
		
		List<VestedOption> vestedOption= new ArrayList<>();
		
		for(Optiondto Optiondto1:optiondto)
		{
			
			VestedOption option= new VestedOption();
			option.setGrantId(Optiondto1.getGrantId());
			option.setVestedOption(Optiondto1.getAllocatedSum()*vestingdto.getVestingFactor());
			option.setCreatedDate(new Date());
			option.setMotifiedDate(new Date());
			
			vestedOption.add(option);				
		}
		
		VestedOptionRepository.saveAll(vestedOption);
	     	
		
	}
	
	
	
	
	
	
	
	
	public Boolean isManetizationStarted(Long plnaId)
	
	{
		
		Plan plan=commonServicePlanAndEmployee.findByPlanId(plnaId);
		
		if(plan.getMonetizationDate() != null) return true;
		return false;
		
	}
	
	
	
	
	
	
	public VestedOption findBygrantId(String grantId)
	{
		
		return VestedOptionRepository.findBygrantId(grantId);
	}
	

}
