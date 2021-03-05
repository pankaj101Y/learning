package com.example.learnings.edsl.data;

import lombok.ToString;

@ToString
public class GetResourceListFault
{
	private SoaFault soaFault;

	public SoaFault getSoaFault() {
		return soaFault;
	}

	public void setSoaFault(SoaFault soaFault) {
		this.soaFault = soaFault;
	}

}
