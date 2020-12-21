package com.ydh.redsheep.rabbitmq.controller;

import com.ydh.redsheep.rabbitmq.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/12/14.
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitmqController {

    @Autowired
    private Producer producer;

    @RequestMapping("test")
    public String test(){
        producer.send();
        return "rabbitmq";
    }

}
