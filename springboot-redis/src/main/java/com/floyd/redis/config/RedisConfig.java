package com.floyd.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * 注释
 *
 * @author floyd
 * @version : RedisConfig.java, v 0.1 2019/8/28 14:15 By floyd Edit  $$
 */

@Configuration
//启用缓存
@EnableCaching
//配置节点
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig extends CachingConfigurerSupport {
	
	// Redis服务器地址
	@Value ("${spring.redis.host}")
	private String host;
	// Redis服务器连接端口
	@Value("${spring.redis.port}")
	private Integer port;
	// Redis数据库索引（默认为0）
	@Value("${spring.redis.database}")
	private Integer database;
	// Redis服务器连接密码（默认为空）
	@Value("${spring.redis.password}")
	private String password;
	// 连接超时时间（毫秒）
	@Value("${spring.redis.timeout}")
	private Integer timeout;
	
	// 连接池最大连接数（使用负值表示没有限制）
	@Value("${spring.redis.lettuce.pool.max-active}")
	private Integer maxTotal;
	// 连接池最大阻塞等待时间（使用负值表示没有限制）
	@Value("${spring.redis.lettuce.pool.max-wait}")
	private Integer maxWait;
	// 连接池中的最大空闲连接
	@Value("${spring.redis.lettuce.pool.max-idle}")
	private Integer maxIdle;
	// 连接池中的最小空闲连接
	@Value("${spring.redis.lettuce.pool.min-idle}")
	private Integer minIdle;
	// 关闭超时时间
	@Value ("${spring.redis.lettuce.shutdown-timeout}")
	private Integer shutdown;
	
	@Bean
	@Override
	public CacheManager  cacheManager (){
		RedisCacheWriter writer = RedisCacheWriter.nonLockingRedisCacheWriter (getRedisConnectionFactory ());
		
		//创建默认缓存配置对象
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
		RedisCacheManager cacheManager = new RedisCacheManager(writer, config);
		return cacheManager;
	}
	
	@Bean( name = "template")
	public RedisTemplate<String, Object> redisTemplate() {
		//创建RedisTemplate对象
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(getRedisConnectionFactory());
		
		//将RedisTemplate的Value序列化方式由JdkSerializationRedisSerializer更换为Jackson2JsonRedisSerializer
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer (Object.class);
		ObjectMapper om = new ObjectMapper ();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		//RedisTemplate对象需要指明Key序列化方式，如果声明StringRedisTemplate对象则不需要;
		template.setKeySerializer(new StringRedisSerializer ());
		
		template.afterPropertiesSet();
		return template;
	}
	
	/**
	 * 获取缓存连接
	 * @return
	 */
	@Bean
	public RedisConnectionFactory getRedisConnectionFactory(){
		
		//创建缓存连接池
		GenericObjectPoolConfig config = new GenericObjectPoolConfig ();
		config.setMaxTotal(maxTotal);
		config.setMaxWaitMillis(maxWait);
		config.setMaxIdle(maxIdle);
		config.setMinIdle(minIdle);
		LettucePoolingClientConfiguration pool = LettucePoolingClientConfiguration.builder()
							.poolConfig(config)
							.commandTimeout(Duration.ofMillis(timeout))
							.shutdownTimeout(Duration.ofMillis(shutdown))
							.build();
		
		
		//单机模式
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName(host);
		configuration.setPort(port);
		configuration.setDatabase(database);
		configuration.setPassword(RedisPassword.of(password));
		
		
		return  new LettuceConnectionFactory(configuration, pool);
	}
	
}
