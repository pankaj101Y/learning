package com.example.learnings.edsl.data;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class ExternalIdentification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 311160428668844886L;
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
