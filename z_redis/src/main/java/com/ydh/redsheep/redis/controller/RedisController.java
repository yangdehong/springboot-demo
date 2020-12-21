package com.ydh.redsheep.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/28.
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("redis")
    public String mongo(){

        redisTemplate.opsForValue().set("key", "value");
        redisTemplate.opsForHash().put("k1", "k2", "value");

        return "redis";
    }
}
