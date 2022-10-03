package com.java.esop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.java.esop.appconstant.Appconstant;
import com.java.esop.dto.Grantdto;
import com.java.esop.entity.Grant;
import com.java.esop.entity.Plan;
import com.java.esop.service.GrantService;


/**
 * @author MURALI SANKAR
 * Class : GrantController
 *
 */
@RestController
@RequestMapping(value=Appconstant.GRANT_CONTROLLER)
public class GrantController {
	
	@Autowired
	GrantService grantService;
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(GrantController.class);
	
	
	
	
	
	
	/**
	 * @param grantdto
	 * Method Name:uploadGrante
	 * Return type: void
	 */
	@PostMapping(value=Appconstant.UPLOAD_GRANTE)
	public void uploadGrante(@RequestBody List<Grantdto> grantdto)
	{
		
		try {
			
			grantService.processUploadGrante(grantdto);
			LOGGER.info("inside GrantController uploadGrante() method has been Excuted"+grantdto);
			
		    }
		
		catch (Exception e)
			{
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Method Name:uploadGrante
	 * @param grantIdList
	 * Return type: void
	 */
	@PostMapping(value=Appconstant.APPROVE_GRANT)
	public void approveGrant( @RequestBody List<String> grantIdList)
	{
		try {
			
			grantService.approveGrant(grantIdList);
			LOGGER.info("inside GrantController approveGrant() method has been Excuted"+grantIdList);
			
		} 
		catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
		}
	}
	
	

	
	
	
	
	
	
	
	

	/**
	 * Method Name:findBygrantId
	 * @param grantId
	 * @return Grant
	 */
	@GetMapping(value=Appconstant.FIND_BY_ID)
	public @ResponseBody Grant  findBygrantId( @RequestHeader("grantId") String grantId)
	{
		
		try {
			
			
			LOGGER.info("inside GrantController findBygrantId() method has been Excuted"+grantId);
			
		} catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
		}
		
		return grantService.findBygrantIdDetails(grantId);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * method Name:acceptGrant
	 * @param grantId
	 * Return type: void
	 */
	@PostMapping(value=Appconstant.ACCEPT_GRANT)
	public void acceptGrant(@RequestHeader("grandId")String grantId)
	{
		try {
			
			grantService.acceptGrant(grantId);
			LOGGER.info("inside GrantController acceptGrant() method has been Excuted"+grantId);
			
			
		} catch (Exception e) {
			
		}
	}

	
	
	
	
	
	

	/**
	 * method Name:findByGrantStatusAndAllocationStatusDetails
	 * @param grantStatus
	 * @param allocatinStatus
	 * @return List<Grant>
	 */
	@GetMapping(value=Appconstant.FINDBY_GRANTSTATUS_ALLOCATIONSATUS_DETAILS)
	public @ResponseBody List<Grant>  findByGrantStatusAndAllocationStatusDetails(String grantStatus,boolean allocatinStatus)
	{  
	 
		return grantService.findByGrantStatusAndAllocationStatusDetails(grantStatus, allocatinStatus);
	}

	
	
	
	
	@GetMapping(value=Appconstant.FIND_BY_GRANTS_USING_PLANID)
	public @ResponseBody List<Grant> findByGrantsUsingPlanId(Plan plan)
    {
	
		return grantService.findByGrantsUsingPlanId(plan);
	    	
	}
}
