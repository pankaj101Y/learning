package com.example.learnings.edsl.data;

import lombok.ToString;

@ToString
public enum DslCustomerType {

    BUISNESS_CUSTOMER_TYPE("Business"),
    CONSUMER_CUSTOMER_TYPE("Consumer");

    private String value;

    private DslCustomerType(String value){
        this.value = value;
    }

    public String getValue(){
        return  value;
    }

}
