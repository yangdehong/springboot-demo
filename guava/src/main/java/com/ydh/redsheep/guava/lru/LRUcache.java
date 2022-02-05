package com.ydh.redsheep.guava.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUcache<k, v> extends LinkedHashMap<k, v> {
    private final int limit;

    public LRUcache(int limit) {
        //初始化 accessOrder ： true 改变尾结点
        super(16, 0.75f, true);
        this.limit = limit;
    }

    //是否删除最老的数据
    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {

        return size() > limit;
    }


}
