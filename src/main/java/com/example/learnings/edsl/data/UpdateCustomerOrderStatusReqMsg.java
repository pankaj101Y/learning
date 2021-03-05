package com.example.learnings.edsl.data;

public class UpdateCustomerOrderStatusReqMsg {

	private EbmHeader ebmHeader;
	
	private UpdateOrderStatusDataArea dataArea;

	public EbmHeader getEbmHeader() {
		return ebmHeader;
	}

	public void setEbmHeader(EbmHeader ebmHeader) {
		this.ebmHeader = ebmHeader;
	}

	public UpdateOrderStatusDataArea getDataArea() {
		return dataArea;
	}

	public void setDataArea(UpdateOrderStatusDataArea dataArea) {
		this.dataArea = dataArea;
	}

}