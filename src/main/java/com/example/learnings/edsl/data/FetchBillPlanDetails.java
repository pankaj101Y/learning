package com.example.learnings.edsl.data;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class FetchBillPlanDetails implements Serializable {

	private static final long serialVersionUID = -9054213605224586602L;

	private GetProspectiveBillPlansForCustomerResMsg getProspectiveBillPlansForCustomerResMsg;

	private Fault fault;

	@JsonProperty("Fault")
	public Fault getFault() {
		return this.fault;
	}

	public void setFault(Fault Fault) {
		this.fault = Fault;
	}


	public GetProspectiveBillPlansForCustomerResMsg getGetProspectiveBillPlansForCustomerResMsg() {
		return getProspectiveBillPlansForCustomerResMsg;
	}

	public void setGetProspectiveBillPlansForCustomerResMsg(
			GetProspectiveBillPlansForCustomerResMsg getProspectiveBillPlansForCustomerResMsg) {
		this.getProspectiveBillPlansForCustomerResMsg = getProspectiveBillPlansForCustomerResMsg;
	}

}
