package com.example.learnings.edsl.data;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class GetProspectiveBillPlansForCustomerFault implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 6396019760238576743L;
	private SoaFault soaFault;

	public SoaFault getSoaFault() {
		return soaFault;
	}

	public void setSoaFault(SoaFault soaFault) {
		this.soaFault = soaFault;
	}
	 
}
