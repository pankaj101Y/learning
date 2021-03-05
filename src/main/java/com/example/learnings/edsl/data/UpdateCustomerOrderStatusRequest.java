package com.example.learnings.edsl.data;

import com.example.learnings.edsl.data.CustomerOrder;

public class UpdateCustomerOrderStatusRequest {

	private CustomerOrder customerOrder;

	public CustomerOrder getCustomerOrder() {
		return this.customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}
}
