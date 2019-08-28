package com.floyd.redis.config;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 注释
 *
 * @author floyd
 * @version : RedisUtil.java, v 0.1 2019/8/28 14:43 By floyd Edit  $$
 */

@Component
public class RedisUtil {
	
	@Resource(name = "template")
	private RedisTemplate<String,String> template;
	
	public  boolean set(String key, String value, long validTime) {
		
		boolean result = template.execute(new RedisCallback<Boolean> () {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws
									     DataAccessException {
				RedisSerializer<String> serializer = template.getStringSerializer();
				connection.set(serializer.serialize(key), serializer.serialize(value));
				if ( validTime > 0 ) {
					connection.expire(serializer.serialize(key), validTime);
				}
				return true;
			}
		});
		return result;
	}
	
	public  <T> boolean set(String key, T value) {
		Gson gson = new Gson();
		return set (key, gson.toJson(value),0);
	}
	
	public  <T> T get(String key, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(get(key), clazz);
	}
	
	public  String get(String key) {
		String result = template.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = template.getStringSerializer();
				byte[] value = connection.get(serializer.serialize(key));
				return serializer.deserialize(value);
			}
		});
		return result;
	}
	
	public  boolean del(String key) {
		return template.delete(key);
	}
}
