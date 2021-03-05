package com.example.learnings.edsl.data;

import lombok.ToString;

@ToString
public enum DslCustomeClassType {

    AIRTEL_CUSTOMER_CLASS("Airtel"),
    INDIVIDUAL_CUSTOMER_CLASS("Individual"),
    ADVANCE_CUSTOMER_CLASS("Advance_Billing");

    private String value;

    private DslCustomeClassType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
