package com.ydh.redsheep.lock;

/**
 * @description: 获取锁后需要处理的逻辑
 * @author: yangdehong
 * @version: 2018/2/12.
 */
public interface AquiredLockWorker<T> {

    T invokeAfterLockAquire() throws Exception;

}
