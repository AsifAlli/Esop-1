package com.java.esop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.esop.appconstant.Appconstant;
import com.java.esop.entity.Allocation;
import com.java.esop.entity.Grant;
import com.java.esop.service.AllocationService;

/**
 * @author MURALI SANKAR
 * Class : AllocationController
 */
@RestController
@RequestMapping(value=Appconstant.ALLOCATION_CONTROLLER)
public class AllocationController {

	@Autowired
	AllocationService allocationService;
	
	
	
	
	/**
	 * Method : initiateAllocation() in AllocationController
	 * @returnList<Allocation>
	 */
	@GetMapping (value=Appconstant.INITIATE_ALLOCATION)
	public @ResponseBody List<Allocation> initiateAllocation()
	{
		 return allocationService.initiateAllocation();
	}
	
	
	
	
	
	/**
	 * Method : findAllocationById AllocationController
	 * @param id
	 * @return Allocation
	 */
	@GetMapping(value=Appconstant.FIND_BY_ALLOCATION_BY_ID)
    public  @ResponseBody Allocation findAllocationById(@RequestHeader("id") Long id)
	
	{
    	return allocationService.findAllocationById(id);
	}
	
	
	
	
	
	
	
	/**
	 * Method : updateAllocationStatus in AllocationController
	 * @param allocationIdList
	 */
	@PostMapping(value=Appconstant.UPDATE_ALLOCATION_STATUS)
	public void  updateAllocationStatus(@RequestBody List<Long> allocationIdList)
	{
		
		 allocationService.updateAllocationStatus(allocationIdList);
		
	}
	
	
	
	
	
	
	
	/**
	 * Method : approveAllocation in AllocationController 
	 * @param allocationIdList
	 */
	@PostMapping(value=Appconstant.APPROVE_ALLOCATION)
	public void approveAllocation( @RequestBody List<Long> allocationIdList)
	{
		
		allocationService.updateAllocationStatus(allocationIdList);
	}
}
