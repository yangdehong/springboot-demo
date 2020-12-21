package com.ydh.redsheep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class ZRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZRedisApplication.class, args);
	}

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 防止乱码问题
	 * @return
	 */
	@Bean
	public RedisTemplate redisTemplateInit() {
		//设置序列化Key的实例化对象
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		//设置序列化Value的实例化对象
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		return redisTemplate;
	}
}
