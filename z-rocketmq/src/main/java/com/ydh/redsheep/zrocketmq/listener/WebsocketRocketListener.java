package com.ydh.redsheep.zrocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RocketMQMessageListener(
        topic = "websocket",
        selectorExpression = "rocketmq",
        messageModel = MessageModel.BROADCASTING,
        consumerGroup = "ws"
)
public class WebsocketRocketListener implements RocketMQListener<WebSocketSession> {

    @Override
    public void onMessage(WebSocketSession session) {
        System.out.println(session);
    }

}
