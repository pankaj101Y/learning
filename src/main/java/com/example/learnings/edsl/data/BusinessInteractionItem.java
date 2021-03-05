package com.example.learnings.edsl.data;

public class BusinessInteractionItem {
	private UpdateOrderProduct product;

	public UpdateOrderProduct getProduct() {
		return this.product;
	}

	public void setProduct(UpdateOrderProduct product) {
		this.product = product;
	}

	public static class UpdateOrderProduct {

		private ProductConfiguration productConfiguration;

		public ProductConfiguration getProductConfiguration() {
			return this.productConfiguration;
		}

		public void setProductConfiguration(ProductConfiguration productConfiguration) {
			this.productConfiguration = productConfiguration;
		}
	}

	public static class ProductConfiguration {
		private String createdBy;

		public String getCreatedBy() {
			return this.createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
	}

}
