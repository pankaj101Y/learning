package com.example.learnings.edsl.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class SearchReserveNumberFault {

	 private String SOAFaultOriginator;
	 private String SOAFaultCode;
	 private String faultDescription;
	 private String SOATransactionID;
	 private String faultTrace;
	 
	 @JsonProperty("SOAFaultOriginator")
	public String getSOAFaultOriginator() {
		return SOAFaultOriginator;
	}
	public void setSOAFaultOriginator(String SOAFaultOriginator) {
		this.SOAFaultOriginator = SOAFaultOriginator;
	}
	@JsonProperty("SOAFaultCode")
	public String getSOAFaultCode() {
		return SOAFaultCode;
	}
	public void setSOAFaultCode(String SOAFaultCode) {
		this.SOAFaultCode = SOAFaultCode;
	}
	public String getFaultDescription() {
		return faultDescription;
	}
	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}
	
	@JsonProperty("SOATransactionID")
	public String getSOATransactionID() {
		return SOATransactionID;
	}
	public void setSOATransactionID(String SOATransactionID) {
		this.SOATransactionID = SOATransactionID;
	}
	public String getFaultTrace() {
		return faultTrace;
	}
	public void setFaultTrace(String faultTrace) {
		this.faultTrace = faultTrace;
	}
	

	 
}
