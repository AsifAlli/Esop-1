package com.java.esop.appconstant;

/**
 * @author MURALI SANKAR
 * Interface Name: Appconstant
 */
public interface Appconstant {
	
	//Tables Name
	public static String PLAN_INFO="plan_info";
	public static String EMPLOYEE_INFO="employee_info";
	public static String GRANT_INFO="grant_info";
	public static String ALLOCATION_INFO="allocation_info";
	public static String VESTED_OPTION_INFO="vested_option_info";	
	
	
	//Controller Names
	public static String GRANT_CONTROLLER="/grant_controller";
	public static String COMMON_CONTROLLER_PLAN_AND_EMPLOYEE="/CommomControllerPlanAndEmployee";
	public static String ALLOCATION_CONTROLLER="/allocation_controller";
	
	
	//Methods Names
	public static String SAVE_EMPLOYEE_DETAILS="/saveEmployeeDetails";
	public static String UPLOAD_GRANTE="/uploadGrante";
	public static String APPROVE_GRANT="/approveGrant";
	public static String FIND_BY_ID="/findBygrantId";
	public static String ACCEPT_GRANT="/acceptGrant";
	public static String FINDBY_GRANTSTATUS_ALLOCATIONSATUS_DETAILS="/findByGrantStatusAndAllocationStatusDetails";
	public static String INITIATE_ALLOCATION="/initiateAllocation";
    public static String PREPARE_PLAN="/preparePlan";
    public static String FIND_BY_PLAN_BY_PLANYEAR="/findByPlanByPlanYear";
    public static String FIND_BY_PLAN_ID="/findByPlanId";
    public static String START_MANETIZATION="/startManetization";
	public static String PREPARE_VESTED_OPTION="/prepareVestedOption";
	public static String FIND_BY_ALLOCATION_BY_ID="/findAllocationById";
	public static String UPDATE_ALLOCATION_STATUS="/updateAllocationStatus";
	public static String FIND_BY_GRANTS_USING_PLANID="/findByGrantsUsingPlanId";
	public static String ISMANETIZATION_STARTED="/isManetizationStarted";
	public static String APPROVE_ALLOCATION="/approveAllocation";
	
	
}
