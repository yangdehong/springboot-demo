package com.ydh.redsheep.redis.controller;

import com.ydh.redsheep.redis.pojo.User;
import com.ydh.redsheep.redis.service.CacheService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/28.
 */
@RestController
@RequestMapping("redis2")
public class Redis2Controller {

    @Resource
    private CacheService cacheService;

    @RequestMapping("get")
    public String get(Long id){
        User user = cacheService.getById(id);
        return user.toString();
    }

    @RequestMapping("update")
    public String update(Long id){
        User user = new User();
        user.setId(id);
        user.setName("红羊");
        user.setAge(99);
        user.setEmail("3999998@qq.com");
        user.setBirthDay(LocalDateTime.now());
        user.setVersion(1);
        user.setIsDeleted(0);
        cacheService.update(user);
        return "update";
    }

    @RequestMapping("delete")
    public String delete(Long id){
        cacheService.delete(id);
        return "delete";
    }





}
