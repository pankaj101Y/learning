package com.example.learnings;

public enum TransactionStatus {

	ONLINE_PAYMENT_PENDING("ONLINE_PAYMENT_PENDING"),
	SUCCESS("SUCCESS"),
	PAYMENT_START("PAYMENT_START"),
	PAYMENT_PENDING("PAYMENT_PENDING"),
	PAYMENT_SUCCESS("PAYMENT_SUCCESS"),
	PAYMENT_FAILED("PAYMENT_FAILED");


	private String transactionStatusType;

	TransactionStatus(String status) {
		this.setTransactionStatusType(status);
	}

	public String getTransactionStatusType() {
		return transactionStatusType;
	}

	public void setTransactionStatusType(String transactionStatusType) {
		this.transactionStatusType = transactionStatusType;
	}


}