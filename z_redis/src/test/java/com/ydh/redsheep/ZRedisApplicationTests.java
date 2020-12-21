package com.ydh.redsheep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZRedisApplicationTests {

	@Resource
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

		redisTemplate.opsForZSet().add("test_key", "value", 1111);
		redisTemplate.opsForZSet().add("test_key", "value1", 2222);
		redisTemplate.opsForZSet().add("test_key", "value2", 3333);
		redisTemplate.opsForZSet().add("test_key", "value3", 4444);
		redisTemplate.opsForZSet().add("test_key", "value4", 4444);

		redisTemplate.opsForZSet().remove("test_key", "value");
		redisTemplate.opsForZSet().remove("test_key", "value3");

	}

}
