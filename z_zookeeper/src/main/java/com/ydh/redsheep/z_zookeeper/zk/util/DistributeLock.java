package com.ydh.redsheep.z_zookeeper.zk.util;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/1/9.
 */
public interface DistributeLock {

    void lock();

    void unlock();

}
