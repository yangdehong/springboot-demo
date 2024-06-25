package com.ydh.redsheep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
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
