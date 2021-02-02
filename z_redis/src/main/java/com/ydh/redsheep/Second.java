package com.ydh.redsheep;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用redis的watch和自增来做秒杀
 *
 * @author : yangdehong
 * @date : 2021/2/2 19:56
 */
public class Second {

    public static void main(String[] arg) {
        String redisKey = "lock";
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            Jedis jedis = new Jedis("172.16.131.10", 6379); // 初始值
            jedis.auth("123456");
            jedis.set(redisKey, "0");
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                Jedis jedis1 = new Jedis("172.16.131.10", 6379);
                jedis1.auth("123456");
                try {
                    jedis1.watch(redisKey);
                    String redisValue = jedis1.get(redisKey);
                    int valInteger = Integer.valueOf(redisValue);
                    String userInfo = UUID.randomUUID().toString();
                    // 没有秒完
                    if (valInteger < 20) {
                        Transaction tx = jedis1.multi();
                        tx.incr(redisKey);
                        List list = tx.exec();
                        // 秒成功 失败返回空list而不是空
                        if (list != null && list.size() > 0) {
                            System.out.println("用户:" + userInfo + "，秒杀成功! 当前成功人数:" + (valInteger + 1));
                        }
                        // 版本变化，被别人抢了。
                        else {
                            System.out.println("用户:" + userInfo + "，秒杀失败");
                        }
                    }
                    // 秒完了
                    else {
                        System.out.println("已经有20人秒杀成功，秒杀结束");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    jedis1.close();
                }
            });
        }
        executorService.shutdown();
    }

}
