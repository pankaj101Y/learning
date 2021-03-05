package com.example.learnings.edsl.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicalResources {
	
	private Identification identification;
	private String type;
	
	@Override
	public String toString() {
		return "LogicalResources [identification=" + identification + ", type=" + type + "]";
	}
	
	
}
