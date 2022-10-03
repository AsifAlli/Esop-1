package com.java.esop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.java.esop.dto.Optiondto;
import com.java.esop.entity.Allocation;
import com.java.esop.entity.Grant;
import com.java.esop.entity.Plan;
import com.java.esop.entity.VestedOption;
import com.java.esop.jdbcTemplateModel.OptionDtoRowMapper;
import com.java.esop.repository.AllocationRepository;
import com.java.esop.repository.GrantRepository;
import com.java.esop.repository.VestedOptionRepository;

/**
 * @author MURALI SANKAR
 * 
 * Class:  AllocationService
 */
@Service
public class AllocationService { 
	
	@Autowired
	GrantRepository grantRepository;
	
	@Autowired
	AllocationRepository allocationRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	MonetizationService monetizationService;
	
	@Autowired
	VestedOptionRepository vestedOptionRepository; 
	
	
 
	
	

	/** Method Name: initiateAllocation
	 * @returnList<Allocation> 
	 */
	
	public List<Allocation> initiateAllocation()
	{
		
		List<Grant> grantlist=grantRepository.findBygrantStatusAndallocatinStatus("granted", false);
		
		List<Allocation> allocationlist= new ArrayList<>();
		
		Calendar now = Calendar.getInstance();
		
		
		  String[] array = {"A6", "A7", "A8", "A9", "A10"};
		  List<String> list = Arrays.asList(array);
		  
		  int count=1;  
		
		for(Grant grant:grantlist)
		{
			
			
			if(list.contains(grant.getBrand()))
			{ 
				for(int i=1;i<=5;i++)
				{
					Allocation allocation = new Allocation();
					allocation.setGrant(grant);
					allocation.setAllocationDate(""+now.get(Calendar.DATE)+"-"+now.get(Calendar.MONTH)+"-"+(now.get(Calendar.YEAR)+count));
					allocation.setStatus("pending");
					allocation.setAllocationNumber((double) (grant.getNumberOfGrante()/5));
					allocation.setAllocationYear(""+ (now.get(Calendar.YEAR)+ count++));
					allocationlist.add(allocation);
				}
				count=1;
			}
			
			else 
			{
				Allocation allocation = new Allocation();
				allocation.setGrant(grant);
				allocation.setAllocationDate(""+now.get(Calendar.DATE)+"-"+now.get(Calendar.MONTH)+"-"+(now.get(Calendar.YEAR)));
				allocation.setStatus("pending");
				allocation.setAllocationNumber((double) (grant.getNumberOfGrante()));
				allocation.setAllocationYear(""+(now.get(Calendar.YEAR)+1));
				allocationlist.add(allocation);
				
			}
			grant.setAllocatinStatus(true);
			grantRepository.save(grant);
			
		}
		
		allocationRepository.saveAll(allocationlist);
		return allocationlist;
		
		
	}
	
	
	
	
	
	public List<Optiondto> findAllocatedAllocationSumByPlan(String planyear)
	{
		
		String sql="""
				select esopdb.plan_info.id as plan_id, esopdb.grant_info.grant_id, esopdb.grant_info.employee_number, sum(esopdb.allocation_info.allocation_number)
				from esopdb.plan_info left join esopdb.grant_info
				on esopdb.grant_info.plan_id=esopdb.plan_info.id
				left join esopdb.allocation_info
				on esopdb.grant_info.id=esopdb.allocation_info.grant_id
				where esopdb.allocation_info.status ="APPROVED" and esopdb.plan_info.year="2021" group by esopdb.grant_info.grant_id; """;
		
		return jdbcTemplate.query(sql, new OptionDtoRowMapper());
		
	}
	
	
	
	
	public Allocation findAllocationById(Long id)
	
	{	
		return allocationRepository.findById(id).get();	
		
	}
	
	
	
	
	public void  updateAllocationStatus(List<Long> allocationIdList)
	{
		
		List<Allocation> allocationlist= new ArrayList();
		
		for(Long longid:allocationIdList)
		{
			
			Allocation allocation= findAllocationById(longid);
			allocation.setStatus("APPROVED");
			
			Grant grant=allocation.getGrant();
			Plan plan=grant.getPlan();
			
			if(monetizationService.isManetizationStarted(plan.getId()))
				{
					VestedOption vestedOption= monetizationService.findBygrantId(grant.getGrantId());
					
					if(vestedOption != null)
					{
						vestedOption.setVestedOption(vestedOption.getVestedOption()+( plan.getVestingFactor()*allocation.getAllocationNumber()));
						vestedOptionRepository.save(vestedOption);
						
					}
					else
					{
						
						VestedOption vestedOption2= new VestedOption();
						vestedOption2.setCreatedDate(new Date());
						vestedOption2.setMotifiedDate(new Date());
						vestedOption2.setGrantId(grant.getGrantId());
						vestedOption2.setVestedOption(plan.getVestingFactor()*allocation.getAllocationNumber());
						vestedOptionRepository.save(vestedOption2);
						
					}
					
               	}
			  
			        allocationRepository.save(allocation);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public Allocation findAllocationByGrantId(Grant grant)
	{
		
		return allocationRepository.findAllocationByGrantId(grant);
		
	}
	
	
	
	
	
	
	
	@Scheduled(cron = "0 */2 * ? * *")
	public void ScheduledThread()
	{
		
		Thread thread= new Thread()
				{
			
			@Override
			public void run() {
				System.out.println("Thread is Excuting");
				System.out.println("Scheduler is Working");
				initiateAllocation();
			}
				};
		   thread.start();
		
	}
	
	

}
