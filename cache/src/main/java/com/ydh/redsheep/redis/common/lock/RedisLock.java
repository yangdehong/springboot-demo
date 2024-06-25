package com.ydh.redsheep.redis.common.lock;

import io.lettuce.core.RedisClient;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLock {

    //从配置类中获取redisson对象
    private static final String LOCK_TITLE = "redisLock_"; //加锁

    @Resource
    private RedissonClient redissonClient;

    public boolean acquire(String lockName) { //声明key对象
        String key = LOCK_TITLE + lockName; //获取锁对象
        RLock mylock = redissonClient.getLock(key); //加锁，并且设置锁过期时间3秒，防止死锁的产生 uuid+threadId
        mylock.lock(30, TimeUnit.SECONDS); //加锁成功
        return true;
    }

    //锁的释放
    public void release(String lockName) {
        //必须是和加锁时的同一个key
        String key = LOCK_TITLE + lockName;
        //获取所对象
        RLock mylock = redissonClient.getLock(key);
        //释放锁(解锁)
        mylock.unlock();
    }


}
