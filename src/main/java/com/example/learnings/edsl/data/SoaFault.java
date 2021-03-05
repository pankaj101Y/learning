package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.domain.beans;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class SoaFault implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2503983998502713656L;

	private String soaFaultOriginator;

	private String soaFaultCode;

	private String faultDescription;

	private String faultTrace;

	private String soaTransactionID;


	public String getSoaFaultOriginator() {
		return soaFaultOriginator;
	}

	public void setSoaFaultOriginator(String soaFaultOriginator) {
		this.soaFaultOriginator = soaFaultOriginator;
	}

	public String getSoaFaultCode() {
		return soaFaultCode;
	}

	public void setSoaFaultCode(String soaFaultCode) {
		this.soaFaultCode = soaFaultCode;
	}

	public String getFaultDescription() {
		return faultDescription;
	}

	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}

	public String getFaultTrace() {
		return faultTrace;
	}

	public void setFaultTrace(String faultTrace) {
		this.faultTrace = faultTrace;
	}

	public String getSoaTransactionID() {
		return soaTransactionID;
	}

	public void setSoaTransactionID(String soaTransactionID) {
		this.soaTransactionID = soaTransactionID;
	}

}