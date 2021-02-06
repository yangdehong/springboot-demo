package com.ydh.redsheep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DlxTests {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Test
	public void dlx() throws Exception{
		rabbitTemplate.convertAndSend("ex.biz", "key.biz", "送单到XXXXXXXX，请在10秒内接受任务");
	}
	@Test
	public void get() throws Exception{
		String notGo = (String) rabbitTemplate.receiveAndConvert("queue.dlx");
		System.out.println(notGo);
	}

}
