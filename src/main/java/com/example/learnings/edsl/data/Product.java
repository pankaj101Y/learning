package com.example.learnings.edsl.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Product  implements Serializable
{
	private ProductSpecification productSpecification;

	private CustomerFacingService customerFacingService;

	private ProductLine productLine;
	
	private String productSerialNumber ;
	
	private String validFor ;
	
	private ProdPriceCharge prodPriceCharge ;
	
	private OneTimeChargeProdOfferPriceCharge oneTimeChargeProdOfferPriceCharge ;
	
	private Ext ext ;
	  


	public Ext getExt() {
		return ext;
	}

	public void setExt(Ext ext) {
		this.ext = ext;
	}

	public String getProductSerialNumber() {
		return productSerialNumber;
	}

	public void setProductSerialNumber(String productSerialNumber) {
		this.productSerialNumber = productSerialNumber;
	}

	public String getValidFor() {
		return validFor;
	}

	public void setValidFor(String validFor) {
		this.validFor = validFor;
	}

	public ProdPriceCharge getProdPriceCharge() {
		return prodPriceCharge;
	}

	public void setProdPriceCharge(ProdPriceCharge prodPriceCharge) {
		this.prodPriceCharge = prodPriceCharge;
	}

	public OneTimeChargeProdOfferPriceCharge getOneTimeChargeProdOfferPriceCharge() {
		return oneTimeChargeProdOfferPriceCharge;
	}

	public void setOneTimeChargeProdOfferPriceCharge(OneTimeChargeProdOfferPriceCharge oneTimeChargeProdOfferPriceCharge) {
		this.oneTimeChargeProdOfferPriceCharge = oneTimeChargeProdOfferPriceCharge;
	}

	public ProductSpecification getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}

	public CustomerFacingService getCustomerFacingService() {
		return customerFacingService;
	}

	public void setCustomerFacingService(CustomerFacingService customerFacingService) {
		this.customerFacingService = customerFacingService;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

//	public class ProductSpecification  implements Serializable
//	{
//		private String dbpFlagValue;
//
//		private  ProductSpecCharacteristic productSpecCharacteristic;
//
//		public ProductSpecCharacteristic getProductSpecCharacteristic() {
//			return productSpecCharacteristic;
//		}
//
//		public void setProductSpecCharacteristic() {
//
//			this.productSpecCharacteristic=productSpecCharacteristic;
//		}
//
//
//		public String getDbpFlagValue() {
//			return dbpFlagValue;
//		}
//
//		public void setDbpFlagValue(String dbpFlagValue) {
//			this.dbpFlagValue = dbpFlagValue;
//		}
//
//	}



	public class CustomerFacingService  implements Serializable
	{
		private String currentSpeed;

		public String getCurrentSpeed() {
			return currentSpeed;
		}

		public void setCurrentSpeed(String currentSpeed) {
			this.currentSpeed = currentSpeed;
		}

	}

	public class ProductLine implements Serializable
	{
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}


}
