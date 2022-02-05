package com.ydh.redsheep.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/13.
 */
@RestController //相当于配置 @Responsebody+@Controller
@RequestMapping("hello")
public class HelloController {

    @GetMapping("say")
    public String say(){
        int a = 1/0;
        return "Hello Spring Boot!";
    }

}
