package com.example.learnings.edsl.data;

import java.io.Serializable;

import lombok.ToString;
@ToString
public class GetProspectiveBillPlansForCustomerResMsg implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6678961198129903297L;
	private EbmHeader ebmHeader;
	private DataArea dataArea;

	public EbmHeader getEbmHeader() {
		return ebmHeader;
	}

	public void setEbmHeader(EbmHeader ebmHeader) {
		this.ebmHeader = ebmHeader;
	}

	public DataArea getDataArea() {
		return dataArea;
	}

	public void setDataArea(DataArea dataArea) {
		this.dataArea = dataArea;
	}
	
	

}
