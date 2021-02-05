package com.ydh.redsheep.controller;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class MessageController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/rabbit")
    public String receive(@RequestParam String message) throws UnsupportedEncodingException {

        final MessageProperties messageProperties = MessagePropertiesBuilder.newInstance().setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setContentEncoding("utf-8")
                .setHeader("hello", "world")
                .build();

        final Message msg = MessageBuilder
                .withBody(message.getBytes("utf-8"))
                .andProperties(messageProperties)
                .build();

        rabbitTemplate.send("ex.boot", "key.boot", msg);

        return "ok";
    }

}
