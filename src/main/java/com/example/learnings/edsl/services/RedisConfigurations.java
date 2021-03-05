//package com.example.learnings.edsl.services;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//
//@Configuration
//@EnableCaching
//public class RedisConfigurations extends CachingConfigurerSupport {
//
//	private static Logger LOGGER = LoggerFactory.getLogger(RedisConfigurations.class);
//
//	@Value("${com.redis.max.total}")
//	private String jedisMaxTotal;
//
//	@Value("${com.redis.min.idle}")
//	private String jedisMinIdle;
//
//	@Value("${com.redis.max.idle}")
//	private String jedisMaxIdle;
//
//	@Value(value = "${com.redis.sentinel.master}")
//	private String redisSentinelMaster;
//
//	@Value(value = "${com.redis.sentinal.ip}")
//	private String redisSentinelHostAndPorts;
//
//	@Value(value = "${com.redis.redisMaster:}")
//	private String redisMaster;
//
//	@Value(value = "${com.redis.redisMaster.port:}")
//	private String redisMasterPort;
//
//	@Value(value = "${com.redis.redisMaster.pass}")
//	private String redisMasterPassword;
//
//	@Value(value = "${com.redis.redisMaster.pass.enabled}")
//	private String redisMasterPasswordEnabled;
//
//
//	@Bean(name = "jedisPoolConfig")
//	public JedisPoolConfig jedisPoolConfig() {
//
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		String maxTotal = jedisMaxTotal;
//		String maxIdle = jedisMaxIdle;
//		String minIdle = jedisMinIdle;
//		LOGGER.info("Jedis Connection properties : maxTotal {} , maxIdle {} , minIdle {} sIPPORT {} sMaster {}", maxTotal, maxIdle, minIdle,redisSentinelHostAndPorts,redisSentinelMaster);
//		jedisPoolConfig.setTestOnBorrow(true);
//		jedisPoolConfig.setMaxTotal(Integer.valueOf(maxTotal));
//		jedisPoolConfig.setMaxIdle(Integer.valueOf(maxIdle));
//		jedisPoolConfig.setMinIdle(Integer.valueOf(minIdle));
//		jedisPoolConfig.setTestOnBorrow(false);
//		jedisPoolConfig.setTestOnReturn(true);
//		jedisPoolConfig.setTestWhileIdle(true);
//		jedisPoolConfig.setMaxWaitMillis(10000);
//
//		return jedisPoolConfig;
//	}
//
//
//
//	@Bean(name = "jedisConnectionFactory")
//	@Primary
//	public JedisConnectionFactory jedisConnectionFactoryDevWithPass(
//			@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
//
//		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory(jedisPoolConfig);
//		jedisConFactory.setHostName(redisMaster);
//		jedisConFactory.setPort(Integer.valueOf(redisMasterPort));
//		LOGGER.info("redis pass in dev");
//		jedisConFactory.setPassword(redisMasterPassword);
//		return jedisConFactory;
//
//	}
//
//	@Bean
//	public StringRedisSerializer stringRedisSerialized() {
//		return new StringRedisSerializer();
//	}
//
//	@Bean("redisTemplate")
//	public RedisTemplate<String, Object> redisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory connectionFactoryWitPass) {
//		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//		template.setKeySerializer(stringRedisSerialized());
//		template.setHashKeySerializer(stringRedisSerialized());
//		template.setConnectionFactory(connectionFactoryWitPass);
//		return template;
//	}
//
//
//
//	@Bean
//	public RedisCacheManager getRedisCacheManager(
//			 RedisTemplate<String, Object> redisTemplate,@Qualifier("jedisConnectionFactory")JedisConnectionFactory connectionFactory) {
//
//
//		RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig();
////		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate,
////				CacheName.getRedisCacheNames().keySet());
////		redisCacheManager.setDefaultExpiration(10000);
////		redisCacheManager.setDefaultExpiration(0); // read it from property
////		redisCacheManager.setUsePrefix(true);
////		redisCacheManager.setExpires(CacheName.getRedisCacheNames());
//
//		RedisCacheManager redisCacheManager=new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory),redisCacheConfiguration);
////		redisCacheConfiguration.prefixCacheNameWith(":");
//		return redisCacheManager;
//	}
//}