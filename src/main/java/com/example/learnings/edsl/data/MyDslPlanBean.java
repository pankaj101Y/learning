package com.example.learnings.edsl.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;


@JsonIgnoreProperties
@ToString
@Data
public class MyDslPlanBean implements Serializable{


    private static final long serialVersionUID = 1L;

    /** The plan Description. */
    private String planDescription;

    /** The plan code. */
    private String planCode;

    /** The plan Speed. */
    private String billPlanSpeed;

    /** The billPlanQuota. */
    private String billPlanQuota;

    /** The Post internet Speed. */
    private String postFupSpeed;

    /** The price . */
    private double billPlanRental;

    /** The plan Rental Type. */
    private String rentalType;

    /** The ARP Rental Month. */
    private String arpRentalMonth; 
    
    /** The CRM ID. */
    private String crmID;
    
    /** The CRM Name. */
    private String crmName;
    
    
    /** TOTAL ARP AMOUNT. */
    private double totalArpAmount;
    
    private String discountPercentage ;
    
    private String totalNrcAmount ;
    
    private String schemeId ;

	private double totalAmountWithGst;
	private String perMonthCharge;


	private long actualPlanCharges;
	private long actualPaymentCharges;

   	private List<TopUpDetailsBean> topUpDetails;

	public String source;
	
	
	public String actualPlanType;



}