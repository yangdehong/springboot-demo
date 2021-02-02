package com.ydh.redsheep.redis.controller;

import com.ydh.redsheep.lock.DistributedRedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/2/12.
 */
@RestController
@RequestMapping("lock")
public class LockController {

    @RequestMapping(value = "/redlock")
    public String testRedlock() throws Exception{
        String key = "lock001";
        //加锁
        DistributedRedisLock.acquire(key);
        //执行具体业务逻辑
        System.out.println("分布式锁");
        //释放锁
        DistributedRedisLock.release(key);

        return "";
    }


}
