package com.example.learnings.edsl.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by Rohit Asati
 *
 * 
 */
@JsonIgnoreProperties(ignoreUnknown=true) 
public class ProductOffering implements Serializable {
private Product product ;

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}
}
