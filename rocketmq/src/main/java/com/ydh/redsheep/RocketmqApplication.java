package com.ydh.redsheep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RocketmqApplication {

	public static void main(String[] args) {
		registryShutdownHook();
		SpringApplication.run(RocketmqApplication.class, args);
	}

	private static void registryShutdownHook() {
		System.out.println("加入钩子程序......");
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("执行钩子线程");
		}));
		System.out.println("钩子程序启动完成......");
	}

}
