//package com.ydh.redsheep.z_zookeeper.zk.controller;
//
//import com.ydh.redsheep.z_zookeeper.zk.util.DistributeLock;
//import com.ydh.redsheep.z_zookeeper.zk.util.DistributeLockFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @description:
// * @author: yangdehong
// * @version: 2018/1/11.
// */
//@RestController
//@RequestMapping("zk")
//public class ZKController {
//
//    @Autowired
//    private DistributeLockFactory lockFactory;
//
//    @RequestMapping("/test")
//    public String test(){
//
//        DistributeLock lock = lockFactory.newLock("TestController");
//        try {
//            lock.lock();
//            System.out.println("========");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//
//        return "test";
//    }
//
//}
