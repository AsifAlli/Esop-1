package com.java.esop.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.esop.dto.Grantdto;
import com.java.esop.entity.Grant;
import com.java.esop.entity.Plan;
import com.java.esop.repository.GrantRepository;

/**
 * @author MURALI SANKAR
 * Class : GrantService
 *
 */
@Service
public class GrantService {

	@Autowired
	GrantRepository grantRepository;
	
	@Autowired
	AllocationService allocationService;
	
	@Autowired
	CommonServicePlanAndEmployee CommonServicePlanAndEmployee;
	
	
	
     /**7
     * @param grantdto
     * method name: processUploadGrante
     * return type : void
     */
    public void processUploadGrante(List<Grantdto> grantdto)
     {
    	 List<Grant> grantlist=prepareGrants(grantdto);
    	 grantRepository.saveAll(grantlist);
    	 
     }
    
    
    
    
     
     /**
     * @param grantdto
     * method name: prepareGrants
     * @return List<Grant>
     */
    private List<Grant> prepareGrants(List<Grantdto> grantdto)
     {
    	 
    	 
    	 List<Grant> grant= new ArrayList<Grant> ();
    
	     
	     for(Grantdto grantdtol:grantdto)
	     {
	    	 Grant grantlist= new Grant();
	    	 
	    	 Plan plan=CommonServicePlanAndEmployee.findByPlanId(grantdtol.getPlanid());
	    	 
	    	 grantlist.setPlan(plan);
	    	 grantlist.setGrantId(grantdtol.getGrantId());
	    	 grantlist.setEmployeeNumber(grantdtol.getEmployeeNumber());
	    	 grantlist.setBrand(grantdtol.getBand());
	    	 grantlist.setNumberOfGrante(grantdtol.getNumberofGrante());
	    	 grantlist.setGrantPrice(grantdtol.getGrantePrice());
	    	 grantlist.setGrantStatus("granted");
	    	 grantlist.setAcceptedDate(new Date());
	    	 grantlist.setGrantedDate(new Date());
	    	 grantlist.setAccepted(true);
	    	 grantlist.setAllocatinStatus(false);
	    	 grant.add(grantlist);	    	
	     }
	     
    	  for(Grant list:grant)System.out.println(list);
    	  return grant; 
     }
    
    
    
    
    
    
    
    
    
    /**
     * Method Name: approveGrant in GrantService
     * @param grantIdList
     */
    public void approveGrant(List<String> grantIdList)
	{
	   
       for(String id:grantIdList)
       {
    	   
    	   Grant grant=findBygrantIdDetails(id);
    	   grant.setGrantStatus("Granted");
    	   grant.setAllocatinStatus(false);
    	   grant.setNumberOfGrante(500L);
    	   grantRepository.save(grant);
       
       }
    	
	}
    
    
    
    
    
    
    
    /**
     * Method name : findBygrantIdDetails  in GrantService
     * @param grantId
     * @return Grant
     */
    public Grant findBygrantIdDetails(String grantId)
	{
		
		Grant grant= grantRepository.findBygrantId(grantId);
		return grant;
	}
    
    
    
    
    
    
    
    
    
    /**
     * method Name: acceptGrant in GrantService
     * @param grantId
     */
    public void acceptGrant(String grantId)
	{
	
    	Grant grant= grantRepository.findBygrantId(grantId);
    	grant.setAccepted(true);
    	grantRepository.save(grant);
    	
	}
    
    
    
    
    
    
    
    
    /**
     * method Name: findByGrantStatusAndAllocationStatusDetails in GrantService
     * @param grantStatus
     * @param allocatinStatus
     * @return List<Grant>
     */
    public List<Grant> findByGrantStatusAndAllocationStatusDetails(String grantStatus,boolean allocatinStatus)
    {
    	
    	return grantRepository.findBygrantStatusAndallocatinStatus(grantStatus, allocatinStatus);
    	
    }
    
    
	
    
    public List<Grant> findByGrantsUsingPlanId(Plan plan)
    {
    	return grantRepository.findByGrantsUsingPlanId(plan);
    	
    }
    
    
}
			