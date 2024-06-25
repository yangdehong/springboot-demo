package com.ydh.redsheep;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class CacheApplicationTests {

	@Resource
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

		redisTemplate.opsForValue().set("key", "value");
		redisTemplate.opsForHash().put("k1", "k2", "value");

	}

}
