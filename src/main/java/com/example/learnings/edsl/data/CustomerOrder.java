package com.example.learnings.edsl.data;

import java.util.List;

public class CustomerOrder {

	private Identification identification;
	
	private BusinessInteractionItem businessInteractionItem;
	
	private String interactionTimeComplete;
	
	private String flag;
	
	private String purchaseOrderNumber;
	
	private CustomerOrderItem customerOrderItem;
	
	private String status;
	
	private String action;
	
	private String remarks;
	
	private List<LogicalResources> logicalResource;

	private PhysicalResource physicalResource;

	public Identification getIdentification() {
		return this.identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public BusinessInteractionItem getBusinessInteractionItem() {
		return this.businessInteractionItem;
	}

	public void setBusinessInteractionItem(BusinessInteractionItem businessInteractionItem) {
		this.businessInteractionItem = businessInteractionItem;
	}

	public String getInteractionTimeComplete() {
		return this.interactionTimeComplete;
	}

	public void setInteractionTimeComplete(String interactionTimeComplete) {
		this.interactionTimeComplete = interactionTimeComplete;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPurchaseOrderNumber() {
		return this.purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public CustomerOrderItem getCustomerOrderItem() {
		return this.customerOrderItem;
	}

	public void setCustomerOrderItem(CustomerOrderItem customerOrderItem) {
		this.customerOrderItem = customerOrderItem;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<LogicalResources> getLogicalResource() {
		return logicalResource;
	}

	public void setLogicalResource(List<LogicalResources> logicalResource) {
		this.logicalResource = logicalResource;
	}

	public PhysicalResource getPhysicalResource() {
		return physicalResource;
	}

	public void setPhysicalResource(PhysicalResource physicalResource) {
		this.physicalResource = physicalResource;
	}
}
