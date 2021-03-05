//package com.example.learnings.edsl;
//
//import com.example.learnings.edsl.data.*;
//import com.example.learnings.edsl.services.MyDslPlanServiceImpl;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/test")
//@Slf4j
//public class TestController {
//
//    @Autowired
//    MyDslPlanServiceImpl myDslPlanService;
//
//    @RequestMapping(value = "/plans", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<DSLPlansWrapper> createTopUp(@RequestBody MyDslPlanRequest planRequest) throws Exception {
//        log.info("request ===================== {}",planRequest);
//       DSLPlansWrapper plansWrapper= myDslPlanService.getUpdatedDSLPlans(planRequest);
//        return new ResponseEntity<>(plansWrapper, HttpStatus.OK);
//    }
//
//
//
//
//}
