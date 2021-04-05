package com.ydh.redsheep;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests {

	@Test
	public void contextLoads() {
		log.info("123");
		log.debug("123");
		log.error("123");
	}

}
