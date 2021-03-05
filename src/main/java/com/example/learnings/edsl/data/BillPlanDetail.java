package com.example.learnings.edsl.data;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.ToString;

@ToString
@JsonRootName(value = "billPlandetail")
public class BillPlanDetail  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1930402576746557355L;

	private ProductOfferingPrice productOfferingPrice;

	private ProductSpecification productSpecification;
	
	private ProductOffering productOffering  ;
	

	private WebEnabled webEnabled;
	
	


	public ProductOffering getProductOffering() {
		return productOffering;
	}

	public void setProductOffering(ProductOffering productOffering) {
		this.productOffering = productOffering;
	}

	public ProductOfferingPrice getProductOfferingPrice() {
		return productOfferingPrice;
	}

	public void setProductOfferingPrice(ProductOfferingPrice productOfferingPrice) {
		this.productOfferingPrice = productOfferingPrice;
	}

	public ProductSpecification getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}

	public WebEnabled getWebEnabled() {
		return webEnabled;
	}

	public void setWebEnabled(WebEnabled webEnabled) {
		this.webEnabled = webEnabled;
	}

	
	
	@ToString
	public class ProductOfferingPrice implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8570798115218344892L;
		private String price;
		private String billPlanCategory;

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getBillPlanCategory() {
			return billPlanCategory;
		}

		public void setBillPlanCategory(String billPlanCategory) {
			this.billPlanCategory = billPlanCategory;
		}

	}
@ToString
	public class ProductSpecification implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7010525348692634301L;
		private String description;
		private String productNumber;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getProductNumber() {
			return productNumber;
		}

		public void setProductNumber(String productNumber) {
			this.productNumber = productNumber;
		}

	}
@ToString
	public class WebEnabled implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3474317130079257983L;
		private ServiceSpecification serviceSpecification;
		private ArrayList<ExternalIdentification> externalIdentification;

		public ServiceSpecification getServiceSpecification() {
			return serviceSpecification;
		}

		public void setServiceSpecification(ServiceSpecification serviceSpecification) {
			this.serviceSpecification = serviceSpecification;
		}

		public ArrayList<ExternalIdentification> getExternalIdentification() {
			return externalIdentification;
		}

		public void setExternalIdentification(ArrayList<ExternalIdentification> externalIdentification) {
			this.externalIdentification = externalIdentification;
		}

	

	}
	

}
