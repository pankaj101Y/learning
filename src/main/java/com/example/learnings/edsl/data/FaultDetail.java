package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.domain.beans;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class FaultDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5178567038263102859L;

	private GetResourceListFault getResourceListFault;
	
	private  SearchReserveNumberFault searchReserveNumberFault;
	
	private GetProspectiveBillPlansForCustomerFault getProspectiveBillPlansForCustomerFault;
		
	private SubmitOrderFault submitOrderFault;

	public GetResourceListFault getGetResourceListFault() {
		return getResourceListFault;
	}

	public void setGetResourceListFault(GetResourceListFault getResourceListFault) {
		this.getResourceListFault = getResourceListFault;
	}

	public SearchReserveNumberFault getSearchReserveNumberFault() {
		return searchReserveNumberFault;
	}

	public void setSearchReserveNumberFault(SearchReserveNumberFault searchReserveNumberFault) {
		this.searchReserveNumberFault = searchReserveNumberFault;
	}

	public GetProspectiveBillPlansForCustomerFault getGetProspectiveBillPlansForCustomerFault() {
		return getProspectiveBillPlansForCustomerFault;
	}

	public void setGetProspectiveBillPlansForCustomerFault(
			GetProspectiveBillPlansForCustomerFault getProspectiveBillPlansForCustomerFault) {
		this.getProspectiveBillPlansForCustomerFault = getProspectiveBillPlansForCustomerFault;
	}

	public SubmitOrderFault getSubmitOrderFault() {
		return submitOrderFault;
	}

	public void setSubmitOrderFault(SubmitOrderFault submitOrderFault) {
		this.submitOrderFault = submitOrderFault;
	}
	
	

}
