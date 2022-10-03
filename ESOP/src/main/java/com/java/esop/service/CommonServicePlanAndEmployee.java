package com.java.esop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.esop.dto.Plandto;
import com.java.esop.dto.Vestingdto;
import com.java.esop.entity.Employee;
import com.java.esop.entity.Plan;
import com.java.esop.repository.EmployeeRepository;
import com.java.esop.repository.PlanRepository;

/**
 * @author MURALI SANKAR
 *
 * Class : CommonServicePlanAndEmployee
 */
@Service
public class CommonServicePlanAndEmployee {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Autowired
	PlanRepository planRepository;
	
	
	
	/**
	 * Method : saveEmployeeDetails in  CommonServicePlanAndEmployee
	 * @param employee
	 */
	public void saveEmployeeDetails(Employee employee)
	{	
		employeeRepository.save(employee);
	}	

	
	
		
	
	
	/**
	 * @param plandto
	 * methos : preparePlan in CommonServicePlanAndEmployee
	 */
	public void preparePlan(Plandto plandto)
	{
		
		Plan plan= new Plan();
		plan.setYear(plandto.getYear());
		plan.setStartDate(plandto.getStartDate());
		plan.setActualEndDate(plandto.getActualEndDate());
		plan.setCurrentPlanYear(plandto.isCurrentPlanYear());
		plan.setVestingFactor(null);
		plan.setMonetizationDate(null);
		plan.setForeMarketValue(null);
		
		planRepository.save(plan);
		
		
	}
	
	
	
	
	
	/**
	 * method : findByPlanByPlanYear in CommonServicePlanAndEmployee
	 * @param year
	 * @return Plan
	 */
	public Plan findByPlanByPlanYear(String year)
	{
		
		return planRepository.findByPlanByPlanYear(year);
		
	}
	
	
	
	
	
	
	
	/**
	 * method : findByPlanId in CommonServicePlanAndEmployee
	 * @param id
	 * @return Plan
	 */
	public Plan findByPlanId(Long id)
	{
		
		return planRepository.findById(id).get();
		
	}
	
	
	
	
	
	/**
	 * method: startManetization in CommonServicePlanAndEmployee
	 * @param vestingdto
	 */
	public void startManetization(Vestingdto vestingdto)
	{
		
	      Plan plan=findByPlanByPlanYear(vestingdto.getYear());
	      plan.setVestingFactor(vestingdto.getVestingFactor());
	      plan.setMonetizationDate(vestingdto.getMonetizationDate());
	      plan.setForeMarketValue(vestingdto.getFareMarketValue());
	      
	      planRepository.save(plan);
		
		
	}
}
