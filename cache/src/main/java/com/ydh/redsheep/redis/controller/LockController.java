package com.ydh.redsheep.redis.controller;

import com.ydh.redsheep.redis.common.lock.RedisLock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/2/12.
 */
@RestController
@RequestMapping("lock")
public class LockController {

    @Resource
    private RedisLock redisLock;

    @RequestMapping(value = "/redlock")
    public String testRedlock() throws Exception{
        String key = "lock001";
        //加锁
        redisLock.acquire(key);
        //执行具体业务逻辑
        System.out.println("分布式锁");
        //释放锁
        redisLock.release(key);

        return "分布式锁";
    }


}
