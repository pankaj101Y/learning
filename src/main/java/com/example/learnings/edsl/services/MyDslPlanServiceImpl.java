//package com.example.learnings.edsl.services;
//
//
//import com.example.learnings.edsl.data.*;
//import com.example.learnings.edsl.repo.ActivationCostRepository;
//import com.example.learnings.edsl.repo.PincodeMasterRepository;
//import com.example.learnings.edsl.utility.Utility;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.ResourceAccessException;
//
//import java.net.ConnectException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class MyDslPlanServiceImpl{
//
//	@Autowired
//	private ESBAdapterImpl esbAdapterImpl;
//
//	@Autowired
//	private ApplicationPropertyImpl applicationProperties;
//
//	@Autowired
//	private CacheManagerImpl cacheManager;
//
//
//
//	//	@Value(value = "${dsl.plan.url}")
//	private String plan_url;
//
//	@Autowired
//	private PincodeMasterRepository pincodeMasterRepository;
//
//
//	@Autowired
//	private MyDslPlanServiceHelper myDslPlanServiceHelper;
//
//	@Autowired
//	private ObjectMapper mapper;
//
//	@Autowired
//	private ActivationCostRepository activationCostRepository;
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(MyDslPlanServiceImpl.class);
//
//	public DSLPlansWrapper getUpdatedDSLPlans(MyDslPlanRequest myDslPlanRequest) throws Exception {
//		List<MyDslPlanBean> myPlanDslBean = null;
//
//		try {
//			// Change FetchBillPlanResponse
//			// Add fields to MyDSLPlanBean
//			FetchBillPlanDetails fetchBillPlanDetails=null;// myDslPlanServiceHelper.getUpdatedFetchBillPlanDetailsFromCache(myDslPlanRequest);
//
//			if (fetchBillPlanDetails != null) {
//				LOGGER.info("Data returned from cache for speed {} ,dslTech {} and Rsu {}", myDslPlanRequest.getSpeed(),
//						myDslPlanRequest.getDslTech(), myDslPlanRequest.getRsu());
//				LOGGER.info(" Json response for DSL Plan :{}", mapper.writeValueAsString(fetchBillPlanDetails));
//			} else {
//				LOGGER.info("In the function getUpdatedDSLPlans");
//
//				fetchBillPlanDetails = myDslPlanServiceHelper.getUpdatedFetchBillPlanDetailsFromApi(myDslPlanRequest,
//						fetchBillPlanDetails);
//			}
//			if (fetchBillPlanDetails != null
//					&& fetchBillPlanDetails.getGetProspectiveBillPlansForCustomerResMsg() != null) {
//			// parse Response for EDSL Plan interface
//				LOGGER.info("getUpdatedDSLPlans myDslPlanRequest {} " , myDslPlanRequest);
//
//				List<String> eligibityIdentifiers = setEligibilityIdentifiers(myDslPlanRequest);
//
//				LOGGER.info("Insdie fetch plan identifiers : {} category {} source {} " , eligibityIdentifiers,myDslPlanRequest.getCategory(), myDslPlanRequest.getSource());
//				myPlanDslBean = MyDslPlanAdapter.parseResponseForDslPlans(fetchBillPlanDetails,
//						applicationProperties.fetchBillPlanDetails(), applicationProperties.fetchBillPlanGrid(),
//						myDslPlanRequest.getDistance(), myDslPlanRequest.getAgentType(), myDslPlanRequest.getSource(),eligibityIdentifiers);
//
////                            MyDslPlanAdapter2.parseResponseForDslPlans2(fetchBillPlanDetails,
////							applicationProperties.fetchBillPlanDetails(), applicationProperties.fetchBillPlanGrid(),
////							myDslPlanRequest.getDistance(),myDslPlanRequest.getAgentType());
//				LOGGER.info("Parsed Response with added fields for My DSL Plan API {}",
//						mapper.writeValueAsString(myPlanDslBean));
//
//				// LOGGER.info("sorting plans");
//				Collections.sort(myPlanDslBean, new BillPlanComparator().reversed());
//				LOGGER.info("plans sorted......." + myDslPlanRequest.getInstallAddressPinCode());
//			} else {
//				throw new EDSLBaseRuntimeException(ResponseErrorCode.FAULT_INVALID, fetchBillPlanDetails.getFault()
//						.getDetail().getGetProspectiveBillPlansForCustomerFault().getSoaFault().getFaultDescription());
//			}
//
//		} catch (EDSLBaseRuntimeException e) {
//			LOGGER.error(" getUpdatedDSLPlans EDSLBaseRuntimeException", e.getMessage(), e);
//			throw e;
//		} catch (ResourceAccessException | ConnectException e) {
//			LOGGER.error(" getUpdatedDSLPlans ConnectException @error: {} ", e.getMessage(), e);
//			throw new ConnectionException(ResponseErrorCode.SYSTEM_NOT_WORKING, e.getMessage());
//		} catch (Exception e) {
//			LOGGER.error(" getUpdatedDSLPlans Exception", e.getMessage(), e);
//			throw new EDSLBaseRuntimeException(ResponseErrorCode.INTERNAL_SERVICE_ERROR, e.getMessage());
//		}
//
//		DSLPlansWrapper dslPlanWrapper = new DSLPlansWrapper(myPlanDslBean);
//		ActivationCost activationCost = activationCostRepository
//				.findByPincodeAndType(myDslPlanRequest.getInstallAddressPinCode(),
//						(DSLConstant.LCO_AGENT.equalsIgnoreCase(myDslPlanRequest.getAgentType()))
//								? DSLConstant.ORDERTYPE.LCO
//								: DSLConstant.ORDERTYPE.OTHER);
//
//		if (null != activationCost) {
//			if (null != myDslPlanRequest.getDslTech() && (Utility.removeAllSpaces(myDslPlanRequest.getDslTech())
//					.equalsIgnoreCase(Utility.removeAllSpaces("FTTH Own"))
//					|| Utility.removeAllSpaces(myDslPlanRequest.getDslTech())
//							.equalsIgnoreCase(Utility.removeAllSpaces("FTTH Partner")))) {
//				dslPlanWrapper.setActivationCost(Double.toString(activationCost.getFtth()));
//				dslPlanWrapper.setArpActivationCost(Double.toString(activationCost.getArpFtth()));
//			} else {
//				dslPlanWrapper.setActivationCost(Double.toString(activationCost.getCopper()));
//				dslPlanWrapper.setArpActivationCost(Double.toString(activationCost.getArpCopper()));
//			}
//		} else {
//			throw new EDSLBaseRuntimeException(ResponseErrorCode.ACTIVATION_COST_PINCODE_ERROR);
//		}
//		return dslPlanWrapper;
//	}
//
//
//	private List<String> setEligibilityIdentifiers( MyDslPlanRequest myDslPlanRequest) throws EDSLBaseRuntimeException{
//		List<String> eligibityIdentifiers = new ArrayList<>();
//
//	if(StringUtils.isBlank(myDslPlanRequest.getCategory())) {
//			eligibityIdentifiers = Arrays.asList(
//					applicationProperties.getValueOfProperty(PropertyNames.PLANS_ELIGIBLE_IDENTIFIERS).split(","));
//		LOGGER.info("setEligibilityIdentifiers myDslPlanRequest after {} " , eligibityIdentifiers);
//		return eligibityIdentifiers;
//	}else{
//			LOGGER.info("setEligibilityIdentifiers eligibityIdentifiers {}  and category {}" , eligibityIdentifiers,myDslPlanRequest.getCategory());
//			String categoryList=applicationProperties.getValueOfProperty(PropertyNames.ELIGIBLILITY_CATEGORY_SOURCES_LIST);
//
//			if(StringUtils.isBlank(categoryList)){
//				throw new EDSLBaseRuntimeException(ResponseErrorCode.SOURCE_ELIGIBILITY_MAPPING_NOT_EXIST);
//			}
//
//			List<String> eligibilityCategoryList = Arrays.asList(categoryList.split(","));
//			String inputCategory = myDslPlanRequest.getCategory().trim();
//			inputCategory=inputCategory.toLowerCase();
//
//			for(String category : eligibilityCategoryList){
//				if(inputCategory.equalsIgnoreCase(category)){
//					eligibityIdentifiers = Arrays.asList(
//							applicationProperties.getValueOfProperty(PropertyNames.PLANS_ELIGIBLE_IDENTIFIERS+"."+inputCategory).split(","));
//					LOGGER.info("input category is : "+inputCategory+ " and eligibility identifiers list is : {} ",eligibityIdentifiers);
//					break;
//				}
//			}
//			if(eligibityIdentifiers.size()==0){
//				//throw new EDSLBaseRuntimeException(ResponseErrorCode.SOURCE_ELIGIBILITY_MAPPING_NOT_EXIST.getCode(), ResponseErrorCode.SOURCE_ELIGIBILITY_MAPPING_NOT_EXIST.getDescription());
//				throw new EDSLBaseRuntimeException(ResponseErrorCode.SOURCE_ELIGIBILITY_MAPPING_NOT_EXIST);
//			}
//		return eligibityIdentifiers;
//		}
//	}
//}