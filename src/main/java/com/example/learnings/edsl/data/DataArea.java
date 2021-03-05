package com.example.learnings.edsl.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class DataArea implements Serializable {

	private static final long serialVersionUID = 3874725113138207769L;

	private GetProspectiveBillPlansForCustomerResponse getProspectiveBillPlansForCustomerResponse;


	//private List<BillPlanDetail> billPlanDetails;
	
	

	public GetProspectiveBillPlansForCustomerResponse getGetProspectiveBillPlansForCustomerResponse() {
		return getProspectiveBillPlansForCustomerResponse;
	}



	public void setGetProspectiveBillPlansForCustomerResponse(
			GetProspectiveBillPlansForCustomerResponse getProspectiveBillPlansForCustomerResponse) {
		this.getProspectiveBillPlansForCustomerResponse = getProspectiveBillPlansForCustomerResponse;
	}





@ToString
	public class GetProspectiveBillPlansForCustomerResponse implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1302807169377702930L;

		private Status status;
		
		@JsonProperty(value = "billPlandetails")
	//	private BillPlanDetails billPlanDetails;
		private List<BillPlanDetails> billPlandetails;
		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public List<BillPlanDetails> getBillPlandetails() {
			return billPlandetails;
		}

		public void setBillPlandetails(List<BillPlanDetails> billPlandetails) {
			this.billPlandetails = billPlandetails;
		}

	 

	 
		
	}
}
