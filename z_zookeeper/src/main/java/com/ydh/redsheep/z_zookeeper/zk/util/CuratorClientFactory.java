package com.ydh.redsheep.z_zookeeper.zk.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/1/9.
 */
public class CuratorClientFactory {

    private String zkServer;
    private CuratorFramework client = null;

    public CuratorClientFactory(String zkServer) {
        this.zkServer = zkServer;
    }

    public CuratorFramework getCuratorClient(){
        if(client==null){
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.newClient(zkServer,5000,5000, retryPolicy);
            client.start();
        }
        return client;
    }
}
