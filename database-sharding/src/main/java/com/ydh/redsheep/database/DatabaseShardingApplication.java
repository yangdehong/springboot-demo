package com.ydh.redsheep.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan(basePackages = "com.ydh.redsheep.database.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DatabaseShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseShardingApplication.class, args);
    }

}
