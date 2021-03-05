package com.example.learnings.edsl.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRM_PLAN_CONFIG")
public class CRMPlanConfig implements Serializable {

	private static final long serialVersionUID = 8590699774251351744L;

	@Id
	@Column(name = "PLAN_ID")
	private String planId;

	@Column(name = "AMOUNT")
	private Integer nrcAmount;

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Integer getNrcAmount() {
		return nrcAmount;
	}

	public void setNrcAmount(Integer nrcAmount) {
		this.nrcAmount = nrcAmount;
	}

}
