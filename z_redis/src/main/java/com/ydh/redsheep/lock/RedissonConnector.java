package com.ydh.redsheep.lock;

import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description: 获取RedissonClient连接类
 * @author: yangdehong
 * @version: 2018/2/12.
 */
@Component
public class RedissonConnector {

    RedissonClient redisson;

    @PostConstruct
    public void init(){

//        Config config = new Config();
//        config.useSingleServer().setAddress("47.97.121.152:6379");
//        config.useSingleServer().setPassword("redis");
//
//        redisson = Redisson.create(config);
    }

    public RedissonClient getClient(){
        return redisson;
    }

}
