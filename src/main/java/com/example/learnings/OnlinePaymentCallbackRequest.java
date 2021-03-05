package com.example.learnings;

import java.io.Serializable;



public class OnlinePaymentCallbackRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cafNumber;

	private String mobileNumber;

	private String aadharNumber;

	private String amount;

	private String txStatus;

	private String txId;

	private long txDateTime;

	public String getCafNumber() {
		return cafNumber;
	}

	public void setCafNumber(String cafNumber) {
		this.cafNumber = cafNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTxStatus() {
		return txStatus;
	}

	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public long getTxDateTime() {
		return txDateTime;
	}

	public void setTxDateTime(long txDateTime) {
		this.txDateTime = txDateTime;
	}


}
