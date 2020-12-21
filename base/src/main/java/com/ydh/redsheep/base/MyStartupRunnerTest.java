package com.ydh.redsheep.base;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yangdehong
 * @version: 2018/1/11.
 */
@Component
@Order(value = 1) // 启动顺序
public class MyStartupRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) {
        System.out.println(">>>>This is MyStartupRunnerTest Order=1. Only testing CommandLineRunner...<<<<");
    }
}
