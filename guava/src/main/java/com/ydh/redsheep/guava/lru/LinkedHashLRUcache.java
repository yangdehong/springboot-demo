package com.ydh.redsheep.guava.lru;

public class LinkedHashLRUcache<k, v> {
    /**
     * LinkedHashMap（自身实现了ＬＲＵ算法）
     * 有序
     * 每次访问一个元素，都会加到尾部
     */


    int limit;
    LRUcache<k, v> lruCache;

    public LinkedHashLRUcache(int limit) {

        this.limit = limit;
        this.lruCache = new LRUcache(limit);
    }


    public void put(k key, v value) {

        this.lruCache.put(key, value);
    }

    public v get(k key) {

        return this.lruCache.get(key);
    }


    public static void main(String[] args) {
        LinkedHashLRUcache lru = new LinkedHashLRUcache(3);
        lru.put(1, "zhangfei1");
        lru.put(2, "zhangfei2");
        lru.put(3, "zhangfei3");
        lru.get(1);
        lru.put(4, "zhangfei4");
        for (Object o : lru.lruCache.values()) {
            System.out.println(o.toString());
        }
    }
}

