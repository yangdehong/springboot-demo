package com.ydh.redsheep.z_zookeeper.zk.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/1/9.
 */
public class CuratorLock implements DistributeLock {

    InterProcessMutex lock;

    public CuratorLock(CuratorFramework client, String monitor) {
        lock = new InterProcessMutex(client, monitor);
    }

    @Override
    public void lock() {
        try {
            lock.acquire();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unlock() {
        try {
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
