package com.example.learnings.edsl.data;

import java.io.Serializable;

import lombok.ToString;

@ToString
public class ServiceSpecification implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 9134663871816368043L;
		private String currentSpeed;
		private String usageLimit;
		private String eligibilty;
		private String bandwidth;

		public String getCurrentSpeed() {
			return currentSpeed;
		}

		public void setCurrentSpeed(String currentSpeed) {
			this.currentSpeed = currentSpeed;
		}

		public String getUsageLimit() {
			return usageLimit;
		}

		public void setUsageLimit(String usageLimit) {
			this.usageLimit = usageLimit;
		}

		public String getEligibilty() {
			return eligibilty;
		}

		public void setEligibilty(String eligibilty) {
			this.eligibilty = eligibilty;
		}

		public String getBandwidth() {
			return bandwidth;
		}

		public void setBandwidth(String bandwidth) {
			this.bandwidth = bandwidth;
		}
}
