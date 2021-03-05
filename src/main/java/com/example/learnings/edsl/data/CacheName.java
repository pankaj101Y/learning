package com.example.learnings.edsl.data;

import java.util.HashMap;
import java.util.Map;

public enum CacheName {

	TOKEN_CACHE("tokenCache", 21600L), USERS_CACHE("usersCache", 21600L), PRODUCT_CACHE("productCache",
			21600L), ORDER_CACHE("orderCache", 21600L), PROPERTY_CACHE("propertyCache", 21600L), PLANS_CACHE("plansCache", 21600L),
	                         																			LCO_PLAN_CACHE("lcoPlanCache",21600L);

	CacheName(String cacheName, Long expireTime) {
		this.cacheName = cacheName;
		this.expireTimeSec = expireTime;
	}

	private String cacheName;

	private Long expireTimeSec;

	public String getCacheName() {
		return cacheName;
	}

	public Long getExpireTimeSec() {
		return expireTimeSec;
	}

	public static Map<String, Long> getRedisCacheNames() {

		Map<String, Long> cacheNames = new HashMap<String, Long>();
		CacheName[] redisCaches = CacheName.values();

		for (CacheName cacheName : redisCaches) {
			cacheNames.put(cacheName.getCacheName(), cacheName.getExpireTimeSec());
		}
		return cacheNames;
	}

}