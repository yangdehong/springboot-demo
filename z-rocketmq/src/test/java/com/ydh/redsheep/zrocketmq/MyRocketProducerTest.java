package com.ydh.redsheep.zrocketmq;

import org.apache.rocketmq.client.MQAdmin;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageExt;
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
        for (int i = 0; i < 10; i++) {
            // 用于向broker发送消息
            // 第一个参数是topic名称
            // 第二个参数是消息内容
            this.rocketMQTemplate.sendMessageInTransaction(
                    "txGroup",
                    "tx-01",
                    MessageBuilder.withPayload("springboot: hello ydh" + i).build(),
                    ""
            );
        }
    }

    @Test
    public void testDelayMessages() {
        SendResult sendResult = rocketMQTemplate.syncSend("delay-topic", MessageBuilder.withPayload("延迟小心队列测试").build(), 2000, 10);
        System.out.println("sendResult is " + sendResult);
    }

}
