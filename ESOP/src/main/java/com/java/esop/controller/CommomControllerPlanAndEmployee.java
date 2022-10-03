package com.java.esop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.esop.appconstant.Appconstant;
import com.java.esop.dto.Plandto;
import com.java.esop.dto.Vestingdto;
import com.java.esop.entity.Employee;
import com.java.esop.entity.Plan;
import com.java.esop.service.CommonServicePlanAndEmployee;
import com.java.esop.service.MonetizationService;

@RestController
@RequestMapping(value=Appconstant.COMMON_CONTROLLER_PLAN_AND_EMPLOYEE)
public class CommomControllerPlanAndEmployee {
	
	@Autowired
	CommonServicePlanAndEmployee commonServicePlanAndEmployee;
	
	
	@Autowired
	MonetizationService monetizationService;
	
	
	
	@PostMapping(value=Appconstant.SAVE_EMPLOYEE_DETAILS)
	public void saveEmployeeDetails( @RequestBody Employee employee)
	{
		
		commonServicePlanAndEmployee.saveEmployeeDetails(employee);
	}

	
	
	@PostMapping(value=Appconstant.PREPARE_PLAN)
	public void preparePlan( @RequestBody Plandto plandto)
	{
		commonServicePlanAndEmployee.preparePlan(plandto);
	}
	
	
	
	
	@GetMapping(value=Appconstant.FIND_BY_PLAN_BY_PLANYEAR)
	public @ResponseBody Plan findByPlanByPlanYear( String year)
	{
		
		return commonServicePlanAndEmployee.findByPlanByPlanYear(year);
	}
	
	
	
	@GetMapping(value=Appconstant.FIND_BY_PLAN_ID)
	public @ResponseBody Plan findByPlanId(Long id)
	{
		return commonServicePlanAndEmployee.findByPlanId(id);
		
	}
	
	
	@PutMapping(value=Appconstant.START_MANETIZATION)
	public void startManetization(@RequestBody Vestingdto vestingdto)
	{
	
		commonServicePlanAndEmployee.startManetization(vestingdto);
	}
	
	
	@PostMapping(value=Appconstant.PREPARE_VESTED_OPTION)
	public void prepareVestedOption(@RequestBody Vestingdto vestingdto )
	{
		monetizationService.prepareVestedOption(vestingdto);
		
	}
	
	@GetMapping(value=Appconstant.ISMANETIZATION_STARTED) 
	public @ResponseBody void isManetizationStarted( Long planId)
	{
		monetizationService.isManetizationStarted(planId);
	}
	

}
