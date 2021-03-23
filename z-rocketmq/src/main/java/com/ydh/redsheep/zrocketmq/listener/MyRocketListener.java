package com.ydh.redsheep.zrocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(
        topic = "sb-01",
        consumerGroup = "consumer-group-01"
)
public class MyRocketListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        // 处理broker推送过来的消息
        log.info("接受到消息>>>>>>={}",message);
    }
}
