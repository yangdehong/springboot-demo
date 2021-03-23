package com.ydh.redsheep.zrocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest
public class MyRocketProducerTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void testSendMessage() {
        // 用于向broker发送消息
        // 第一个参数是topic名称
        // 第二个参数是消息内容
        this.rocketMQTemplate.convertAndSend(
                "sb-01",
                "springboot: hello ydh"
        );
    }

    @Test
    public void testSendMessages() {
        for (int i = 0; i < 100; i++) {
            // 用于向broker发送消息
            // 第一个参数是topic名称
            // 第二个参数是消息内容
            this.rocketMQTemplate.convertAndSend(
                    "sb-01",
                    "springboot: hello ydh" + i
            );
        }
    }

    @Test
    public void testTxSendMessages() {
        for (int i = 0; i < 100; i++) {
            // 用于向broker发送消息
            // 第一个参数是topic名称
            // 第二个参数是消息内容
            this.rocketMQTemplate.sendMessageInTransaction(
                    "txGroup",
                    "sb-01",
                    MessageBuilder.withPayload("springboot: hello ydh" + i).build(),
                    ""
            );
        }
    }
}
