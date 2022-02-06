package com.ydh.redsheep.database.common.config;

/**
*
* @author : yangdehong
* @date : 2022/2/6 11:03
*/
public class RoutingDataSourceContext {

    // holds data source key in thread local:
    static final ThreadLocal<String> threadLocalDataSourceKey = new ThreadLocal<>();

    public static String getDataSourceRoutingKey() {
        String key = threadLocalDataSourceKey.get();
        return key == null ? "masterDataSource" : key;
    }

    public RoutingDataSourceContext(String key) {
        threadLocalDataSourceKey.set(key);
    }
    public void close() {
        threadLocalDataSourceKey.remove();
    }

}
