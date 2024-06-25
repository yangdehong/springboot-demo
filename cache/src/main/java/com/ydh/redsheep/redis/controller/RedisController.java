package com.ydh.redsheep.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/28.
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("add")
    public String add(String key, String value){
        redisTemplate.opsForValue().set(key, value);
        return "redis";
    }


    @RequestMapping("get")
    public String get(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }


    @RequestMapping("lua")
    public String lua(){
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);//返回类型是Long
        //lua文件存放在resources目录下的redis文件夹内
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/test.lua")));
        Long result = (Long) redisTemplate.execute(redisScript, Arrays.asList("age"), 11);
        return "lock==" + result;
    }

}
