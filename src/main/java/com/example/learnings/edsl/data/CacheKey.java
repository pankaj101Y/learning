package com.example.learnings.edsl.data;

public enum CacheKey {

	PROPERTY("Application_Property"), CONFIGURATION("Configuration"), USERS_TOKEN("UserToken"), CRM_PLANS(
			"Crm_Plans"), PINCODE("Pincode"), BANKDETAILS("bankDetails"), FETCHED_PLANS(
					"fetchedPlans"), PLAN_GRID("Plan_Grid"), CIRCLE_PROPERTY("circleProperty"), CIRCLE_RSU_PROPERTY("circleRsuProperty"),
			FEASIBLE_CITIES("feasibleCities"), CRM_CALLBACK_ERRORS("crmCallbackErrors"),LCO_FETCHED_PLANS("LcoFetchedPlans"), POAPOI_IND("PoaPoiInd"), POAPOI_COM("PoaPoiCom");

	CacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	private String cacheKey;

	public String getCacheKey() {
		return cacheKey;
	}

}
