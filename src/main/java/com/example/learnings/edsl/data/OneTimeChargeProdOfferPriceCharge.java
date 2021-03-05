package com.example.learnings.edsl.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Rohit Asati
 *
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class OneTimeChargeProdOfferPriceCharge   implements Serializable {

	String priceType ;
	String unitOfMeasure ;
	String price ;
	
	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
