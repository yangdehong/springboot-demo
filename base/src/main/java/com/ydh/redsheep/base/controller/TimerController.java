package com.ydh.redsheep.base.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
@EnableScheduling
@Configuration
public class TimerController {

    /**
     * 每秒执行一次
     */
    @Scheduled(fixedRate = 1000)
    public void task1() {
        // 间隔2分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务1:"+current.getId());
    }

    /**
     * 第一次完成10秒后执行，当执行完后2秒再执行
     */
    @Scheduled(initialDelay = 10000, fixedDelay = 2000)
    public void task2() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        // 间隔1分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        System.out.println("定时任务2:"+current.getId());
    }

    /**
     * 每次隔5分钟
     */
    @Scheduled(cron="*/5 * * * * ?")
    public void task3() {

        Thread current = Thread.currentThread();
        System.out.println("定时任务3:"+current.getId());
    }

    @Scheduled(fixedRateString = "1000")
    public void task4() {

        Thread current = Thread.currentThread();
        System.out.println("定时任务4:"+current.getId());
    }

}
