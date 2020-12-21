package com.ydh.redsheep.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/13.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("say")
    public String say(){
        return "Hello Spring Boot!";
    }

}
