//package com.example.learnings.edsl.services;//package com.airtel.pe.eDSL.common.service.impl;
//
//import java.util.List;
//
//import com.example.learnings.edsl.data.CacheName;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class CacheManagerImpl  {
//
//	@Autowired
//	private RedisCacheManager cacheManager;
//
//	@Autowired
//	private RedisConnectionConfig redisConnectionConfig;
//
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//
//	public void putValue(final String key, final String value, final CacheName cacheName) {
//
//		try {
//			this.cacheManager.getCache(cacheName.getCacheName()).put(key, value);
//		} catch (Exception e) {
//			log.error(" Insdie putValue Exception @error ",e);
//			redisConnectionConfig.resetConnectionFactory();
//			putValue(concatCacheNameKey(key, cacheName.getCacheName()),value);
//
//		}
//	}
//
//	public Object getValue(final String key, final CacheName cacheName) {
//		try {
//			return cacheManager.getCache(cacheName.getCacheName()).get(key, String.class);
//		} catch (Exception e) {
//			log.error(" Insdie getValue Exception @error ",e);
//			redisConnectionConfig.resetConnectionFactory();
//			return getValue(concatCacheNameKey(key, cacheName.getCacheName()));
//		}
//	}
//
//
//
//	public void deleteValue(final String key, final CacheName cacheName) {
//		try {
//			cacheManager.getCache(cacheName.getCacheName()).evict(key);
//		} catch (Exception e) {
//		  log.error(" Insdie deleteValue Exception @error ",e);
//		  redisConnectionConfig.resetConnectionFactory();
//		  deleteValue(concatCacheNameKey(key,cacheName.getCacheName()));
//		}
//	}
//
//	public void deleteCache(final CacheName cacheName) {
//		try {
//			cacheManager.getCache(cacheName.getCacheName()).clear();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			 log.error(" Insdie deleteValue Exception @error ",e);
//			 redisConnectionConfig.resetConnectionFactory();
//			 deleteValue(cacheName.getCacheName());
//		}
//	}
//
//	public void putValues(final String key, final List<Object> value, final CacheName cacheName) {
//		try {
//			cacheManager.getCache(cacheName.getCacheName()).put(key, value);
//		} catch (Exception e) {
//			log.error(" Insdie putValues list Exception @error ",e);
//			redisConnectionConfig.resetConnectionFactory();
//			putValue(concatCacheNameKey(key, cacheName.getCacheName()),value);
//		}
//	}
//
//	public void putValues(final String key, final Object value, final CacheName cacheName) {
//		try {
//			cacheManager.getCache(cacheName.getCacheName()).put(key, value);
//		}catch (Exception e) {
//			log.error(" Insdie putValues object Exception @error ",e);
//			redisConnectionConfig.resetConnectionFactory();
//			putValue(concatCacheNameKey(key, cacheName.getCacheName()),value);
//		}
//	}
//
//	public void clearAllCache(final CacheName cacheName) {
//		try {
//			cacheManager.getCache(cacheName.getCacheName()).clear();
//		} catch (Exception e) {
//			log.error(" Insdie clearAllCache  Exception @error ",e);
//			redisConnectionConfig.resetConnectionFactory();
//			deleteValue(cacheName.getCacheName());
//		}
//	}
//
//	public void deleteKey(String keyName) {
//		try {
//			redisTemplate.delete(keyName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(" Insdie deleteKey  Exception @error ",e);
//			redisConnectionConfig.resetConnectionFactory();
//			deleteValue(keyName);
//		}
//	}
//
//	 private String concatCacheNameKey(final String key, final String cacheName){
//	        return cacheName + ":" + key;
//	 }
//
//	 public Object getValue(final String key) {
//		 try {
//			return this.redisConnectionConfig.getRedisTemplate().opsForValue().get(key);
//		 }catch (Exception e) {
//			log.error(" Insdie getValue2 Exception @error ",e);
//			return null;
//		}
//
//	 }
//
//	 public void deleteValue(final String key) {
//		 try {
//			 this.redisConnectionConfig.getRedisTemplate().delete(key);
//		 }catch (Exception e) {
//			 log.error(" Insdie deleteValue2 Exception @error ",e);
//		}
//
//	 }
//
//	public void putValue(String key,String value) {
//	  try{
//		this.redisConnectionConfig.getRedisTemplate().opsForValue().set(key, value);
//	  }catch (Exception e) {
//			 log.error(" Insdie putValue2 Exception @error ",e);
//		}
//
//	}
//
//	public void putValue(String key,Object value) {
//		  try{
//			this.redisConnectionConfig.getRedisTemplate().opsForValue().set(key, value);
//		  }catch (Exception e) {
//				 log.error(" Insdie putValue2 Object Exception @error ",e);
//			}
//
//		}
//}
//
