package com.ydh.redsheep.guava.demo;

import com.google.common.cache.*;
import com.ydh.redsheep.guava.constants.Constants;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


public class Demo {

    public static void main(String[] args) throws Exception {
        //CacheLoader的方式创建
        LoadingCache<String,Object> cache= CacheBuilder.newBuilder()
                /*
                     加附加的功能
                 */
                //最大个数
                .maximumSize(3)
                // 设置并发数，Runtime.getRuntime().availableProcessors()=CPU的内核数
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                // 如果再并发的时候，cache中没有数据就需要到数据库中去获取，造成缓存击穿
                // 如果经过一定时间没有更新或覆盖，则会在下一次获取该值的时候，会在后台异步去刷新缓存
                // guava的解决方式是只有一个请求回源取数据，其他请求会阻塞(block)在一个固定时间段，如果在该时间段内没 有获得新值则返回旧值。
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                // 等同于expire  ttl  缓存中对象的生命周期就是3秒
//                .expireAfterWrite(3, TimeUnit.SECONDS)
                // 统计
                .recordStats()
                // 弱值的删除，可以通过weakKeys和weakValues方法指定Cache只保存对缓存记录key和value的弱引用。这样当没有其他强引用指向key和value时，key和value对象就会被垃圾回收器回收。
                .weakValues()
                // 删除回调
                .removalListener((RemovalNotification<Object, Object> removalNotification) -> {
                    //移除的key 移除的原因
                    System.out.println("=====listener"+removalNotification.getKey()+":"+removalNotification.getCause());
                }).build(new CacheLoader<String, Object>() {
                    //读取数据源
                    @Override
                    public Object load(String key) throws Exception {
                        return Constants.hm.get(key);
                    }
                });
        //初始化缓存
        initCache(cache);
        System.out.println(cache.size());
        //显示缓存数据
        display(cache);
        //读取缓存中的1的数据    缓存有就读取 没有就返回null
        System.out.println(cache.getIfPresent("1"));

        //读取4   读源并回写缓存  淘汰一个（LRU+FIFO）
        get("4",cache);
        display(cache);
        System.out.println("111111111111111111111");

        System.out.println("222222222222222222222");
        // key=1在中间访问，剩余前面的1s时间就不算了，其他的歇了3.1秒
        Thread.sleep(1000);
        cache.getIfPresent("1");
        Thread.sleep(2100);
        display(cache);

        //打印输出统计
        System.out.println(cache.stats().toString());

        System.out.println("33333333333333333333333");
        Object v = new Object();
        cache.put("1", v);
        v = new Object();
        System.gc();
        display(cache);

        System.out.println("44444444444444444444444");
        //清空
        //   cache.invalidateAll();
        //删除指定key
        //  cache.invalidate("1");
        //删多个
        cache.invalidateAll(Arrays.asList("1","3"));
        display(cache);

    }

    /**
     * 初始化缓存三个
     */
    public static void initCache(LoadingCache<String,Object> cache) throws Exception {
        for(int i=1;i<=3;i++){
            //连接数据源   如果缓存没有则读取数据源
            cache.get(String.valueOf(i));
        }

    }

    /**
     * 显示缓存里的数据
     * @param cache
     */
    public static void display(LoadingCache<String,Object> cache){
        //利用迭代器
        Iterator its=cache.asMap().entrySet().iterator();
        while(its.hasNext()){
            System.out.println(its.next().toString());
        }
    }

    /**
     * 读取缓存数据 如果没有则回调源数据并(自动)写入缓存
     * @param key
     * @param cache
     */
    public static void get(String key,LoadingCache<String,Object> cache) throws Exception {
        cache.get(key, () -> {
            //读源
            Object value= Constants.hm.get(key);
            // 写回缓存，不需要写可以自动加入
            // cache.put(key,value);
            return  value;
        });
    }


}
