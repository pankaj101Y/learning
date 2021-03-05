package com.example.learnings.edsl.data;

import java.io.Serializable;

import lombok.ToString;
@ToString
public class Status implements Serializable {

	private static final long serialVersionUID = 4603071434527479414L;

	private String statusCode;

	private String statusDescription;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

}
