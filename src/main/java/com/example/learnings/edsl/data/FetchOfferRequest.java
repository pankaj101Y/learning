package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.domain.common.request.dto;

public class FetchOfferRequest extends BaseRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -113065095979169680L;

	private String offerType;

	private double amount;

	private String rsu;

	public String getRsu() {
		return rsu;
	}

	public void setRsu(String rsu) {
		this.rsu = rsu;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
