//package com.example.learnings.edsl.services;//package com.airtel.pe.eDSL.acquisition.service.Helper;
//
//
//import com.example.learnings.edsl.data.*;
//import com.example.learnings.edsl.repo.PincodeMasterRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.http.client.utils.URIBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.CacheManager;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class MyDslPlanServiceHelper {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MyDslPlanServiceHelper.class);
//
//
//    @Autowired
//    private ApplicationPropertyImpl applicationProperties;
//
//    @Autowired
//    private PincodeMasterRepository pincodeMasterRepository;
//
//
//    @Autowired
//    private ESBAdapterImpl esbAdapterImpl;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @Autowired
//    private CacheManagerImpl cacheManager;
//
//
//
////    public FetchBillPlanDetails getFetchBillPlanDetailsFromApi(MyDslPlanRequest myDslPlanRequest,
////                                                        FetchBillPlanDetails fetchBillPlanDetails) throws URISyntaxException,
////                                                                                                        java.io.IOException {
////        String crmCircle = " ";
////        String userName = applicationProperties.getValueOfProperty("dslplan.username");
////        String password = applicationProperties.getValueOfProperty("dslplan.password");
////        String dslPlanURL = applicationProperties.getValueOfProperty(PropertyNames.DSL_BILL_PLAN_URL_NEW);
////
////        LOGGER.info("Inside getFetchBillPlanDetailsFromApi dslPlanURL :"+dslPlanURL);
////        try {
////            crmCircle = pincodeMasterRepository
////                    .findcrmCircle((Long.valueOf(myDslPlanRequest.getInstallAddressPinCode())));
////        } catch (Exception e) {
////            LOGGER.info("No data found in PinCode_Master for Fetch Bill Plan API  {}",
////                    myDslPlanRequest.getInstallAddressPinCode());
////            throw new CommonEdslRuntimeException(ResponseErrorCode.NO_DATA_FOUND);
////        }
////
////        if (null == crmCircle) {
////            LOGGER.info("No data found in PinCode_Master for Fetch Bill Plan API  {}",
////                    myDslPlanRequest.getInstallAddressPinCode());
////            throw new CommonEdslRuntimeException(ResponseErrorCode.NO_DATA_FOUND);
////        }
////       String crmDslTech=getCrmDslTech(myDslPlanRequest.getDslTech());
////
////        URIBuilder uriBuilder = new URIBuilder(dslPlanURL);
////        uriBuilder.addParameter("circle", crmCircle).addParameter("speed", myDslPlanRequest.getSpeed())
////                .addParameter("dslTech", crmDslTech)
////                .addParameter("rsu", myDslPlanRequest.getRsu());
////        URI uri = uriBuilder.build();
////        LOGGER.info("DSL BILL PLAN ESB URL IS {} crmDslTech {}", uri,crmDslTech);
////
////        ResponseEntity<FetchBillPlanDetails> responseEntity = esbAdapterImpl.getResponseFromESB(uri, userName,
////                password, FetchBillPlanDetails.class);
////        if (null != responseEntity) {
////            fetchBillPlanDetails = responseEntity.getBody();
////            if (fetchBillPlanDetails != null) {
////                if (fetchBillPlanDetails.getGetProspectiveBillPlansForCustomerResMsg() != null) {
////                    cacheManager.putValues(StringUtils.join(new String[]{CacheKey.FETCHED_PLANS.getCacheKey(),
////                                    myDslPlanRequest.getDslTech(), myDslPlanRequest.getInstallAddressPinCode(),
////                                    myDslPlanRequest.getRsu(), myDslPlanRequest.getSpeed()}, ","),
////                            fetchBillPlanDetails, CacheName.PLANS_CACHE);
////
////                    LOGGER.info(" Json response for DSL Plan  :{}", mapper.writeValueAsString(fetchBillPlanDetails));
////                }
////            } else {
////                throw new EDSLBaseRuntimeException(ResponseErrorCode.SERVICE_NOT_AVAILABLE);
////            }
////        }
////        return fetchBillPlanDetails;
////    }
//
//    public FetchBillPlanDetails getUpdatedFetchBillPlanDetailsFromCache(MyDslPlanRequest myDslPlanRequest) {
//        LOGGER.info("REQUEST_INITIATED for DSL BILL PLAN with speed {} ,dslTech {} and Rsu {}",
//                myDslPlanRequest.getSpeed(), myDslPlanRequest.getDslTech(), myDslPlanRequest.getRsu());
//
//        FetchBillPlanDetails fetchBillPlanDetails = null;
//
//        String cacheKey = null;
//        CacheName cacheName = null;
//        if (myDslPlanRequest.getAgentType() != null && myDslPlanRequest.getAgentType().equalsIgnoreCase(DSLConstant.LCO_AGENT)) {
//            cacheKey = CacheKey.LCO_FETCHED_PLANS.getCacheKey();
//            cacheName = CacheName.LCO_PLAN_CACHE;
//        } else {
//            cacheKey = CacheKey.FETCHED_PLANS.getCacheKey();
//            cacheName = CacheName.PLANS_CACHE;
//        }
//
//        LOGGER.info("cache key and cache name are:..." + cacheKey + "....and...." + cacheName);
//
//        fetchBillPlanDetails = (FetchBillPlanDetails) cacheManager.getValue(
//                StringUtils.join(new String[]{cacheKey,
//                        myDslPlanRequest.getDslTech(), myDslPlanRequest.getInstallAddressPinCode(),
//                        myDslPlanRequest.getRsu(), myDslPlanRequest.getSpeed()}, ","),
//                cacheName);
//        return fetchBillPlanDetails;
//    }
//
//
//
//
//	public FetchBillPlanDetails getUpdatedFetchBillPlanDetailsFromApi(MyDslPlanRequest myDslPlanRequest,
//                                                               FetchBillPlanDetails fetchBillPlanDetails)
//                                                                throws URISyntaxException, java.io.IOException {
//
//
//        LOGGER.info("In fetch Bill plan function");
//        String crmCircle = " ";
//        String userName = applicationProperties.getValueOfProperty("dslplan.username");
//        String password = applicationProperties.getValueOfProperty("dslplan.password");
//        String dslPlanURL = applicationProperties.getValueOfProperty(PropertyNames.DSL_BILL_PLAN_URL_NEW);
//
//        LOGGER.info("Inside getUpdatedFetchBillPlanDetailsFromApi dslPlanURL :"+dslPlanURL);
//        try {
//            crmCircle = pincodeMasterRepository
//                    .findcrmCircle((Long.valueOf(myDslPlanRequest.getInstallAddressPinCode())));
//        } catch (Exception e) {
//            LOGGER.info("No data found in PinCode_Master for Fetch Bill Plan API  {}",
//                    myDslPlanRequest.getInstallAddressPinCode());
//            throw new CommonEdslRuntimeException(ResponseErrorCode.NO_DATA_FOUND);
//        }
//
//        if (null == crmCircle) {
//            LOGGER.info("No data found in PinCode_Master for Fetch Bill Plan API  {}",
//                    myDslPlanRequest.getInstallAddressPinCode());
//            throw new CommonEdslRuntimeException(ResponseErrorCode.NO_DATA_FOUND);
//        }
//
//        String customerType = null;
//        String customerClass = null;
//
//        if (myDslPlanRequest.getAgentType() != null && myDslPlanRequest.getAgentType().equalsIgnoreCase(DSLConstant.LCO_AGENT)) {
//            customerType = DslCustomerType.CONSUMER_CUSTOMER_TYPE.getValue();
//            customerClass = DslCustomeClassType.ADVANCE_CUSTOMER_CLASS.getValue();
//        }
//
//        String crmDslTech=getCrmDslTech(myDslPlanRequest.getDslTech());
//
//        if(StringUtils.isEmpty(crmDslTech)) {
//        	LOGGER.info(" Blank crmDslTech {} myDslPlanRequest.getDslTech() {} ",crmDslTech,myDslPlanRequest.getDslTech());
//        	crmDslTech=myDslPlanRequest.getDslTech();
//        }
//
//        URIBuilder uriBuilder = new URIBuilder(dslPlanURL);
//        uriBuilder.addParameter("circle", crmCircle).addParameter("speed", myDslPlanRequest.getSpeed())
//                .addParameter("dslTech", crmDslTech)
//               .addParameter("rsu", myDslPlanRequest.getRsu());
//        if (customerClass != null && customerType != null) {
//            uriBuilder.addParameter("custType", customerType)
//                    .addParameter("custClass", customerClass);
//        }
//
//        URI uri = uriBuilder.build();
//        LOGGER.info("DSL BILL PLAN ESB URL IS {} crmDslTech {}", uri,crmDslTech);
//        //Creating sample uri
//      //  String s="http://10.5.247.h126:8011/services/product/manageproductofferinginventorycapture/prospectivebillplansforcustomer/v1_5?domain=B2C&programmeName=Aadhar-Telemedia&lob=Telemedia&consumerTransactionId=Sayyed123&consumerName=ecaf&productType=FLVOICE,FLDSL&orderType=NEW&circle=17&speed=307200&dslTech=FTTH Own";
//        //URI uri1=URI.create(s);
//
//        ResponseEntity<FetchBillPlanDetails> responseEntity = esbAdapterImpl.getResponseFromESB(uri, userName,
//                password, FetchBillPlanDetails.class);
//        System.out.println("response entity");
//        if (null != responseEntity) {
//            fetchBillPlanDetails = responseEntity.getBody();
//            if (fetchBillPlanDetails != null) {
//                if (fetchBillPlanDetails.getGetProspectiveBillPlansForCustomerResMsg() != null) {
//                    String cacheKey = null;
//                    CacheName cacheName = null;
//                    if (myDslPlanRequest.getAgentType() != null && myDslPlanRequest.getAgentType().equalsIgnoreCase(DSLConstant.LCO_AGENT)) {
//                        cacheKey = CacheKey.LCO_FETCHED_PLANS.getCacheKey();
//                        cacheName = CacheName.LCO_PLAN_CACHE;
//                    } else {
//                        cacheKey = CacheKey.FETCHED_PLANS.getCacheKey();
//                        cacheName = CacheName.PLANS_CACHE;
//                    }
////
////                    LOGGER.info("cache key and cache name are:..." + cacheKey + "....and...." + cacheName);
////                    cacheManager.putValues(StringUtils.join(new String[]{cacheKey,
////                                    myDslPlanRequest.getDslTech(), myDslPlanRequest.getInstallAddressPinCode(),
////                                    myDslPlanRequest.getRsu(), myDslPlanRequest.getSpeed()}, ","),
////                            fetchBillPlanDetails, cacheName);
//
//                    LOGGER.info(" Json response for DSL Plan  :{}", mapper.writeValueAsString(fetchBillPlanDetails));
//                }
//            } else {
//                throw new EDSLBaseRuntimeException(ResponseErrorCode.SERVICE_NOT_AVAILABLE);
//            }
//        }
//        return fetchBillPlanDetails;
//    }
//
//
//    private String getCrmDslTech(String dslTech) {
//    	try {
//			String dslTechConfigList=applicationProperties.getValueOfProperty(PropertyNames.EDSL_CRM_TECH_CONFIG_LIST);
//			if(StringUtils.isEmpty(dslTechConfigList)) {
//				return dslTech;
//			}
//			LOGGER.info(" getCrmDslTech dslTech {} dslTechConfigList {}",dslTech,dslTechConfigList);
//			List<String> list=Arrays.asList(dslTechConfigList.split(";")); // VECTOR:VECTOR;FTTH OWN:FTTH Own,FTTH PARTNER:FTTH Partner
//			Map<String, String> map=new HashMap<String, String>();
//
//			for (String dlsTechValue : list) {
//				map.put(dlsTechValue.split(":")[0], dlsTechValue.split(":")[1]);
//			}
//			LOGGER.info(" getCrmDslTech dslTech {} dslTechConfigList {} map {} ",dslTech,dslTechConfigList,map);
//
//			return map.get(dslTech.toUpperCase());
//		} catch (Exception e) {
//			LOGGER.error(" getCrmDslTech @error  ",e);
//			return dslTech;
//
//		}
//	}
//
//}
