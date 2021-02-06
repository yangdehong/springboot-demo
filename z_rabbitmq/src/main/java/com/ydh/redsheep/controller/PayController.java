package com.ydh.redsheep.controller;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
public class PayController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/buy")
    public String buy() {
        rabbitTemplate.convertAndSend("ex.pay", "key.pay", "mac pro 2021 10台");
        return "下单成功，未支付";
    }
    @RequestMapping("/pay")
    public String pay() {
        String pay = (String) rabbitTemplate.receiveAndConvert("queue.pay");
        System.out.println(pay);

        return pay;
    }

}
