package com.ydh.redsheep.zes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableElasticsearchRepositories(basePackages = "com.ydh.redsheep.zes.es")
@EnableJpaRepositories(basePackages = "com.ydh.redsheep.zes.repository")
@SpringBootApplication
public class ZEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZEsApplication.class, args);
    }

}
