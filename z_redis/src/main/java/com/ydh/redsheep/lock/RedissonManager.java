package com.ydh.redsheep.lock;

import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonManager {

    private static Config config = new Config(); //声明redisso对象
    private static Redisson redisson = null;
    //实例化 redisson

    static {
        config.useClusterServers()
                // 集群状态扫描间隔时间，单位是毫秒
                .setScanInterval(2000)
                //cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
//                .addNodeAddress("redis://127.0.0.1:6379")
//                .addNodeAddress("redis://127.0.0.1:6380")
//                .addNodeAddress("redis://127.0.0.1:6381")
//                .addNodeAddress("redis://127.0.0.1:6382")
//                .addNodeAddress("redis://127.0.0.1:6383")
                .addNodeAddress("redis://172.16.131.10:6384");
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);
    }

    //获取redisson对象的方法
    public static Redisson getRedisson() {
        return redisson;
    }
}
