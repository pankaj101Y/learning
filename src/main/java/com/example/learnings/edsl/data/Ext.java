package com.example.learnings.edsl.data;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

 

/**
 * Created by Rohit Asati
 *
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ext  implements Serializable {
	private ArrayList<Attribute> attribute ;

	public ArrayList<Attribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(ArrayList<Attribute> attribute) {
		this.attribute = attribute;
	}
}
