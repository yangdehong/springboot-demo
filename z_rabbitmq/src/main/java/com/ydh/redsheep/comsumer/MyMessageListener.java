package com.ydh.redsheep.comsumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyMessageListener {

//    @RabbitListener(queues = "queue.boot")
//    public void getMyMessage(@Payload String message, @Header(name = "hello") String value, Channel channel) {
//        System.out.println(message);
//        System.out.println("hello = " + value);
//
//        // 确认消息
//        channel.basicAck();
//        // 拒收消息
//        channel.basicReject();
//    }

    private Integer index = 0;

    @RabbitListener(queues = "queue.boot")
    public void getMyMessage(Message message, Channel channel) throws IOException {
        String value = message.getMessageProperties().getHeader("hello");

        System.out.println(message);
        System.out.println("hello = " + value);

        final long deliveryTag = message.getMessageProperties().getDeliveryTag();

        if (index % 2 == 0) {
            // 确认消息
            channel.basicAck(deliveryTag, false);
        } else {
            // 拒收消息
            channel.basicReject(deliveryTag, false);
        }
        index++;
    }

}
