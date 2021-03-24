package com.ydh.redsheep.zrocketmq.controller;

import com.ydh.redsheep.zrocketmq.ws.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    //@MessageMapping是消息转发器，对应配置文件的setApplicationDestinationPrefixes
    //                 /app，客户端可以往"/app/hello"发送消息，该注解就会接受消息，交给greeting（）方法处理
    //SentTo对应配置文件的enableSimpleBroker("/topic"); 客户端会订阅stompClient.subscribe('/topic/greetings'）这个通道的消息
    //                 发往该通道的消息，都会被订阅了该通道的客户端接受到。没有订阅的则不接受
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "Hello, " + message.getName() + "!";
    }

}
