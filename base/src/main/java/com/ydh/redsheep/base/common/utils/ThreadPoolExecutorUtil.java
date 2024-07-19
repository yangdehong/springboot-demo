package com.ydh.redsheep.base.common.utils;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : yangdehong
 * @date : 2024/7/15 23:06
 */
public class ThreadPoolExecutorUtil {

    public static final int CORE_POOL_SIZE = 10;
    public static final int MAXIMUM_POOL_SIZE = 20;
    public static final int TIME_OUT = 60;
    public static final TimeUnit UNIT = TimeUnit.SECONDS;
    public static final int workQueueSize = 1024;

    public static ExecutorService getShareThreadPool() {
        return Single.install;
    }

    public ExecutorService createThreadPool() {
        return createThreadPool(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, TIME_OUT, UNIT);
    }

    public ExecutorService createThreadPool(int corePoolSize, int maximumPoolSize, int workQueueSize) {
        return createThreadPool(corePoolSize, maximumPoolSize, TIME_OUT, UNIT, workQueueSize);
    }

    public ExecutorService createThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        return createThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<>(workQueueSize));
    }

    public ExecutorService createThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, int workQueueSize) {
        return createThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, unit, new LinkedBlockingQueue<>(workQueueSize));
    }

    public ExecutorService createThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        return createThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new MyThreadFactory());
    }

    public ExecutorService createThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        return createThreadPool(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    public ExecutorService createThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    private static class Single {
        static ExecutorService install = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, TIME_OUT, UNIT, new LinkedBlockingQueue<>(workQueueSize), new MyThreadFactory());
    }

    static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "my-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        MyThreadFactory(String poolName) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = poolName;
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY) t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = ThreadPoolExecutorUtil.getShareThreadPool();
        AtomicInteger at = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            int index = at.getAndIncrement();
            executorService.submit(() -> {
                if (index == 1) {
                    int j = 1/0;
                }
                try {
                    Thread.sleep(new Random().nextInt(10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello world" + index);
            });
        }
    }

}
