package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.domain.plandetails;

import java.io.Serializable;
import java.util.List;

import lombok.ToString;

@ToString
public class DSLPlansWrapper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MyDslPlanBean> broadBandPlans;

	private String activationCost;

	private String arpActivationCost;


	public String getActivationCost() {
		return activationCost;
	}

	public void setActivationCost(String activationCost) {
		this.activationCost = activationCost;
	}

	public String getArpActivationCost() {
		return arpActivationCost;
	}

	public void setArpActivationCost(String arpActivationCost) {
		this.arpActivationCost = arpActivationCost;
	}

	public DSLPlansWrapper() {
		super();
	}

	public DSLPlansWrapper(List<MyDslPlanBean> broadBandPlans) {
		super();
		this.broadBandPlans = broadBandPlans;
	}

	public List<MyDslPlanBean> getBroadBandPlans() {
		return broadBandPlans;
	}

	public void setBroadBandPlans(List<MyDslPlanBean> broadBandPlans) {
		this.broadBandPlans = broadBandPlans;
	}
	
	
	
	

}
