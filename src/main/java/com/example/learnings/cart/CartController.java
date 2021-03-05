//package com.example.learnings.cart;
//
//
//import com.google.gson.Gson;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/test")
//@Slf4j
//public class CartController {
//
//
//    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createTopUp(@RequestBody CartSubItemDiscoveryRequest wrapper) throws Exception {
//        Gson gson=new Gson();
//        log.info("json = {} ",gson.toJson(wrapper));
//
//        Object obj=wrapper.getCartSubItemsDTO().getCartSubItemAttributes().get("dthAttributes");
//
//        Map<String,Object> dthAttrs=(Map<String,Object>)obj;
//        log.info("map= {}",dthAttrs);
//        log.info("map= {}",dthAttrs.get("dthCartSummaryData"));
//
//        for (String key:dthAttrs.keySet()){
//            log.info("key {}",key);
//            log.info("value {}",dthAttrs.get(key));
//        }
//    }
//
//}
