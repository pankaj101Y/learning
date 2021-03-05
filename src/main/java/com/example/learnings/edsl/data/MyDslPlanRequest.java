package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.domain.common.request.dto;


import lombok.ToString;

@ToString
public class MyDslPlanRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String speed;
	private String dslTech;
	private String rsu;
	private String installAddressPinCode;
	private String distance;
	private String agentType;
	private String customerType;
	private String customerClass;
	private String category;
	private String source;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDslTech() {
		return dslTech;
	}

	public void setDslTech(String dslTech) {
		this.dslTech = dslTech;
	}

	public String getRsu() {
		return rsu;
	}

	public void setRsu(String rsu) {
		this.rsu = rsu;
	}

	public String getInstallAddressPinCode() {
		return installAddressPinCode;
	}

	public void setInstallAddressPinCode(String installAddressPinCode) {
		this.installAddressPinCode = installAddressPinCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerClass() {
		return customerClass;
	}

	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}


	public String getAgentType() {
		return agentType; }

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
