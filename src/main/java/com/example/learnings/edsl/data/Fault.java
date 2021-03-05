package com.example.learnings.edsl.data;//package com.airtel.pe.eDSL.domain.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;
@ToString
public class Fault implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3317658032157579337L;

	private String faultcode;

	private String faultstring;

	private FaultDetail detail;
	
	//@JsonProperty("detail")
	//private Detail details;

	public String getFaultcode() {
		return faultcode;
	}

	public void setFaultcode(String faultcode) {
		this.faultcode = faultcode;
	}

	public String getFaultstring() {
		return faultstring;
	}

	public void setFaultstring(String faultstring) {
		this.faultstring = faultstring;
	}

	public FaultDetail getDetail() {
		return detail;
	}

	public void setDetail(FaultDetail detail) {
		this.detail = detail;
	}

//	public Detail getDetails() {
//		return details;
//	}
//
//	public void setDetails(Detail details) {
//		this.details = details;
//	}
	
	
	
}





