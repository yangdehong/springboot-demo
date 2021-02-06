package com.ydh.redsheep.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping("/go")
    public String distributeGo() {
        rabbitTemplate.convertAndSend("ex.go", "go", "送单到石景山x小 区，请在10秒内接受任务");
        return "任务已经下发，等待送单。。。";
    }

    @RequestMapping("/notgo")
    public String getAccumulatedTask() {
        String notGo = (String)
                rabbitTemplate.receiveAndConvert("q.go.dlx");
        return notGo;
    }

}
