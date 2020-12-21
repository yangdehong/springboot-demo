package com.ydh.redsheep.z_zookeeper.zk.util;

import org.apache.curator.framework.CuratorFramework;

/**
 * @description: 分布式锁工厂类
 * @author: yangdehong
 * @version: 2018/1/9.
 */
public class DistributeLockFactory {

    CuratorFramework curatorFramework;

    public DistributeLockFactory(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    public static final String ZK_LOCK_ROOT = "/ZK_LOCK_ROOT";
    public static final String ZK_LOCK_ROOT_2 = ZK_LOCK_ROOT + "/";

    public DistributeLock newLock(String monitor) {

        if (!monitor.startsWith("/")) {
            monitor = ZK_LOCK_ROOT_2 + monitor;
        } else {
            monitor = ZK_LOCK_ROOT + monitor;
        }

        return new CuratorLock(curatorFramework, monitor);
    }

}
