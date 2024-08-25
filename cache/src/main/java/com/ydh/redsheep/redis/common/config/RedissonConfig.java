package com.ydh.redsheep.redis.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisson()
    {
        Config config = new Config();
        config.useSingleServer()
                .setRetryInterval(1000)
                .setTimeout(3000)
                .setConnectTimeout(10000)
                .setAddress("redis://127.0.0.1:6379")
                .setPassword("123456")
                .setDatabase(0);
//        config.useClusterServers()
//                // 集群状态扫描间隔时间，单位是毫秒
//                .setScanInterval(2000)
//                //cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
////                .addNodeAddress("redis://127.0.0.1:6379")
////                .addNodeAddress("redis://127.0.0.1:6380")
////                .addNodeAddress("redis://127.0.0.1:6381")
////                .addNodeAddress("redis://127.0.0.1:6382")
////                .addNodeAddress("redis://127.0.0.1:6383")
//                .addNodeAddress("redis://172.16.98.142:6379")
//                .setPassword("123456");
        return Redisson.create(config);
    }

}
