//package com.example.learnings.edsl.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class RedisConnectionConfig {
//
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//
//	@Autowired
//	@Qualifier("jedisConnectionFactory")
//	private JedisConnectionFactory jedisConnectionFactory;
//
//	@Value(value = "${com.redis.redisMaster.pass.enabled}")
//	private String redisMasterPasswordEnabled;
//
//
//	RedisTemplate<String, Object> getRedisTemplate(){
//		return this.redisTemplate;
//	}
//
//
//	void resetConnectionFactory() {
//		log.info(" Inside resetConnectionFactory {}",redisMasterPasswordEnabled);
//		redisTemplate.setConnectionFactory(jedisConnectionFactory);
//	}
//
//
//
//
//
//
//
//}