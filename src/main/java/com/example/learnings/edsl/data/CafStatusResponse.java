//package com.example.learnings.edsl;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//
//@lombok.Data
//public class CafStatusResponse {
//
//     GetCustomerOrderStatusResMsg getCustomerOrderStatusResMsg;
//
//    @lombok.Data
//    public static class GetCustomerOrderStatusResMsg {
//
//        @JsonProperty("ebmHeader")
//        EbmHeader ebmHeader;
//        @JsonProperty("dataArea")
//        DataArea dataArea;
//
//    }
//
//    @lombok.Data
//    public static class DataArea {
//
//        @JsonProperty("getCustomerOrderStatusResponse")
//        GetCustomerOrderStatusResponse getCustomerOrderStatusResponse;
//
//    }
//
//    @lombok.Data
//    public static class GetCustomerOrderStatusResponse {
//
//        @JsonProperty("customerOrder")
//        CustomerOrder customerOrder;
//        @JsonProperty("status")
//        Status status;
//        @JsonProperty("logicalResource")
//        Object logicalResource;
//    }
//
//    public static class Status {
//
//        @JsonProperty("statusCode")
//        String statusCode;
//        @JsonProperty("statusDescription")
//        String statusDescription;
//
//    }
//
//    @Data
//    public static class CustomerOrder {
//
//        @JsonProperty("customerOrderIdentification")
//        CustomerOrderIdentification customerOrderIdentification;
//        @JsonProperty("orderAssignedDate")
//        String orderAssignedDate;
//        @JsonProperty("orderDueDate")
//        String orderDueDate;
//        @JsonProperty("customerReference")
//        Object customerReference;
//        @JsonProperty("orderLine")
//        Object orderLine;
//        @JsonProperty("status")
//        String status;
//
//    }
//
//
//    @Data
//    public static class CustomerOrderIdentification {
//
//        @JsonProperty("identification")
//        Identification identification;
//        @JsonProperty("cafNumber")
//        String cafNumber;
//    }
//
//    @Data
//    public static class Identification {
//        @JsonProperty("id")
//        String id;
//    }
//}