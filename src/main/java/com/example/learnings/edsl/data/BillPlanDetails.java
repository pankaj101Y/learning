package com.example.learnings.edsl.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.ToString;

@ToString
@JsonRootName(value = "billPlandetails")
public class BillPlanDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4275225083865818398L;
	private List<BillPlanDetail> billPlandetail;

	public List<BillPlanDetail> getBillPlandetail() {
		return billPlandetail;
	}

	public void setBillPlandetail(List<BillPlanDetail> billPlandetail) {
		this.billPlandetail = billPlandetail;
	}
	
	

}
