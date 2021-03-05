package com.example.learnings.cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
public class CartSubItemsDTO {

    private String cartSubItemId;

    private String source;

    private String channel;

    private String cafNumber;

    private String connectionType = "NEW";

    private String serviceName;

    private String subServiceName;

    private String subServiceType;

    private String existingNumber;

    private String existingCustName;

    private String existingPlan;

    private Double itemPrice;

    private String planId;

    private String planName;

    private String planDescription;

    private Object planDetails;

    private String customerName;

    private Double totalPrice;

    private String leadId;

    private String referenceLeadId;

    private String discount;

    private String customerMobileNumber;

    private String dthAccountId;

    private String isPrimaryDth;

    //todo add List<Add> for dth

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private List<TaskDTO> tasks;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> cartSubItemAttributes;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CartSubItemsDTO> childCartSubItems;
//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private String planUpdateType = AppConstants.PlanUpdateType.UPDATE_EXTRA;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private PlanItems plan;

    private CartSubItemsDTO parent;

    private Boolean onlineKycEnabled;

}