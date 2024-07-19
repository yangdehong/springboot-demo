package com.ydh.redsheep.base.common.utils;

public class JoinThread {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        t1.start();
//        t1.join();
        t2.start();
    }

    static class ThreadTest extends Thread {
        private String name;

        public ThreadTest(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + "-" + i);
            }
        }
    }

}
