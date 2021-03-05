//package com.example.learnings.edsl.services;//package com.airtel.pe.eDSL.common.property;
//
//
//import com.example.learnings.edsl.data.ApplicationProperty;
//import com.example.learnings.edsl.data.BillPlanGrid;
//import com.example.learnings.edsl.data.CRMPlanConfig;
//import com.example.learnings.edsl.repo.ApplicationPropertyRepository;
//import com.example.learnings.edsl.repo.BillPlanGridRepository;
//import com.example.learnings.edsl.repo.CRMPlanConfigRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.CollectionUtils;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ApplicationPropertyImpl {
//
//    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationPropertyImpl.class);
//
//    Map<String, String> applicationPropertiesMap;
//
//
//    @Autowired
//    private ApplicationPropertyRepository applicationPropertyRepository;
//
//    @Autowired
//    private CRMPlanConfigRepository crmPlanConfigRepository;
//
//    @Autowired
//    private BillPlanGridRepository billPlanGridRepository;
//
//    @Transactional
//    public String getValueOfProperty(String key) {
//
//        LOGGER.info("Key in application property is {}",key);
//
//        if (CollectionUtils.isEmpty(applicationPropertiesMap)) {
//            applicationPropertiesMap = this.fetchPropertyFromDB();
//        }
//        String value = applicationPropertiesMap.get(key);
//        if(value==null){
//            applicationPropertiesMap = this.fetchPropertyFromDB();
//        }
//
//        LOGGER.info("key ==  {}, value==  {}",key,value);
//        return applicationPropertiesMap.get(key);
//    }
//
//    @Transactional
//    public Map<String, String> fetchPropertyFromDB() {
//
//        LOGGER.info("Fetching property from database");
//        Map<String, String> applicationProperties = new HashMap<>();
//        List<ApplicationProperty> applicationproperties = applicationPropertyRepository.findAll();
//
//        long max=0;
//        LOGGER.info("Application properties is {} ", applicationProperties.toString() );
//        for (ApplicationProperty applicationProperty : applicationproperties) {
//            applicationProperties.put(applicationProperty.getKey(), applicationProperty.getValue());
//            max=Math.max(max,applicationProperty.getId());
//        }
//
//
//        return applicationProperties;
//    }
//
//
//
//    @Transactional
//    public Map<String, Integer> fetchBillPlanDetails() {
//        LOGGER.info("Fetching plan Details from database");
//        Map<String, Integer> crmPlanmap = new HashMap<>();
//        List<CRMPlanConfig> crmPlanConfig = crmPlanConfigRepository.findAll();
//
//        crmPlanConfig.stream().forEach(crmPlan -> {
//            crmPlanmap.put(crmPlan.getPlanId(), crmPlan.getNrcAmount());
//        });
//
//        return crmPlanmap;
//    }
//
//
//    @Transactional
//    public Map<Integer, BillPlanGrid> fetchBillPlanGrid() {
//        LOGGER.info("Fetching plan grid from database");
//        Map<Integer, BillPlanGrid> planGridMap = new HashMap<>();
//        List<BillPlanGrid> planGridConfig = billPlanGridRepository.findAll();
//
//        planGridConfig.stream().forEach(planGrid -> {
//            planGridMap.put(planGrid.getMinDistance(), planGrid);
//        });
//        return planGridMap;
//    }
//
//}