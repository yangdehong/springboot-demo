package com.ydh.redsheep.comsumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PayListener {

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


    @RabbitListener(queues = "queue.dlx.pay")
    public void getMyMessage(Message message, Channel channel) throws IOException {
        System.out.println(">>>>>>"+message);

        final long deliveryTag = message.getMessageProperties().getDeliveryTag();

        channel.basicAck(deliveryTag, false);
    }

}
