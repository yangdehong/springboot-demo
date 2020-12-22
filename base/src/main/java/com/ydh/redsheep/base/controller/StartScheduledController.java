//package com.ydh.redsheep.base.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.ScheduledFuture;
//
///**
// * @Auther: yangdehong
// * @Date: 2018/5/15 10:39
// * @Description:
// */
//@RestController
//public class StartScheduledController {
//
//
//    @Autowired
//    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
//
//
//    private List<ScheduledFuture<?>> futureList = new ArrayList<>();
//
//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//        return new ThreadPoolTaskScheduler();
//    }
//
//    @RequestMapping("/startCron")
//    public String startCron() {
//        String message = "开始任务1";
//        String cron = "0/5 * * * * *";
//        ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(new MyRunnable(message), new CronTrigger(cron));
//        futureList.add(future);
//        System.out.println(message);
//        return message;
//    }
//
//    @RequestMapping("/stopCron")
//    public String stopCron() {
//        if (futureList != null) {
//            for (ScheduledFuture<?> future : futureList) {
//                future.cancel(true);
//            }
//        }
//        System.out.println("DynamicTask.stopCron()");
//        return "stopCron";
//    }
//
//    @RequestMapping("/startCron10")
//    public String startCron10() {
//        String message = "开始任务2";
//        String cron = "0/10 * * * * *";
//        ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(new MyRunnable(message), new CronTrigger(cron));
//        futureList.add(future);
//        System.out.println(message);
//        return message;
//    }
//
//    private class MyRunnable implements Runnable {
//
//        private String message;
//
//        public MyRunnable(String message) {
//            this.message = message;
//        }
//
//        @Override
//        public void run() {
//            System.out.println(message + new Date());
//        }
//    }
//
//
//}
