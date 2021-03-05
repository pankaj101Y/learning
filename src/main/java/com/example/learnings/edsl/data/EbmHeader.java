package com.example.learnings.edsl.data;

import java.io.Serializable;

public class EbmHeader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7435069175372047479L;
	private String consumerTransactionId;
	private String consumerName;
	private String ProgrammeName;
	private String lob;

	public String getConsumerTransactionId() {
		return consumerTransactionId;
	}

	public void setConsumerTransactionId(String consumerTransactionId) {
		this.consumerTransactionId = consumerTransactionId;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getProgrammeName() {
		return ProgrammeName;
	}

	public void setProgrammeName(String programmeName) {
		ProgrammeName = programmeName;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}
	

}
