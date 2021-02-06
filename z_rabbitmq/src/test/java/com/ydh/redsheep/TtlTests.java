package com.ydh.redsheep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TtlTests {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Test
	public void ttl() throws Exception{

		rabbitTemplate.convertAndSend("ex.ttl", "key.ttl", "发送了TTL-MESSAGE");

	}
	@Test
	public void ttlWaiting() throws Exception{
		MessageProperties properties = new MessageProperties();
		properties.setExpiration("5000");
		Message message = new Message("发送了WAITING- MESSAGE".getBytes("utf-8"), properties);
		rabbitTemplate.convertAndSend("ex.ttl-waiting", "key.ttl-waiting", message);
	}

}
