package com.ydh.redsheep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ydh.redsheep.*.mapper")
@SpringBootApplication
public class BaseApplication {

	public static void main(String[] args) {
		registryShutdownHook();
		SpringApplication.run(BaseApplication.class, args);
	}

	private static void registryShutdownHook() {
		System.out.println("加入钩子程序......");
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("执行钩子线程");
		}));
		System.out.println("钩子程序启动完成......");
	}

}
